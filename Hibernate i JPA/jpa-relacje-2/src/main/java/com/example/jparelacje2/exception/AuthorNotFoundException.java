package com.example.jparelacje2.exception;

public class AuthorNotFoundException extends RuntimeException{
    private static final String message = "Author does not exist.";

    public AuthorNotFoundException() {
        super(message);
    }
}
