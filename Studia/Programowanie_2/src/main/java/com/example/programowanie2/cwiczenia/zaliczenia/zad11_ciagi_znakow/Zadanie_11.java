package com.example.programowanie2.cwiczenia.zaliczenia.zad11_ciagi_znakow;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Zadanie_11 {
    public static void main(String[] args) {
        new CiagiZnakow().run();
    }
}

class CiagiZnakow {
    private final StringServcie stringServcie;
    private final InputHandler inputHandler;
    private final Printer printer;

    CiagiZnakow() {
        printer = new Printer();
        inputHandler = new InputHandler(printer);
        stringServcie = new StringServcie(inputHandler, printer);
    }

    void run() {
        printer.printAppInfo();

        try(inputHandler) {
            while (true) {
                printer.printMenu();
                int choice = inputHandler.getIntegerValue("Wybierz opcję: ");

                if (choice == MenuOption.WYJSCIE.getId()) break;

                MenuOption.fromInt(choice).ifPresentOrElse(
                        stringServcie::handleMenuOption,
                        () -> printer.printError("Nie ma takiej opcji!")
                );
                printer.printSeparator();
            }
        }
        printer.println("Koniec programu.");
    }
}


enum MenuOption {
    ODWROC_ZNAKI(1, "Odwróć kolejność znaków w napisie"),
    ODWROC_SLOWA(2, "Odwróć kolejność słów w zdaniu"),
    SZYFRUJ_CEZAR(3, "Zaszyfruj tekst szyfrem Cezara"),
    ODSZYFRUJ_CEZAR(4, "Odszyfruj tekst szyfrem Cezara"),
    UPORZADKUJ(5, "Uporządkuj i popraw formatowanie tekstu"),
    WYSTAPIENIA_ZNAKU(6, "Policz wystąpienia wybranego znaku"),
    HISTOGRAM(7, "Wyświetl histogram liter w tekście"),
    PALINDROM(8, "Sprawdź, czy tekst jest palindromem"),
    ANAGRAM(9, "Sprawdź, czy dwa teksty są anagramami"),
    WYJSCIE(0, "Wyjście");

    private final int id;
    private final String name;

