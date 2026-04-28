package com.example.programowanie2.cwiczenia.zaliczenia.zad16_pliki_domy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie_16 {
    public static void main(String[] args) {
        new DaneDomow().run();
    }
}


class DaneDomow {
    void run() {
        List<Dom> domy = new Reader().readFromFile("domy.txt");

        List<Dom> domyParteroweWiejskie = domy.stream()
                .filter(Dom::jestParterowy)
                .filter(Dom::jestWiejski)
                .toList();

        domyParteroweWiejskie.forEach(Dom::obnizCeneO10Procent);

        new Writer().writeToFile("wiejskied.txt", domyParteroweWiejskie);
    }
}


class Dom {
    private String nazwa;
    private double cena;
    private int kondygnacje;
    private String lokalizacja;

    Dom(String nazwa, double cena, int kondygnacja, String lokalizacja) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.kondygnacje = kondygnacja;
        this.lokalizacja = lokalizacja;
    }

    void obnizCeneO10Procent() {
        this.cena *= 0.9;
    }

    boolean jestParterowy() {
        return kondygnacje == 1;
    }

    boolean jestWiejski() {
        return lokalizacja.equals("Wies");
    }

    @Override
    public String toString() {
        String cenaZKropka = "%.2f".formatted(cena).replace(",", ".");
        return "%s-%s-%d-%s".formatted(nazwa, cenaZKropka, kondygnacje, lokalizacja);
    }
}


class Reader {
    List<Dom> readFromFile(String path) {
        List<Dom> domy = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) continue;

                String[] split = line.split("-");
                if (split.length == 4) {
                    domy.add(new Dom(
                            split[0], Double.parseDouble(split[1].replace(',', '.')), Integer.parseInt(split[2]), split[3]
                    ));
                }
            }
            System.out.println("Pomyślnie wczytano dane z pliku.");
        } catch (FileNotFoundException e) {
            System.err.println("Nie udało się wczytać pliku.");
        } catch (NumberFormatException e) {
            System.err.println("Błąd poczas formatowania danych.");
        }
        return domy;
    }
}


class Writer {
    void writeToFile(String path, List<Dom> domy) {
        try (PrintWriter writer = new PrintWriter(path)) {
            for (Dom dom : domy) {
                writer.println(dom.toString());
            }
            System.out.println("Pomyślnie zapisano dane do pliku.");
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku.");
        }
    }
}