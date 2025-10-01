package com.example.programowanierownolegle.forkjoinframework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *      1. Metoda main() klasy SumOfNumberUsingForkJoin — wątku głównego — tworzy pulę wątków typu ForkJoinPool
 *         dla dziesięciu wątków roboczych. Liczba wątków (zmienna NUM_THREADS) i ostatnia z sumowanych liczb (zmienna N)
 *         są zdefiniowane jako pola klasy SumOfNumberUsingForkJoin.
 *      2. Następnie poprzez wywołanie metody invoke() przekazuje zadanie typu RecursiveSumOfNumber do puli,
 *         aby obliczyć sumę liczb od 0 do 1000000.
 *      3. Po oczekiwaniu na wynik wyświetla go w konsoli.
 */
public class SumOfNumberUsingForkJoin {
    private final static long N = 1_000_000L;
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(NUM_THREADS);
        long computedSum = pool.invoke(new RecursiveSumOfNumber(0, N));
        long formulaSum = (N * (N + 1)) / 2;
        System.out.printf("Sum for range 1..%d; computed sum = %d, formula sum = %d%n", N, computedSum, formulaSum);
    }

    /**
     * Klasa RecursiveSumOfNumber jest wątkiem typu RecursiveTask<Long>.
     * Zawiera dwa pola typu Long, które określają zakres sumowanych liczb.
     * Pola są inicjowane podczas tworzenia obiektu.
     * Metoda compute() — ciało zadania (wątek) — początkowo określa potrzebę podziału na podzadania. Szacuje liczbę liczb:
     *          - Jeżeli liczba liczb jest mniejsza niż 100 000, suma jest obliczana i wyświetlana w konsoli,
     *            a metoda kończy działanie, zwracając obliczoną sumę.
     *          - Jeśli istnieje więcej niż 100 000 liczb, wówczas:
     *              1. Zakres liczb jest dzielony przez 2.
     *              2. Dwa wynikowe zakresy są wyświetlane w konsoli, a następnie tworzone jest nowe zadanie
     *                 typu RecursiveSumOfNumber o nazwie firstHalf w celu obliczenia sumy pierwszego zakresu.
     *                 W tym zadaniu wywoływana jest metoda fork(), aby oddzielić obliczenia w osobnym wątku.
     *              3. Na koniec tworzone jest kolejne nowe zadanie typu RecursiveSumOfNumber o nazwie secondHalf
     *                 w celu obliczenia sumy drugiego zakresu liczb. W tym zadaniu wywoływana jest metoda compute();
     *                 jest to wykonanie rekurencyjne w tym samym wątku.
     */
    static class RecursiveSumOfNumber extends RecursiveTask<Long> {
        private long from;
        private long to;

        public RecursiveSumOfNumber(long from, long to) {
            this.from = from;
            this.to = to;
        }

//        public Long compute() {
//            if ((to - from) <= N / NUM_THREADS) {
//                long localSum = 0;
//                for (long number = from; number <= to; number++) {
//                    localSum += number;
//                }
//                System.out.printf("\tSum of range %d to %d is %d%n", from, to, localSum);
//                return localSum;
//            } else {
//                long middle = (from + to) / 2;
//                System.out.printf("Forking into two ranges: %d to %d and %d to %d%n", from, middle, middle + 1, to);
//                RecursiveSumOfNumber firstHalf = new RecursiveSumOfNumber(from, middle);
//                firstHalf.fork();
//                RecursiveSumOfNumber secondHalf = new RecursiveSumOfNumber(middle + 1, to);
//                long resultSecondTask = secondHalf.compute();
//                return firstHalf.join() + resultSecondTask;
//            }
//        }

        // użycie strumieni jest w stanie zapobiec przepełnieniu stosu maszyny wirtualnej
        public Long compute() {
            if ((to - from) <= 100_000) {
                long localSum = 0;
                for (long number = from; number <= to; number++) {
                    localSum += number;
                }
                return localSum;
            } else {
                long middle = (from + to) / 2;
                List<RecursiveSumOfNumber> subTasks = new ArrayList<>();
                subTasks.add(new RecursiveSumOfNumber(from, middle));
                subTasks.add(new RecursiveSumOfNumber(middle + 1, to));
                subTasks.stream().forEach(RecursiveTask::fork);
                return subTasks.stream()
                        .map(RecursiveTask::join)
                        .reduce((res1, res2) -> res1 + res2)
                        .orElse(0L);
            }
        }

    }
}
