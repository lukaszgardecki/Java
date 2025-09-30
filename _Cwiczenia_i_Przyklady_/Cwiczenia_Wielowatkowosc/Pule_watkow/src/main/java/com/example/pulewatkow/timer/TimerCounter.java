package com.example.pulewatkow.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class TimerCounter extends TimerTask {
    private static int i;
    @Override
    public void run() {
        System.out.print(++i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
        System.out.println("\t" + i);
    }
}