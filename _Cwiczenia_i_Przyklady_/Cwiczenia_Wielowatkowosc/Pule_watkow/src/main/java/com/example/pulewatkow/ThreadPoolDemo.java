package com.example.pulewatkow;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ThreadPoolDemo {
    public static void main(String[] args) {
        final int NUM_OF_WORKS = 20;
        ExecutorService pool = Executors.newFixedThreadPool(4);
        TestCallable works[] = new TestCallable[NUM_OF_WORKS];
        Future[] futures = new Future[NUM_OF_WORKS];
        for (int i = 0; i < NUM_OF_WORKS; i++) {
            works[i] = new TestCallable(i + 1);
            futures[i] = pool.submit(works[i]);
        }
        for (int i = 0; i < NUM_OF_WORKS; ++i) {
            try {
                System.out.println(futures[i].get() + " ended");
            } catch (InterruptedException | ExecutionException ex) {
                throw new IllegalStateException();
            }
        }
        pool.shutdown();
    }
}
