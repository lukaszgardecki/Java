package com.example.biblioteka.exception;

public class CheckoutException extends RuntimeException{
    public CheckoutException(String message) {
        super(message);
    }
}
