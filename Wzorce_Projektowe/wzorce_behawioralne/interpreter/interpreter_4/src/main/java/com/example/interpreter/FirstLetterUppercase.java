package com.example.interpreter;

public class FirstLetterUppercase implements Expression {
    private final EndsWithPeriod endsWithPeriod = new EndsWithPeriod();

    @Override
    public String interpret(String context) {
        if (!Character.isUpperCase(context.charAt(0))) {
            context = context.substring(0, 1).toUpperCase() + context.substring(1);
        }
        return endsWithPeriod.interpret(context);
    }
}
