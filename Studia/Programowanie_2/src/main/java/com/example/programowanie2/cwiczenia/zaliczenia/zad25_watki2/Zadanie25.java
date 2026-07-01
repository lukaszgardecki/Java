package com.example.programowanie2.cwiczenia.zaliczenia.zad25_watki2;

public class Zadanie25 {
    public static void main(String[] args) {
        String szukaneSlowo = "java";

        System.out.println("=== SYSTEM ANALIZY TEKSTU ===");
        System.out.println("Szukane słowo: '" + szukaneSlowo + "'\n");

        LicznikSlowWatek zadanie1 = new LicznikSlowWatek("Plik_1.txt", TekstBaza.PLIK_1, szukaneSlowo);
        LicznikSlowWatek zadanie2 = new LicznikSlowWatek("Plik_2.txt", TekstBaza.PLIK_2, szukaneSlowo);
        LicznikSlowWatek zadanie3 = new LicznikSlowWatek("Plik_3.txt", TekstBaza.PLIK_3, szukaneSlowo);

        Thread watek1 = new Thread(zadanie1, "Robotnik-1");
        Thread watek2 = new Thread(zadanie2, "Robotnik-2");
        Thread watek3 = new Thread(zadanie3, "Robotnik-3");

        watek1.start();
        watek2.start();
        watek3.start();

        try {
            watek1.join();
            watek2.join();
            watek3.join();
        } catch (InterruptedException e) {
            System.out.println("Wątek główny został przerwany!");
        }

        System.out.println("\n=== KOŃCOWY RAPORT ZLICZANIA ===");
        System.out.println("- " + zadanie1.getNazwaPliku() + ": " + zadanie1.getWynikZliczania() + " razy");
        System.out.println("- " + zadanie2.getNazwaPliku() + ": " + zadanie2.getWynikZliczania() + " razy");
        System.out.println("- " + zadanie3.getNazwaPliku() + ": " + zadanie3.getWynikZliczania() + " razy");

        int lacznie = zadanie1.getWynikZliczania() + zadanie2.getWynikZliczania() + zadanie3.getWynikZliczania();
        System.out.println("---------------------------------");
        System.out.println("ŁĄCZNA liczba wystąpień słowa '" + szukaneSlowo + "': " + lacznie);
    }
}

class TekstBaza {
    public static final String PLIK_1 = "java to świetny język. java pozwala na pisanie aplikacji wielowątkowych.";
    public static final String PLIK_2 = "wiele osób uważa, że programowanie współbieżne w java jest trudne, ale java ma dobre narzędzia.";
    public static final String PLIK_3 = "dzisiaj uczę się wątków. java, wątek, join, synchronized - to ważne pojęcia.";
}

class LicznikSlowWatek implements Runnable {
    private final String tekstPliku;
    private final String szukaneSlowo;
    private final String nazwaPliku;
    private int wynikZliczania = 0;

    public LicznikSlowWatek(String nazwaPliku, String tekstPliku, String szukaneSlowo) {
        this.nazwaPliku = nazwaPliku;
        this.tekstPliku = tekstPliku;
        this.szukaneSlowo = szukaneSlowo.toLowerCase();
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Rozpoczynam przeszukiwanie " + nazwaPliku + "...");
        String[] slowa = tekstPliku.replaceAll("[.,?!-]", "").toLowerCase().split("\\s+");

        for (String slowo : slowa) {
            if (slowo.equals(szukaneSlowo)) {
                wynikZliczania++;
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Zakończyłem przeszukiwanie " + nazwaPliku);
    }

    public int getWynikZliczania() {
        return wynikZliczania;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }
}
