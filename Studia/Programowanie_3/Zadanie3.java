public class Zadanie3 {

    public static void main(String[] args) throws InterruptedException {
        Runnable zadanie = () -> {
            GeneratorID gen = GeneratorID.getInstance();
            System.out.println(Thread.currentThread().getName() + " ID: " + gen.pobierzNoweID());
        };

        Thread t1 = new Thread(zadanie, "Wątek-1");
        Thread t2 = new Thread(zadanie, "Wątek-2");
        Thread t3 = new Thread(zadanie, "Wątek-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        GeneratorID.getInstance().resetuj();
        System.out.println("Po resecie ID: " + GeneratorID.getInstance().pobierzNoweID());
    }
}

class GeneratorID {
    private static volatile GeneratorID INSTANCE;
    private int id = 1;

    private GeneratorID() {}

    public static GeneratorID getInstance() {
        if (INSTANCE == null) {
            synchronized (GeneratorID.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GeneratorID();
                }
            }
        }
        return INSTANCE;
    }

    public synchronized int pobierzNoweID() {
        return id++;
    }

    public synchronized void resetuj() {
        this.id = 1;
    }
}