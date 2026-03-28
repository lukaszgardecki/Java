package com.example.programowanie2.cwiczenia.zaliczenia.zad9_operacje_na_tablicach;

import java.util.Random;

public class Zadanie9 {
    public static void main(String[] args) {
        new OperacjeNaTablicach().run();
    }
}

class OperacjeNaTablicach {
    private final Printer printer;
    private final ObliczeniaTablicowe obliczeniaTablicowe;

    OperacjeNaTablicach() {
        printer = new Printer();
        obliczeniaTablicowe = new ObliczeniaTablicowe();
    }

    void run() {
        printer.printAppInfo();

        pokazWypelnianieTablicy();
        pokazWypelnianieTablicyJedynkami();
        pokazTransponujTablice1();
        pokazTransponujTablice2();
        pokazMnozenieMaciezy();
    }

    private void pokazWypelnianieTablicy() {
        int wiersze = 3;
        int kolumny = 7;
        int min = 4;
        int max = 24;
        printer.println("[1] Wypełnianie tablicy losowymi wartościami---");
        printer.println("ilość wierszy" + wiersze);
        printer.println("ilość kolumn" + kolumny);
        printer.println("Tablica zostanie wypłeniona liczbami z zakresu od %d do %d".formatted(min, max));
        int[][] t = obliczeniaTablicowe.wypelnijTablice(new int[wiersze][kolumny], min, max);
        printer.print(t);
    }

    private void pokazWypelnianieTablicyJedynkami() {
        int size = 5;
        printer.println("[2] Wypełnianie przekątnych tablicy jedynkami");
        printer.println("rozmiar tablicy: " + size);
        int[][] t = obliczeniaTablicowe.wypelnijTabliceZJednkami(new int[size][size]);
        printer.print(t);
    }

    private void pokazTransponujTablice1() {
        printer.println("[3] Transponowanie tablicy metodą skopiowania wartości do nowej tablicy");
        int[][] tab = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printer.println("Tablica oryginalna:");
        printer.print(tab);
        int[][] t = obliczeniaTablicowe.transponujTablice1(tab);
        printer.println("Tablica przetransponowana:");
        printer.print(t);
    }

    private void pokazTransponujTablice2() {
        printer.println("[4] Transponowanie tablicy metodą przestawiania elementów w tablicy");
        int[][] tab = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printer.println("Tablica oryginalna:");
        printer.print(tab);
        int[][] t = obliczeniaTablicowe.transponujTablice1(tab);
        printer.println("Tablica przetransponowana:");
        printer.print(t);
    }

    private void pokazMnozenieMaciezy() {
        int wierszeA = 3;
        int kolumnyA = 3;
        int wierszeB = kolumnyA;
        int kolumnyB = 3;
        printer.println("[5] Transponowanie tablicy metodą przestawiania elementów wewnątrz tablicy");
        printer.println("Tablica 1: ilość wierszy=%d; ilość kolumn=%d".formatted(wierszeA, kolumnyA));
        printer.println("Tablica 2: ilość wierszy=%d; ilość kolumn=%d".formatted(wierszeB, kolumnyB));
        int[][] t = obliczeniaTablicowe.mnozenieMacierzy(
                new int[wierszeA][kolumnyA],
                new int[wierszeB][kolumnyB]
        );
        printer.print(t);
    }
}

class ObliczeniaTablicowe {

    int [][] wypelnijTablice(int[][] t, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = rand.nextInt((max - min) + 1) + min;
            }
        }
        return t;
    }

    int [][] wypelnijTabliceZJednkami(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                boolean diagonal1 = i == j;
                boolean diagonal2 = i == t.length - j - 1;
                if (diagonal1 || diagonal2) {
                    t[i][j] = 1;
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return t;
    }

    int [][] transponujTablice1(int[][] t) {
        if (t == null || t.length == 0) return t;

        int liczbaWierszy = t.length;
        int liczbaKolumn = t[0].length;

        int[][] nowaTablica = new int[liczbaKolumn][liczbaWierszy];

        for (int i = 0; i < liczbaWierszy; i++) {
            for (int j = 0; j < liczbaKolumn; j++) {
                nowaTablica[j][i] = t[i][j];
            }
        }
        return nowaTablica;
    }

    int [][] transponujTablice2(int[][] t) {
        if (t == null || t.length == 0) return null;
        if (t.length != t[0].length) return null;

        for (int i = 0; i < t.length; i++) {
            for (int j = i + 1; j < t.length; j++) {
                int temp = t[i][j];
                t[i][j] = t[j][i];
                t[j][i] = temp;
            }
        }
        return t;
    }

    int[][] mnozenieMacierzy(int[][] A, int[][] B) {
        int wierszeA = A.length;
        int kolumnyA = A[0].length;
        int wierszeB = B.length;
        int kolumnyB = B[0].length;

        if (kolumnyA != wierszeB) return null;

        int[][] wynik = new int[wierszeA][kolumnyB];

        for (int i = 0; i < wierszeA; i++) {
            for (int j = 0; j < kolumnyB; j++) {
                for (int k = 0; k < kolumnyA; k++) {
                    wynik[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return wynik;
    }
}

class Printer {
    private final String separator = "-".repeat(52);

    void printAppInfo() {
        printSeparator();
        println("Program przedstawiający wybrane funkcje na tablicach");
        printSeparator();
    }

    void print(int[][] t) {
        for (int[] wiersz : t) {
            for (int element : wiersz) {
                System.out.printf("%4d ", element);
            }
            System.out.println();
        }
    }

    void println(String message) {
        System.out.println(message);
    }

    void printSeparator() {
        println(separator);
    }
}
