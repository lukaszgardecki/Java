package com.example.di;

import com.example.di.formatter.TextFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleOutputWriter {
    private final TextFormatter formatter;

    @Autowired
    public ConsoleOutputWriter(TextFormatter formatter) {
        this.formatter = formatter;
    }

    void println(String text) {
        String formattedText = formatter.format(text);
        System.out.println(formattedText);
    }

}
