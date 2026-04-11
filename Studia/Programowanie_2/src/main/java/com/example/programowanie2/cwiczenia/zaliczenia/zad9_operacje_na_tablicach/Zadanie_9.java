package com.example.programowanie2.cwiczenia.zaliczenia.zad9_operacje_na_tablicach;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Zadanie_9 {
    public static void main(String[] args) {
        new OperacjeNaTablicach().run();
    }
}


class OperacjeNaTablicach {
    private final ArrayService arrayService;
    private final InputHandler inputHandler;
    private final Printer printer;

    OperacjeNaTablicach() {
        printer = new Printer();
        inputHandler = new InputHandler(printer);
        arrayService = new ArrayService(printer);
    }

    void run() {
        printer.printAppInfo();

        try(inputHandler) {
            while (true) {
                printer.printMenu();
                int choice = inputHandler.getIntegerValue("Wybierz opcję: ");

                if (choice == MenuOption.WYJSCIE.getId()) break;

                MenuOption.fromInt(choice).ifPresentOrElse(
                        arrayService::handleMenuOption,
                        () -> printer.printError("Nie ma takiej opcji!")
                );
                printer.printSeparator();
            }
        }
        printer.println("Koniec programu.");
    }
}


enum MenuOption {
    WYPELNIANIE_LOSOWE(1,
            "Pokaż wypełnianie tablicy jedynkami",
            """
            Wypełnianie tablicy losowymi wartościami
                - ilość wierszy: %d
                - ilość kolumn: %d
                - zakres liczb: od %d do %d
                - tablica wynikowa:
            %s"""
    ),
    WYPELNIANIE_PRZEKATNYCH_JEDYNKAMI(2,
            "Pokaż wypełnianie przekątnych tablicy jedynkami",
            """
            Wypełnianie przekątnych tablicy jedynkami
                - rozmiar tablicy: %1$d x %1$d
            %2$s"""
    ),
    TRANSPOZYCJA_NOWA_TABLICA(3,
            "Pokaż transpozycję tablicy metodą skopiowania wartości do nowej tablicy",
            """
            Transponowanie tablicy metodą skopiowania wartości do nowej tablicy
                - tablica nie musi być kwadratowa
                - tablica oryginalna:
            %s
                - tablica przetransponowana:
            %s"""
    ),
    TRANSPOZYCJA_PRZESTAWIANIE(4,
            "Pokaż transpozycję tablicy metodą przestawiania elementów wewnątrz tablicy",
            """
            Transponowanie tablicy metodą przestawiania elementów w tablicy
                - tablica musi być kwadratowa
                - tablica oryginalna:
            %s
                - tablica przetransponowana:
            %s"""
    ),
    MNOZENIE_MACIERZY(5,
            "Pokaż mnożenie dwóch macierzy",
            """
            Mnożenie dwóch macierzy
                - macierz 1:
            %s
                - macierz 2:
            %s
                - macierz wynikowa:
            %s"""
    ),
    WYJSCIE(0, "Wyjście", "");

    private final int id;
    private final String name;
    private final String resultPattern;

    MenuOption(int id, String name, String resultPattern) {
        this.id = id;
        this.name = name;
        this.resultPattern = resultPattern;
    }

    int getId() { return id; }
    String getResultPattern() { return "[%d] %s".formatted(id, resultPattern); }

    static Optional<MenuOption> fromInt(int id) {
        for (MenuOption o : values()) {
            if (o.id == id) return Optional.of(o);
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "[%d] %s".formatted(id, name);
    }
}


class ArrayService {
    private final Printer printer;

    ArrayService(Printer printer) {
        this.printer = printer;
    }

    void handleMenuOption(MenuOption menuOption) {
        switch (menuOption) {
            case WYPELNIANIE_LOSOWE -> pokazWypelnianieTablicy();
            case WYPELNIANIE_PRZEKATNYCH_JEDYNKAMI -> pokazWypelnianieTablicyJedynkami();
            case TRANSPOZYCJA_NOWA_TABLICA -> pokazTransponowanieZNowaTablica();
            case TRANSPOZYCJA_PRZESTAWIANIE -> pokazTransponowanieZPrzestawianiem();
            case MNOZENIE_MACIERZY -> pokazMnozenieMaciezy();
            case WYJSCIE -> {}
        }
    }

