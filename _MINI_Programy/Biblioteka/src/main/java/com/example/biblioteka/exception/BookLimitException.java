package com.example.biblioteka.exception;

public class BookLimitException extends RuntimeException {
    public BookLimitException(String message) {
        super(message);
    }
}
