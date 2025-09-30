package com.example.synchronizacja;

/**
 *  1. Dwie zmienne: jedna zwykła (varNonVolat) i druga zmienna (varVolat)
 *  2. Statyczny wątek klasy ChangeMaker, który nadpisuje wartości powyższych zmiennych
 *     w wyniku zwiększenia zmiennej lokalnej local_value do momentu otrzymania żądania przerwania
 *  3. Statyczny wątek klasy ChangeListener, który śledzi zmiany wartości powyższych zmiennych do momentu
 *     otrzymania żądania przerwania. Jeśli zmienne varNonVolat i varVolat nie są w pewnym momencie równe,
 *     ich wartości są wyświetlane w konsoli.
 */
public class VolatileDemo {
    private static volatile int varVolat = 0;
    private static int varNonVolat = 0;

    public static void main(String[] args) {
        ChangeListener listener = new ChangeListener();
        ChangeMaker maker = new ChangeMaker();
        listener.start();
        maker.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
        listener.interrupt();
        maker.interrupt();
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int localValue = 0;
            while (!isInterrupted()) {
                varVolat = varNonVolat = ++localValue;
            }
        }
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                if (varVolat != varNonVolat) {
                    System.out.println("Error: " + varVolat + " != " + varNonVolat);
                }
            }
        }
    }
}
