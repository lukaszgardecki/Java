package com.example.kolekcjewspolbiezne.przyklad_3;

import java.util.concurrent.SynchronousQueue;

/**
 * Konsument wątku pobiera dane i otrzymuje referencję do kolejki SynchronousQueue.
 * Następnie wywołuje metodę take() w pętli, aż otrzyma ciąg znaków „DONE” i zakończy pracę.
 * Dane zostaną przekazane dopiero wtedy, gdy oba wątki będą gotowe.
 */
public class Consumer implements Runnable {
    private SynchronousQueue<String> drop; // odniesienie do wspólnej kolejki

    public Consumer(SynchronousQueue<String> drop) {
        this.drop = drop;
    }

    public void run() {
        try {
            String msg = null;
            while (!((msg = drop.take()).equals("DONE"))) { // otrzymuj aż do ostatniego stringa "DONE"
                System.out.println(msg);
            }
        } catch(InterruptedException intEx) {
            System.out.println("Interrupted! Last one out, turn out the lights!");
        }
    }
}
