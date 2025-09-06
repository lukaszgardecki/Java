package com.example.bridge;

public class ChildSize implements Size {
    @Override
    public void get() {
        System.out.println("Child");
    }
}
