package com.example.jparelacje2.exception;

public class ZipcodeNotFoundException extends RuntimeException{
    private static final String message = "Zipcode does not exist.";

    public ZipcodeNotFoundException() {
        super(message);
    }
}
