package com.example.generator;

public class DownBoundIsGreaterThenUpException extends RuntimeException{
    public DownBoundIsGreaterThenUpException() {
        super("Dolne ograniczenie musi być mniejsze, bądź równe górnemu ograniczeniu");
    }
}
