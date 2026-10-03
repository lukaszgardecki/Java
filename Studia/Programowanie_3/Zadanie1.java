

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