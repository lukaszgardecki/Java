package com.example.app.link.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("wrong password");
    }
}
