package com.example.kolekcjewspolbiezne.przyklad_3;

import java.util.concurrent.SynchronousQueue;

/**
 * Klasa SynchronousQueueDemo to wątek główny, który tworzy kolejkę typu SynchronousQueue,
 * a także uruchamia wątki konsumenta i producenta w celu wykonania.
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        SynchronousQueue<String> drop = new SynchronousQueue<>();
        new Thread( new Producer(drop)).start();
        new Thread( new Consumer(drop)).start();
    }
}
