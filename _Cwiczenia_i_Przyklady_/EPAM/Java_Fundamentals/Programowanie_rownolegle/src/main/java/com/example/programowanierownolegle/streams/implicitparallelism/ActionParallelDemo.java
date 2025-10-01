package com.example.programowanierownolegle.streams.implicitparallelism;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ActionParallelDemo {

    /**
     * Wątek niestandardowy oparty na typach Runnable lub Callable nie może być wykonywany równolegle, ale można go umieścić w puli ForkJoinPool.
     *
     * Uruchomienie kodu pokaże, że używane są następujące wątki:
     *
     * ForkJoinPool-1-worker-21
     * ForkJoinPool-1-worker-7
     *
     * W związku z tym strumienie równoległe używają wątków rozwidlenia/połączenia jako wątków nadrzędnych,
     * a nie zwykłych wątków. W rezultacie, ForkJoinPool.commonPool nie jest stosowany.
     */
    public static void main(String[] args) {
        long sec = System.currentTimeMillis();
        Callable<Integer> task = () -> IntStream.range(0, 1_000_000_000)
                .boxed()
                .parallel()
                .map(x -> x / 3)
                .peek(th -> System.out.println(Thread.currentThread().getName()))
                .reduce((x, y) -> x + (int)(3 * Math.sin(y)))
                .get();

        ForkJoinPool pool = new ForkJoinPool(8);

        try {
            int result = pool.submit(task).get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException();
        }
        System.out.println((System.currentTimeMillis() - sec) / 1000.);
    }
}

