package com.example.programowanie2.cwiczenia.zaliczenia.zad24_watki1;

import java.util.Random;

public class Zadanie24 {
    public static void main(String[] args) {
        SalaKinowa sala = new SalaKinowa(100);
        int liczbaKlientow = 50;

        System.out.println("=== START SYSTEMU REZERWACJI KINOWEJ ===");
        System.out.println("Początkowa liczba wolnych miejsc: " + sala.getWolneMiejsca());
        System.out.println("Uruchamianie " + liczbaKlientow + " niezależnych wątków-klientów...\n");

        // Tworzymy i uruchamiamy 50 niezależnych wątków
        Thread[] watki = new Thread[liczbaKlientow];

        for (int i = 0; i < liczbaKlientow; i++) {
            String nazwaKlienta = "Klient_" + (i + 1);
            KlientKino klient = new KlientKino(nazwaKlienta, sala);

            // Tworzymy wątek przekazując obiekt Runnable i używamy start(), aby ruszył w tle
            watki[i] = new Thread(klient);
            watki[i].start();
        }

        // Czekamy, aż wszystkie wątki zakończą pracę (opcjonalne, ale dobre dla ładnego logu końcowego)
        for (int i = 0; i < liczbaKlientow; i++) {
            try {
                watki[i].join();
            } catch (InterruptedException e) {
                System.out.println("Główny wątek został przerwany.");
            }
        }

        System.out.println("\n=== KONIEC REZERWACJI ===");
        System.out.println("Ostateczna liczba wolnych miejsc na sali: " + sala.getWolneMiejsca());
    }
}

class SalaKinowa {
    private int wolneMiejsca;

    public SalaKinowa(int liczbaMiejsc) {
        this.wolneMiejsca = liczbaMiejsc;
    }

    public synchronized boolean zarezerwujMiejsca(String nazwaKlienta, int ileMiejsc) {
        System.out.println("[" + nazwaKlienta + "] Próbuje zarezerwować " + ileMiejsc + " miejsc...");

        if (wolneMiejsca >= ileMiejsc) {
            wolneMiejsca -= ileMiejsc;
            System.out.println(">>> SUKCES: [" + nazwaKlienta + "] zarezerwował " + ileMiejsc
                    + " biletów. Pozostało wolnych miejsc: " + wolneMiejsca);
            return true;
        } else {
            System.out.println("X BŁĄD: Brak wystarczającej liczby miejsc dla [" + nazwaKlienta
                    + "]. Chciał: " + ileMiejsc + ", zostało: " + wolneMiejsca);
            return false;
        }
    }

    public int getWolneMiejsca() {
        return wolneMiejsca;
    }
}

class KlientKino implements Runnable {
    private final String nazwa;
    private final SalaKinowa sala;
    private final Random random = new Random();

    public KlientKino(String nazwa, SalaKinowa sala) {
        this.nazwa = nazwa;
        this.sala = sala;
    }

    @Override
    public void run() {
        // Losujemy liczbę miejsc od 1 do 4
        int ileChceZarezerwowac = random.nextInt(4) + 1;

        // Wywołujemy bezpieczną, zsynchronizowaną metodę z obiektu sali
        sala.zarezerwujMiejsca(nazwa, ileChceZarezerwowac);
    }
}
