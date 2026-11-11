package wzorce.singleton;

/**
 * Zadanie 1: Dziennik zdarzeń aplikacji
 *
 * Cel: Utrwalenie podstaw implementacji Singletona
 *
 * - Napisz klasę DziennikZdarzen, która będzie Singletonem
 * - klasa powinna mieć metodę log(String wiadomosc), która wypisuje komunikaty na konsolę z prefiksem [DZIENNIK]
 * - w metodzie main utwórz kilka wątkó, które będą próbowały logować zdarzenia
 * - udowodnij, że wszystkie wątki korzystają z tej samej instacji DziennikZdarzen
 * - Rozszerzenie: dodaj numerowanie logów (np. [DZIENNIK #1] Start aplikacji)
 */
public class Zadanie1 {

    public static void main(String[] args) {
        Runnable zadanie = () -> {
            DziennikZdarzen dziennik = DziennikZdarzen.getInstance();
            System.out.println(Thread.currentThread().getName() + " -> hashCode: " + dziennik.hashCode());
            dziennik.log("Uruchomiono wątek");
        };

        Thread t1 = new Thread(zadanie, "Watek-1");
        Thread t2 = new Thread(zadanie, "Watek-2");
        Thread t3 = new Thread(zadanie, "Watek-3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class DziennikZdarzen {
    private static volatile DziennikZdarzen INSTANCE;
    private int licznik = 1;

    private DziennikZdarzen() {}

    public static DziennikZdarzen getInstance() {
        if (INSTANCE == null) {
            synchronized (DziennikZdarzen.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DziennikZdarzen();
                }
            }
        }
        return INSTANCE;
    }

    public synchronized void log(String wiadomosc) {
        System.out.println("[DZIENNIK #" + licznik++ + "] " + wiadomosc);
    }
}