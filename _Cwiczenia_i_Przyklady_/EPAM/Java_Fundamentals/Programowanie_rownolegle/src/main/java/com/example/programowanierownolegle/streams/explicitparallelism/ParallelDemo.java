package com.example.programowanierownolegle.streams.explicitparallelism;

import java.util.stream.LongStream;

public class ParallelDemo {

    /**
     * Podczas wykonywania aplikacja wyświetla na konsoli nazwy wątków przetwarzania w następującym formacie:
     *
     * ForkJoinPool.commonPool-worker-5
     * ForkJoinPool.commonPool-worker-11
     *
     * Jeśli usuniemy wywołanie metody parallel(), podczas wykonywania wyświetlana będzie tylko nazwa wątku głównego.
     * Nie będzie podziału na podzadania.
     */
    public static void main(String[] args) {
        long result;
        result = LongStream.range(0, 1_000_000_000)
                .boxed()
                .parallel()
                .map(x -> x / 7)
                .peek(v -> System.out.println(Thread.currentThread().getName()))
                .reduce((x,y) -> x + (int) (3 * Math.sin(y)))
                .get();
        System.out.println(result);
    }
}