    private void pokazWypelnianieTablicy() {
        int wiersze = 3;
        int kolumny = 7;
        int min = 4;
        int max = 24;
        int[][] tablica = ObliczeniaTablicowe.wypelnijTablice(new int[wiersze][kolumny], min, max);
        printer.println(MenuOption.WYPELNIANIE_LOSOWE.getResultPattern()
                .formatted(wiersze, kolumny, min, max, TableFormatter.format(tablica))
        );
    }

    private void pokazWypelnianieTablicyJedynkami() {
        int size = 5;
        int[][] tablica = ObliczeniaTablicowe.wypelnijTabliceZJedynkami(new int[size][size]);
        printer.println(MenuOption.WYPELNIANIE_PRZEKATNYCH_JEDYNKAMI.getResultPattern()
                .formatted(size, TableFormatter.format(tablica))
        );
    }

    private void pokazTransponowanieZNowaTablica() {
        int[][] tablica = ObliczeniaTablicowe.wypelnijTablice(new int[3][7], 1, 100);
        int[][] tablicaWynikowa = ObliczeniaTablicowe.transponujTablice1(tablica);
        printer.println(MenuOption.TRANSPOZYCJA_NOWA_TABLICA.getResultPattern()
                .formatted(
                        TableFormatter.format(tablica),
                        TableFormatter.format(tablicaWynikowa)
                )
        );
    }

    private void pokazTransponowanieZPrzestawianiem() {
        int[][] tablica = ObliczeniaTablicowe.wypelnijTablice(new int[3][3], 1, 100);
        int[][] tablicaOryginalna = Arrays.stream(tablica).map(int[]::clone).toArray(int[][]::new);
        int[][] tablicaWynikowa = ObliczeniaTablicowe.transponujTablice2(tablica);
        printer.println(MenuOption.TRANSPOZYCJA_PRZESTAWIANIE.getResultPattern()
                .formatted(
                        TableFormatter.format(tablicaOryginalna),
                        TableFormatter.format(tablicaWynikowa)
                )
        );
    }

    private void pokazMnozenieMaciezy() {
        int[][] macierz1 = ObliczeniaTablicowe.wypelnijTablice(new int[3][3], 1, 10);
        int[][] macierz2 = ObliczeniaTablicowe.wypelnijTablice(new int[3][3], 1, 10);
        int[][] macierzWynikowa = ObliczeniaTablicowe.mnozenieMacierzy(macierz1, macierz2);
        printer.println(MenuOption.MNOZENIE_MACIERZY.getResultPattern()
                .formatted(
                        TableFormatter.format(macierz1),
                        TableFormatter.format(macierz2),
                        TableFormatter.format(macierzWynikowa)
                )
        );
    }
}


class ObliczeniaTablicowe {

    static int[][] wypelnijTablice(int[][] t, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = rand.nextInt((max - min) + 1) + min;
            }
        }
        return t;
    }

    static int[][] wypelnijTabliceZJedynkami(int[][] t) {
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

    static int[][] transponujTablice1(int[][] t) {
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

    static int[][] transponujTablice2(int[][] t) {
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

    static int[][] mnozenieMacierzy(int[][] A, int[][] B) {
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


class InputHandler implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer;

    InputHandler(Printer printer) {
        this.printer = printer;
    }

    int getIntegerValue(String message) {
        Integer result = null;
        while (result == null) {
            printer.println(message);
            var input = scanner.nextLine().trim().replace(",", ".");
            try {
                result = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                printer.printError("Błąd: Proszę wprowadzić poprawną liczbę całkowitą.");
            }
        }
        return result;
    }

    @Override
    public void close() {
        scanner.close();
    }
}


class TableFormatter {
    static String format(int[][] tab) {
        return Arrays.stream(tab)
                .map(wiersz -> Arrays.stream(wiersz)
                        .mapToObj(el -> String.format("%5d", el))
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }
}


class Printer {
    private final String separator = "-".repeat(52);

    void printAppInfo() {
        printSeparator();
        println("Program przedstawiający wybrane funkcje na tablicach");
        printSeparator();
    }

    void printMenu() {
        Arrays.stream(MenuOption.values()).forEach(el -> println(el.toString()));
        printSeparator();
    }

    void println(String message) {
        System.out.println(message);
    }

    void printSeparator() {
        println(separator);
    }

    void printError(String message) {
        println("\u001B[31m" + message + "\u001B[0m");
    }
}