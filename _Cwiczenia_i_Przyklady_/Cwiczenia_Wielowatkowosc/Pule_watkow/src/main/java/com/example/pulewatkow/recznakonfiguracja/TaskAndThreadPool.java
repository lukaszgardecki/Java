package com.example.pulewatkow.recznakonfiguracja;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class TaskAndThreadPool implements Runnable {
    private String taskInfo;
    public TaskAndThreadPool(String taskInfo) {
        this.taskInfo = taskInfo;
    }
    @Override
    public void run() {
        System.out.println(taskInfo);
    }
    public static void main(String[] args) {
        // minimalna liczba działających wątków ustawiamy na 5
        // maksymalna liczba działających wątków ustawiamy na 10
        // wątki bezczynne będą ustnieć przez 30 sekund
        // zadanie będzie wykonane w kolejce typu LinkedBlockingQueue
        ExecutorService tpe = new ThreadPoolExecutor(5, 10, 30L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()); // kolejka musi być typu BlockingQueue
        TaskAndThreadPool[] tasks = new TaskAndThreadPool[10];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new TaskAndThreadPool("Task " + i);
            tpe.execute(tasks[i]); // wykonujemy zadanie
        }
        tpe.shutdown(); //zamykamy pulę
    }
}
