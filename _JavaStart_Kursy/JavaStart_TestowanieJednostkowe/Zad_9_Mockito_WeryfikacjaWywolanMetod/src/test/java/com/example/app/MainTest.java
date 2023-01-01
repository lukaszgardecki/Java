package com.example.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MainTest {

    @Test
    void verifyExample() {
        Main mock = mock(Main.class);

        // wywo�ujemy metod� 2 razy:
        mock.myMethod();
        mock.myMethod();

        // sprawdzamy czy metoda zosta�a wywo�ana 2 razy: ...gdzie tu logika?
        verify(mock, times(2)).myMethod();
    }
}