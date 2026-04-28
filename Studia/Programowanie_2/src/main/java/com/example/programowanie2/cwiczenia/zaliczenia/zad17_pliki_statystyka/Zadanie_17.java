package com.example.programowanie2.cwiczenia.zaliczenia.zad17_pliki_statystyka;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Zadanie_17 {
    public static void main(String[] args) {
        new StatystykaDziennikarska().run();
    }
}


class StatystykaDziennikarska {
    void run() {
        String tekst = new Reader().readAllTextFromFile("tekst.txt");
        StatystykiTekstu statystyka = new AnalitykTekstowy().analizuj(tekst);
        new Printer().print(statystyka);
    }
}


class AnalitykTekstowy {
    StatystykiTekstu analizuj(String tekst) {
        if (tekst == null || tekst.isBlank()) return new StatystykiTekstu(0, 0);
        int slowa = liczSlowa(tekst);
        int zdania = liczZdania(tekst);
        return new StatystykiTekstu(slowa, zdania);
    }

    private int liczSlowa(String tekst) {
        if (tekst == null || tekst.isBlank())  return 0;
        String czystyTekst =tekst.replaceAll("\\p{Punct}", " ");
        String[] slowa = czystyTekst.trim().split("\\s+");
        return slowa.length;
    }

    private int liczZdania(String tekst) {
        if (tekst == null || tekst.isBlank()) return 0;
        String[] zdania = tekst.trim().split("[.?!]+");

        // wybrane skróty:
        String[] skroty = {
                "np", "itp", "itd", "in", "tj", "tzw", "zob", "por", "pt", "str",
                "rys", "tab", "dr", "prof", "hab", "mgr", "inz", "lek", "doc", "ks",
                "mec", "red", "br", "ub", "r", "godz", "min", "sek", "st", "pn",
                "wt", "sr", "czw", "sb", "nd", "tel", "ul", "al", "pl", "os",
                "lok", "nr", "szt", "egz", "cdn", "kpt", "mjr", "plk", "m", "dh"
        };
        int licznik = 0;

        for (String zdanie : zdania) {
            String trimZdanie = zdanie.trim();
            if (trimZdanie.isEmpty()) continue;
            String[] slowa = zdanie.toLowerCase().split("\\s+");

            if (slowa.length > 0) {
                String ostatnieSlowo = slowa[slowa.length - 1];
                boolean konczySieSkrotem = Arrays.asList(skroty).contains(ostatnieSlowo);
                if (!konczySieSkrotem) licznik++;
            }
        }
        return licznik;
    }
}


class StatystykiTekstu {
    private final int liczbaSlow;
    private final double sredniaDlugoscZdania;

    StatystykiTekstu(int liczbaSlow, int liczbaZdan) {
        this.liczbaSlow = liczbaSlow;
        sredniaDlugoscZdania = (liczbaZdan > 0) ? (double) liczbaSlow / liczbaZdan : 0;
    }

    @Override
    public String toString() {
        return """
                Ilość słów: %d
                Średnia długość zdania: %.1f
                """.formatted(liczbaSlow, sredniaDlugoscZdania);
    }
}


class Reader {
    public String readAllTextFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.err.println("Nie odnaleziono pliku.");
            return "";
        }
    }
}


class Printer {
    void print(StatystykiTekstu statystyki) {
        System.out.println(statystyki);
    }
}
