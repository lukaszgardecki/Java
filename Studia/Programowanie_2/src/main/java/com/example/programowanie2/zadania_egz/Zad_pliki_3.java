package com.example.programowanie2.zadania_egz;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Dany jest plik tekstowy (o nazwie - bez rozszerzenia - odczytanej z konsoli i uzupełnionej w programie
 * rozszerzeniem "TXT"), w którym zapisano kolejne dane tworzące informację o budynkach:
 *      nazwa (String)
 *      położenie: (String): "miasto"/"wieś"
 *      liczba kondygnacji (int)
 *      ma panele słoneczne (char): 'N' -> NIE, 'T' -> TAK
 *      cena w tysiącach (int)
 *
 * Napisać program, który oblicza nową cenę na podstawie pozostałych danych.
 * Jeżeli dom jest położony w mieście i ma więcej niż 2 kondygnacje, to jego cena maleje o 20%.
 * Jeżeli dom ma panele słoneczne, cena jest podnoszona o 25% (warunki badać w podanej kolejności).
 *
 * Do plików tekstowych o nazwach "<plik>.Oplacalne.TXT" i "<plik>.Nieoplacalne.TXT", gdzie <plik> jest nazwą pliku
 * z danymi, należy wpisać nazwy i ceny odpowiednich domów w formacie: "nazwa: cena".
 * Opłacalność dla ceny:
 *      < 500,00 opłacalny
 *      500,00-899,99 - nie wiadomo
 *      >= 900,00 - nieopłacalny
 */
public class Zad_pliki_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Dom> domy = new ArrayList<>();

        System.out.println("Podaj nazwę pliku:");
        String nazwaPliku = scanner.nextLine();

        try (Scanner sc = new Scanner(new FileReader(nazwaPliku + ".TXT"))) {
            while(sc.hasNextLine()) {
                String nazwa = sc.next();
                String polozenie = sc.next();
                int kondygnacje = sc.nextInt();
                char maPanele = sc.next().charAt(0);
                int cenaWTys = sc.nextInt();

                if (polozenie.equals("miasto") && kondygnacje > 2) {
                    cenaWTys = (int) (cenaWTys * 0.8);
                }
                if (maPanele == 'T') {
                    cenaWTys = (int) (cenaWTys * 1.25);
                }
                domy.add(new Dom(nazwa, polozenie, kondygnacje, maPanele, cenaWTys));
            }

            var oplacalne = domy.stream().filter(Dom::oplacalny).collect(Collectors.toList());
            var nieOplacalne = domy.stream().filter(Dom::nieoplacalny).collect(Collectors.toList());

            zapiszDoPliku(String.format("%s.Oplacalne.TXT", nazwaPliku), oplacalne);
            zapiszDoPliku(String.format("%s.Nieoplacalne.TXT", nazwaPliku), nieOplacalne);
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        } catch (IOException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

    record Dom(String nazwa, String polozenie, int kondygnacje, char maPanele, int cenaWTys) {
        boolean oplacalny() { return cenaWTys < 500; }
        boolean nieoplacalny() { return cenaWTys >= 900; }
    }

    private static void zapiszDoPliku(String nazwaPliku, List<Dom> domy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku))) {
            for (Dom dom : domy) {
                writer.write("%s: %d".formatted(dom.nazwa(), dom.cenaWTys()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
