package com.example.testowanie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void shouldAdd2To5Result7() {
        // given
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 5;

        // when
        int result = calculator.add(a, b);

        // then
        assertEquals(7, result);
    }

    @Test
    public void shouldAdd1To1Result2() {
        // given
        Calculator calculator = new Calculator();
        int a = 1;
        int b = 1;

        // when
        int result = calculator.add(a, b);

        // then
        assertEquals(2, result);
    }

}