package com.example.kolekcjewspolbiezne.przyklad_3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Producent wątku generuje dane i otrzymuje referencję do kolejki SynchronousQueue.
 * Wywołuje metodę put() w pętli, aby wstawić dane do kolejki.
 * Po przekazaniu wszystkich danych, do kolejki przekazywany jest ciąg znaków „DONE” jako sygnał zakończenia.
 */
public class Producer implements Runnable {
    private SynchronousQueue<String> drop; // odniesienie do wspólnej kolejki

    List<String> messages = Arrays.asList( "Mares eat oats", "Does eat oats",
            "Little lambs eat ivy",
            "Wouldn't you eat ivy too?");

    public Producer(SynchronousQueue<String> drop) { // wstrzykiwanie wspólnej kolejki
        this.drop = drop;
    }

    public void run() {
        try {
            for (String str : messages) {
                drop.put(str); // dostarczanie stringów do kolejki
            }
            drop.put("DONE"); // string, który oznacza koniec dostarczania
        } catch(InterruptedException intEx) {
            System.out.println("Interrupted! Last one out, turn out the lights!");
        }
    }
}
