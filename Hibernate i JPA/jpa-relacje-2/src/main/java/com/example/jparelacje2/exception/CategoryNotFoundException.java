package com.example.jparelacje2.exception;

public class CategoryNotFoundException extends RuntimeException{
    private static final String message = "Category does not exist.";

    public CategoryNotFoundException() {
        super(message);
    }
}
