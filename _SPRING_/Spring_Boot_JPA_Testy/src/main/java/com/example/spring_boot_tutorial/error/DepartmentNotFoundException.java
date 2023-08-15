package com.example.spring_boot_tutorial.error;

public class DepartmentNotFoundException extends RuntimeException {
    private static final String message = "Department not available";

    public DepartmentNotFoundException() {
        super(message);
    }
}
