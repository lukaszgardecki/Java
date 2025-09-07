package com.example.interpreter;

public class App {

    public static void main(String[] args) {
        var context = "hello world";
        FirstLetterUppercase firstLetterUppercase = new FirstLetterUppercase();
        String result = firstLetterUppercase.interpret(context);
        System.out.println(result);
    }

}