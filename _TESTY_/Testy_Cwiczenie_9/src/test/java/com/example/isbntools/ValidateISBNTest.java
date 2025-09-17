package com.example.isbntools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateISBNTest {

    @Test
    public void checkValid10DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result1 = validator.checkISBN("0140449116");
        assertTrue(result1, "first value");

        boolean result2 = validator.checkISBN("0140177396");
        assertTrue(result2, "second value");
    }

    @Test
    public void checkAValid13DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result1 = validator.checkISBN("9781853260087");
        assertTrue(result1, "first value");

        boolean result2 = validator.checkISBN("9781853267338");
        assertTrue(result2, "second value");
    }

    @Test
    public void tenDigitISBNNumberEndingInAnXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkAnInvalid10DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void checkAnInvalid13DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853267336");
        assertFalse(result);
    }

    @Test
    public void nineDigitISBNsAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("123456789"));
    }

    @Test
    public void nunNumericISBNAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("helloworld"));
    }
}