package com.example.programowanie2.zadania_egz;

import java.util.Arrays;
import java.util.Random;

public class Zad_losowanie {
    public static void main(String[] args) {
        int[][] ints = wypelnijTablice(0, 0);
        System.out.println(Arrays.deepToString(ints));
    }

    private static int[][] wypelnijTablice(int liczbaParzystych, int liczbaNieparzystych) {
        int[][] tablica = new int[2][];
        int[] tablicaParzystych = new int[liczbaParzystych+2];
        int[] tablicaNieparzystych = new int[liczbaNieparzystych+2];

        int parzyste = 0;
        int nieparzyste = 0;

        Random rand = new Random();

        while (parzyste < liczbaParzystych) {
            int liczba = rand.nextInt(10);
            if (liczba % 2 != 0) continue;
            tablicaParzystych[parzyste] = liczba;
            parzyste++;
        }
        tablicaParzystych[parzyste] = liczSrednia(tablicaParzystych);
        tablicaParzystych[parzyste+1] = znajdzMinimum(tablicaParzystych);

        while (nieparzyste < liczbaNieparzystych) {
            int liczba = rand.nextInt(10);
            if (liczba % 2 == 0) continue;
            tablicaNieparzystych[nieparzyste] = liczba;
            nieparzyste++;
        }
        tablicaNieparzystych[nieparzyste] = liczSrednia(tablicaNieparzystych);
        tablicaNieparzystych[nieparzyste+1] = znajdzMaksimum(tablicaNieparzystych);

        tablica[0] = tablicaParzystych;
        tablica[1] = tablicaNieparzystych;
        return tablica;
    }

    private static int liczSrednia(int[] tablica) {
        int dlugoscEfektywnaTablicy = tablica.length - 2;
        int suma = 0;
        for (int i = 0; i < dlugoscEfektywnaTablicy; i++) {
            suma += tablica[i];
        }
        return suma / dlugoscEfektywnaTablicy;
    }

    private static int znajdzMinimum(int[] tablica) {
        int dlugoscEfektywnaTablicy = tablica.length - 2;
        int min = tablica[0];
        for (int i = 1; i < dlugoscEfektywnaTablicy; i++) {
            if (tablica[i] < min) min = tablica[i];
        }
        return min;
    }

    private static int znajdzMaksimum(int[] tablica) {
        int dlugoscEfektywnaTablicy = tablica.length - 2;
        int max = tablica[0];
        for (int i = 1; i < dlugoscEfektywnaTablicy; i++) {
            if (tablica[i] > max) max = tablica[i];
        }
        return max;
    }
}
