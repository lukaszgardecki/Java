package com.example.zad_69_basicauthentication_calculator.calculator;

public class Calculator {
    static Result calculate(double a, double b, String operator) {
        double result;
        switch (operator) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> result = a / b;
            default -> throw new IllegalArgumentException("Undefined operator: " + operator);
        }
        return new Result(a, b, operator, result);
    }
}
