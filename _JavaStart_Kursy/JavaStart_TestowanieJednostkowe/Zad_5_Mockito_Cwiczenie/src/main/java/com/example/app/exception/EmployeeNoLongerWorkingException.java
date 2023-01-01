package com.example.app.exception;

public class EmployeeNoLongerWorkingException extends RuntimeException{
    public EmployeeNoLongerWorkingException() {
        super("Employee is no longer hired");
    }
}
