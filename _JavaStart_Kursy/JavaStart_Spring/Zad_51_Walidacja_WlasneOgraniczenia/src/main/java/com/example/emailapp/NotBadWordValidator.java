package com.example.emailapp;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class NotBadWordValidator implements ConstraintValidator<NotBadWord, String> {
    private Lang[] languages;

    @Override
    public void initialize(NotBadWord annotation) {
        this.languages = annotation.lang();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (Lang lang : languages) {
            if (containsBadWord(s, lang.getBadWords())) {
                return false;
            }
        }
        return true;
    }

    private boolean containsBadWord(String text, String[] badWords) {
        String lowerCaseText = text.toLowerCase();
        return Arrays.stream(badWords)
                .anyMatch(lowerCaseText::contains);
    }
}
