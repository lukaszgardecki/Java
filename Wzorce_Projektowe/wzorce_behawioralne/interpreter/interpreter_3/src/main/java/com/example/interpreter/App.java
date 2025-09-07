package com.example.interpreter;

public class App {

    public static void main(String[] args) {
        var context = "_My Variable";
        FirstLetterShouldNotBeUnderscore firstLetterShouldNotBeUnderscore = new FirstLetterShouldNotBeUnderscore();
        String result = firstLetterShouldNotBeUnderscore.interpret(context);
        System.out.println(result);
    }
}
