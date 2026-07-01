package com.example.programowanie2.zadania_egz;


import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Napisać klasę Testy reprezentującą informacje o odpowiedziach na pytania testowe.
 * Klasa powinna zawierać pole prywatne typu char[][] - tablicę z listą poprawnych odpowiedzi
 * (pierwszy wymiar - numer testu, drugi wymiar - numer pytania).
 * Konstruktor z dwoma parametrami (liczba testów, liczba pytań) powinien tworzyć i zainicjować odpowiednie
 * elementy tablicy na wartość 'X'.
 *
 * Zdefiniować metody publiczne:
 *     - float obliczWynik(int nrTestu, char[] odpowiedzi) - oblicza i zwraca wynik dla podanego testu w postaci
 *       procentu dobrych odpowiedzi
 *     - boolean zaliczonyTest(int nrTestu, char[] odpowiedzi) - zwraca true, jeśli procent dobrych odpowiedzi jest
 *       większy niż 50, w przeciwnym wypadku false
 *     - void wpiszOdpowiedz(int nrTestu, int nrPytania, char odpowiedz) - wpisuje poprawną odpowiedź
 *     - void piszDane(int test) - wyświetla na konsolę poprawne odpowiedzi (w jednym wierszu: numer testu, lista
 *       odpowiedzi) rozdzielone przecinkami
 */

public class Zad_klasa_1 {

    public static void main(String[] args) {
        var testy = new Testy(3, 4);
        testy.wpiszOdpowiedz(0, 0, 'A');
        testy.wpiszOdpowiedz(0, 1, 'B');
        testy.wpiszOdpowiedz(0, 2, 'C');
        testy.wpiszOdpowiedz(0, 3, 'D');
        testy.piszDane(0);

        char[] odp  = new char[]{'A', 'B', 'C', 'A'};
        float wynik = testy.obliczWynik(0, odp);
        boolean zaliczony = testy.zaliczonyTest(0, odp);
        System.out.printf("Wynik: %s (test %s)", wynik, zaliczony ? "zaliczony" : "niezaliczony");
    }
}

class Testy {
    private char[][] poprawneOdp; // [nr testu][nr pytania]

    Testy(int liczbaTestow, int liczbaPytan) {
        poprawneOdp = new char[liczbaTestow][liczbaPytan];

        for (int i = 0; i < liczbaTestow; i++) {
//            for (int j = 0; j < liczbaPytan; j++) {
//                odpowiedzi[i][j] = 'X';
//
//            }
            Arrays.fill(poprawneOdp[i], 'X');
        }
    }

    float obliczWynik(int nrTestu, char[] odpowiedzi) {
        int ilePoprawnych = 0;
        char[] poprawne = poprawneOdp[nrTestu];
        for (int i = 0; i < odpowiedzi.length; i++) {
            if (odpowiedzi[i] == poprawne[i]) ilePoprawnych++;
        }
        return ilePoprawnych * 100f / poprawne.length;
    }

    boolean zaliczonyTest(int nrTestu, char[] odpowiedzi) {
        return obliczWynik(nrTestu, odpowiedzi) > 50f;
    }

    void wpiszOdpowiedz(int nrTestu, int nrPytania, char odpowiedz) {
        poprawneOdp[nrTestu][nrPytania] = odpowiedz;
    }

    void piszDane(int test) {
        char[] odp = poprawneOdp[test];

        String wynik = new String(odp).chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining(", "));
        System.out.printf("%s, %s%n", test, wynik);
    }
}

