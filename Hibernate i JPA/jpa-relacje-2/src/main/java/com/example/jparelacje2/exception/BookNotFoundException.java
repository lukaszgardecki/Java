package com.example.jparelacje2.exception;

public class BookNotFoundException extends RuntimeException{
    private static final String message = "Book does not exist.";

    public BookNotFoundException() {
        super(message);
    }
}
