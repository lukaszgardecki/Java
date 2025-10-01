package com.example.zaawansowanesynchronizatory.semaphore;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

/**
 * Ten przykład tworzy dwa wątki: główny i ArraySort. Wątek główny — klasa SemaphoreDemo i metoda main() — zawiera:
 *      - Odwołanie do sortSemaphore typu Semaphore, które będzie używane do organizacji
 *        interakcji między wątkami głównym i ArraySort
 *      - Odwołanie do tablicy elementów, która zostanie posortowana
 */
public class SemaphoreDemo {
    public static final int ITEMS_COUNT = 10;
    public final static Semaphore sortSemaphore = new Semaphore(0, true); // bierzemy pod uwagę kolejność żądań

    public static void main(String[] args) {

        /**
         * 1. Po uruchomieniu wątku głównego, tablica elementów jest inicjowana liczbami losowymi.
         */
        int[] items = getArrayFilledWithRandomNumbers();
        System.out.println("Initial array: " + Arrays.toString(items));

        /**
         * 2. Po utworzeniu wątek ArraySort otrzymuje odwołanie do tablicy do posortowania.
         *    Wątek ten używa zmodyfikowanego algorytmu sortowania przez wybieranie do sortowania tablicy w kolejności malejącej.
         */
        new Thread(new ArraySort(items)).start();

        /**
         *    Wątek główny w pętli używa semafora do uzyskania pozwolenia na wyświetlenie bieżącego
         *    elementu tablicy. Ponieważ semafor początkowo nie ma dostępnych pozwoleń, wątek główny jest blokowany.
         */
        for (int i = 0; i < items.length; i++) {
            sortSemaphore.acquireUninterruptibly();
            System.out.println("Step [" + (i + 1) + "]: " + Arrays.toString(items));
        }

        System.out.println("Sorted array: " + Arrays.toString(items));
    }

    private static int[] getArrayFilledWithRandomNumbers() {
        int[] items = new int[ITEMS_COUNT];
        for (int i = 0; i < items.length; i++) {
            items[i] = (int) (Math.random()*10);
        }
        return items;
    }
}

