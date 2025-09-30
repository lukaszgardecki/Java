package com.example.pulewatkow.timer;

import java.util.Timer;

class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerCounter(), 100, 3000);
    }
}