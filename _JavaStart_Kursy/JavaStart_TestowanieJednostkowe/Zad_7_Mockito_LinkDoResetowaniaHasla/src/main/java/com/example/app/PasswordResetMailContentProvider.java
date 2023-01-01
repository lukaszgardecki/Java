package com.example.app;

public class PasswordResetMailContentProvider {
    private RandomProvider randomProvider;

    public PasswordResetMailContentProvider(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public String createResetMailContent() {
        String template = "Cześć, aby przejść do resetowania hasła <a href=\"https://example.com/reset?key=%1s\">ten link</a>";
        String randomKey = randomProvider.generateRandomKey();
        return String.format(template, randomKey);
    }
}
