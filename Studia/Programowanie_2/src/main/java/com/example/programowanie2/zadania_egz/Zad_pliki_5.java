package com.example.programowanie2.zadania_egz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Dany jest plik binarny z informacjami o komputerach, o strukturze:
 *      cena (liczba rzeczywista)
 *      częstotliwość zegara procesora w GHz (liczba rzeczywista)
 *      wielkość pamięci operacyjnej w GB (liczba całkowita)
 *      wielkość pamięci dyskowej w GB (liczba całkowita)
 *      nazwa komputera (łańcuch znaków)
 *
 * Napisać program, który:
 *    - wczyta nazwę pliku z konsoli
 *    - przetworzy plik "w miejscu" (bez kopiowania do drugiego pliku oraz wczytywania całego pliku do pamięci):
 *        - wpisując cenę wyliczoną jako iloczyn częstotliwości zegara, wielkości pamięci operacyjnej i dyskowej,
 *          podzielone przez 10
 *        - zamieniając pierwszą literę w nazwie komputera na dużą, resztę na małe
 *    - wypisze na konsolę sumaryczny koszt wszystkich komputerów z pliku
 */
public class Zad_pliki_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz nazwę pliku źródłowego:");
        String nazwaPliku = scanner.nextLine();

        double sumaCenWszystkichKomputerow = funkcja(nazwaPliku);
        System.out.println("Suma cen wszystkich komputerów: " + sumaCenWszystkichKomputerow);
    }

    private static double funkcja(String nazwaPliku) {
        double cenaTotal = 0.0;

        try (RandomAccessFile raf = new RandomAccessFile(nazwaPliku, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                long wskaznikCeny = raf.getFilePointer();
                double cena = raf.readDouble();
                double zegar = raf.readDouble();
                int pamiecOperacyjna = raf.readInt();
                int pamiecDyskowa = raf.readInt();
                long wskaznikNazwy = raf.getFilePointer();
                String nazwaKomputera = raf.readUTF();

                cena = zegar * pamiecOperacyjna * pamiecDyskowa / 10;
                cenaTotal += cena;
                nazwaKomputera = nazwaKomputera.substring(0,1).toUpperCase() + nazwaKomputera.substring(1).toLowerCase();

                raf.seek(wskaznikCeny);
                raf.writeDouble(cena);

                raf.seek(wskaznikNazwy);
                raf.writeUTF(nazwaKomputera);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        } catch (IOException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        return cenaTotal;
    }
}
