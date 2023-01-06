package com.example.di;

import org.springframework.stereotype.Component;

@Component
public class ConsoleOutputWriter {
    private final UpperCaseTextFormatter formatter;

    public ConsoleOutputWriter(UpperCaseTextFormatter formatter) {
        this.formatter = formatter;
    }

    void println(String text) {
        String formattedText = formatter.format(text);
        System.out.println(formattedText);
    }
}
