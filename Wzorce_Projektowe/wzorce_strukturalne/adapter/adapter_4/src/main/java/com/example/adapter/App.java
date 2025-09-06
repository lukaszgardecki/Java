package com.example.adapter;

public class App {

    public static void main(String[] args) {
        var englishLocalizedMessage = new EnglishLocalizedMessage();
        var englishGreeting = new Greeting(englishLocalizedMessage);
        englishGreeting.print();

        FrenchMessageAdapter frenchMessageAdapter = new FrenchMessageAdapter();
        var frenchGreeting = new Greeting(frenchMessageAdapter);
        frenchGreeting.print();
    }

}
