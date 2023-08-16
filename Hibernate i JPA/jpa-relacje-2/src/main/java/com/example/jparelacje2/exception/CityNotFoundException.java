package com.example.jparelacje2.exception;

public class CityNotFoundException extends RuntimeException{
    private static final String message = "City does not exist.";

    public CityNotFoundException() {
        super(message);
    }
}
