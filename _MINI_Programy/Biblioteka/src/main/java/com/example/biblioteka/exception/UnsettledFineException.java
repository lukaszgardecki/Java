package com.example.biblioteka.exception;

public class UnsettledFineException extends RuntimeException{
    public UnsettledFineException(String message) {
        super(message);
    }
}
