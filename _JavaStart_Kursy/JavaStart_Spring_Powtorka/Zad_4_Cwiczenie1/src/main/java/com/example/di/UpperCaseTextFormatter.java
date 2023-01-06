package com.example.di;

import org.springframework.stereotype.Component;

@Component
public class UpperCaseTextFormatter implements TextFormatter {

    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}