    MenuOption(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int getId() { return id; }

    static Optional<MenuOption> fromInt(int id) {
        for (MenuOption o : values()) {
            if (o.id == id) return Optional.of(o);
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", id, name);
    }
}


class StringServcie {
    private final InputHandler inputHandler;
    private final Printer printer;

    StringServcie(InputHandler inputHandler, Printer printer) {
        this.inputHandler = inputHandler;
        this.printer = printer;
    }

    void handleMenuOption(MenuOption menuOption) {
        switch (menuOption) {
            case ODWROC_ZNAKI -> odwrocKolejnoscZnakow();
            case ODWROC_SLOWA -> odwrocKolejnoscSlow();
            case SZYFRUJ_CEZAR -> szyfrujCezar();
            case ODSZYFRUJ_CEZAR -> odszyfrujCezar();
            case UPORZADKUJ -> uporzadkujTekst();
            case WYSTAPIENIA_ZNAKU -> liczWystapieniaZnaku();
            case HISTOGRAM -> stworzHistogramLiter();
            case PALINDROM -> sprawdzCzyTekstJestPalindromem();
            case ANAGRAM -> sprawdzCzyDwaTekstySaAnagramami();
            case WYJSCIE -> {}
        }
    }

    private void odwrocKolejnoscZnakow() {
        String napis = inputHandler.nextLine("Wprowadź tekst, w którym ma zostać odwrócona kolejność znaków:");
        String odwrocony = OperacjeNaCiagachZnakow.odwrocony(napis);
        printer.println("Tekst odwrócony: " + odwrocony);
    }

    private void odwrocKolejnoscSlow() {
        String napis = inputHandler.nextLine("Wprowadź tekst, w którym ma zostać odwrócona kolejność słów:");
        String odwrocony = OperacjeNaCiagachZnakow.przestawioneSlowa(napis);
        printer.println("Tekst odwrócony: " + odwrocony);
    }

    private void szyfrujCezar() {
        String napis = inputHandler.nextLine("Wprowadź tekst, który ma zostać zaszyfrowany na kod Cezara:");
        int klucz = inputHandler.getIntegerValue("Wprowadź klucz (liczba całkowita):");
        String zaszyfrowany = OperacjeNaCiagachZnakow.szyfruj(napis, klucz);
        printer.println("Kod Cezara: " + zaszyfrowany);
    }

    private void odszyfrujCezar() {
        String napis = inputHandler.nextLine("Wprowadź kod Cezara:");
        int klucz = inputHandler.getIntegerValue("Wprowadź klucz (liczba całkowita):");
        String odszyfrowany = OperacjeNaCiagachZnakow.odszyfruj(napis, klucz);
        printer.println("Tekst oryginalny: " + odszyfrowany);
    }

    private void uporzadkujTekst() {
        String napis = inputHandler.nextLine("Wprowadź tekst, który ma zostać uporządkowany:");
        String uporzadkowany = OperacjeNaCiagachZnakow.uporzadkuj(napis);
        printer.println("Tekst uporządkowany: " + uporzadkowany);
    }

    private void liczWystapieniaZnaku() {
        String napis = inputHandler.nextLine("Wprowadź tekst:");
        char znak = inputHandler.getCharValue("Wprowadź znak, którego wystąpienia mają zostać policzone:");
        int iloscWystapien = OperacjeNaCiagachZnakow.liczbaWystapien(napis, znak);
        printer.println("Ilość wystąpień znaku '%s' to %d".formatted(znak, iloscWystapien));
    }

    private void stworzHistogramLiter() {
        String napis = inputHandler.nextLine("Wprowadź tekst:");
        int[] histogram = OperacjeNaCiagachZnakow.histogram(napis);
        printer.println("Histogram liter A-Z:");
        for (int i = 0; i < histogram.length; i++) {
            char litera = (char) ('A' + i);
            printer.println("%s: %d".formatted(litera, histogram[i]));
        }
    }

    private void sprawdzCzyTekstJestPalindromem() {
        String napis = inputHandler.nextLine("Wprowadź tekst:");
        boolean jestPalindromem = OperacjeNaCiagachZnakow.palindrom(napis);
        printer.println(
                "Napis \"%s\" %s palindromem."
                .formatted(napis, jestPalindromem ? "jest" : "nie jest")
        );
    }

    private void sprawdzCzyDwaTekstySaAnagramami() {
        String napis1 = inputHandler.nextLine("Wprowadź napis 1:");
        String napis2 = inputHandler.nextLine("Wprowadź napis 2:");
        boolean jestAnagramem = OperacjeNaCiagachZnakow.anagram(napis1, napis2);
        printer.println(
                "Napis \"%s\" %s anagramem napisu \"%s\"."
                .formatted(napis2, jestAnagramem ? "jest" : "nie jest", napis1)
        );
    }
}


class OperacjeNaCiagachZnakow {

    static String odwrocony(String napis) {
        StringBuilder wynik = new StringBuilder();
        for (int i = napis.length() - 1; i >= 0; i--) {
            wynik.append(napis.charAt(i));
        }
        return wynik.toString();
    }

    static String przestawioneSlowa(String napis) {
        String[] slowa = napis.trim().split("\\s+");
        StringBuilder wynik = new StringBuilder();
        for (int i = slowa.length - 1; i >= 0; i--) {
            wynik.append(slowa[i]);
            if (i > 0) wynik.append(" ");
        }
        return wynik.toString();
    }

    static String szyfruj(String napis, int klucz) {
        StringBuilder wynik = new StringBuilder();
        int przesuniecie = klucz % 26;

        for (int i = 0; i < napis.length(); i++) {
            char znak = napis.charAt(i);

            boolean duzaLitera = znak >= 'A' && znak <= 'Z';
            boolean malaLitera = znak >= 'a' && znak <= 'z';

            if (duzaLitera) {
                int pozycja = znak - 'A';
                int nowaPozycja = (pozycja + przesuniecie + 26) % 26;
                znak = (char) ('A' + nowaPozycja);
            } else if (malaLitera) {
                int pozycja = znak - 'a';
                int nowaPozycja = (pozycja + przesuniecie + 26) % 26;
                znak = (char) ('a' + nowaPozycja);
            }

            wynik.append(znak);
        }

        return wynik.toString();
    }


    static String odszyfruj(String napis, int klucz) {
        return szyfruj(napis, -klucz);
    }

    static String uporzadkuj(String napis) {
        napis = napis.trim();
        napis = napis.replaceAll("\\s+", " ");
        napis = napis.replaceAll("\\s*([.,;:!?])", "$1");
        napis = napis.replaceAll("([.,;:!?])(\\S)", "$1 $2");
        return napis;
    }

    static int liczbaWystapien(String napis, char znak) {
        int licznik = 0;
        for (int i = 0; i < napis.length(); i++) {
            if (napis.charAt(i) == znak) licznik++;
        }
        return licznik;
    }

    static int[] histogram(String napis) {
        int[] licznikLiter = new int[26];

        for (int i = 0; i < napis.length(); i++) {
            char znak = Character.toUpperCase(napis.charAt(i));
            boolean znakMiedzyAZ = znak >= 'A' && znak <= 'Z';
            if (znakMiedzyAZ) {
                int indeks = znak - 'A';
                licznikLiter[indeks]++;
            }
        }
        return licznikLiter;
    }

    static boolean palindrom(String napis) {
        napis = napis.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int koniec = napis.length() - 1;

        while (start < koniec) {
            if (napis.charAt(start) != napis.charAt(koniec)) return false;
            start++;
            koniec--;
        }
        return true;
    }

    static boolean anagram(String napis1, String napis2) {
        napis1 = napis1.replaceAll("\\s+", "").toLowerCase();
        napis2 = napis2.replaceAll("\\s+", "").toLowerCase();

        if (napis1.length() != napis2.length()) return false;

        int[] licznikZnakow = new int[256];         //tablica przechowująca ilość wystąpień dla każdego znaku

        for (int i = 0; i < napis1.length(); i++) {
            licznikZnakow[napis1.charAt(i)]++;      //zwiększanie wartości dla znaku
            licznikZnakow[napis2.charAt(i)]--;      //zmniejszanie wartości dla znaku
        }

        //jeśli anagram - wszystkie pozycje powinny być wyzerowane
        for (int x : licznikZnakow) {
            if (x != 0) return false;
        }

        return true;
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

    char getCharValue(String message) {
        Character result = null;

        while (result == null) {
            printer.println(message);
            String input = scanner.nextLine().trim();

            if (input.length() == 1) {
                result = input.charAt(0);
            } else {
                printer.printError("Błąd: proszę wprowadzić dokładnie jeden znak.");
            }
        }

        return result;
    }

    String nextLine(String message) {
        printer.println(message);
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}


class Printer {
    private final String separator = "-".repeat(58);

    void printAppInfo() {
        printSeparator();
        println("Program przedstawiający wybrane funkcje na ciągach znaków");
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