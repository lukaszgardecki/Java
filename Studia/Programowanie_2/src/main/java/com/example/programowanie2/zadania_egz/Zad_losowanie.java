package com.example.programowanie2.zadania_egz;

import java.util.Arrays;
import java.util.Random;

/**
 * Napisać funkcję o dwóch parametrach: liczbaParzystych i liczbaNieparzystych (typu int), która:
 *      losuje jednocyfrowe liczby całkowite tak długo, aż zostanie wylosowana żądana liczba liczb parzystych
 *      i nieparzystych (zgodnie z wartościami parametrów)
 *
 *      wylosowane liczby umieszcza w tablicy "2-wymiarowej" (pierwszy wiersz - liczby parzyste, drugi - nieparzyste)
 *
 *      na koniec każdego wiersza dopisuje (w odpowiednim wierszu): średnią liczb oraz wartość najmniejszą (dla
 *      parzystych) i największą (dla nieparzystych)
 *
 *      zwraca wypełnioną tablicę
 * UWAGA: napisać osobną funkcję liczącą średnią dla podanego parametrem wiersza.
 */
public class Zad_losowanie {
    public static void main(String[] args) {
        double[][] ints = wypelnijTablice(3, 3);
        System.out.println(Arrays.deepToString(ints));
    }

    private static double[][] wypelnijTablice(int liczbaParzystych, int liczbaNieparzystych) {
        double[][] tablica = new double[2][];
        double[] tablicaParzystych = new double[liczbaParzystych+2];
        double[] tablicaNieparzystych = new double[liczbaNieparzystych+2];
        int parzyste = 0;
        int nieparzyste = 0;
        Random rand = new Random();

        while (parzyste < liczbaParzystych) {
            int liczba = rand.nextInt(100);
            if (liczba % 2 != 0) continue;
            tablicaParzystych[parzyste] = liczba;
            parzyste++;
        }

        while (nieparzyste < liczbaNieparzystych) {
            int liczba = rand.nextInt(100);
            if (liczba % 2 == 0) continue;
            tablicaNieparzystych[nieparzyste] = liczba;
            nieparzyste++;
        }

        tablicaParzystych[parzyste] = liczSrednia(tablicaParzystych);
        tablicaParzystych[parzyste+1] = Arrays.stream(tablicaParzystych).min().getAsDouble();

        tablicaNieparzystych[nieparzyste] = liczSrednia(tablicaNieparzystych);
        tablicaNieparzystych[nieparzyste+1] = Arrays.stream(tablicaNieparzystych).max().getAsDouble();

        tablica[0] = tablicaParzystych;
        tablica[1] = tablicaNieparzystych;
        return tablica;
    }

    private static double liczSrednia(double[] tablica) {
        int dlugosc = tablica.length - 2;
        if (dlugosc == 0) return 0.0;
        double suma = 0.0;
        for (int i = 0; i < dlugosc; i++) {
            suma += tablica[i];
        }
        return Math.round(suma / dlugosc * 100.0) / 100.0;
    }
}
