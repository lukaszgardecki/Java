package wzorce.singleton;

/**
 * Zadanie 4: Menedźer połączeń z bazą danych
 *
 * Cel: Pokazanie, że Singleton może zarządzać zasobami systemowymi
 *
 * - Zaimplementuj klasę PolaczenieBazy, która będzie Singletonem
 * - klasa pwoinna mieć metodę polacz(), która symuluje nawiązanie połączenia (np. wypisuje na konsolę "Połączono z bazą danych.")
 * - w metodzie main spróbuj pobrać instancję z kilku miejsc programu i pokaż, że zawsze jest to ten sam obiekt
 * - Rozszerzenie: dodaj licznik, który pokazuje, ile razy próbowano pobrać instancję
 */
public class Zadanie4 {

    public static void main(String[] args) {
        Runnable task = ()-> {
            for (int i = 0; i < 3; i++) {
                PolaczenieBazy p = PolaczenieBazy.getInstance();
                System.out.printf("Połączenie: %s, wątek %s\n", p.hashCode(), Thread.currentThread().getName());
                p.polacz();
            }
        };

        Thread t1 = new Thread(task, "W1");
        Thread t2 = new Thread(task, "W2");
        Thread t3 = new Thread(task, "W3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class PolaczenieBazy {
    //bez volatile ponieważ synchronized zastosowano na całej metodzie getInstance()
    private static PolaczenieBazy INSTANCE;
    private static int counter;

    private PolaczenieBazy() {}

    public static synchronized PolaczenieBazy getInstance() {
        counter++;
        System.out.println("Próba pobrania instancji: " + counter);
        if (INSTANCE == null) {
            INSTANCE = new PolaczenieBazy();
        }
        return INSTANCE;
    }

    public synchronized void polacz() {
        System.out.println("Połączono z bazą danych.");
    }
}
