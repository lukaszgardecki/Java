package com.example.bridge;

public class AdultSize implements Size {
    @Override
    public void get() {
        System.out.println("Adult");
    }
}
