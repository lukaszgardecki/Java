package com.example.app.exception;

public class SalaryCalculationFailedException extends RuntimeException{
    public SalaryCalculationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
