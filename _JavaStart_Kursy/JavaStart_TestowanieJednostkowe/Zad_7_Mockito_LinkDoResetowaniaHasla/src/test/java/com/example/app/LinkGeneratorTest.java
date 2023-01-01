package com.example.app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LinkGeneratorTest {
    @Test
    void shouldPreparePasswordResetEmail() {
        // mockujemy RandomProvidera:
        RandomProvider randomProvider = Mockito.mock(RandomProvider.class);
        // preparujemy wartoœæ losowego klucza w linku:
        Mockito.when(randomProvider.generateRandomKey()).thenReturn("asdfghjkl1234567890");
        // tworzymy obiekt odpowiedzialny za tworzenie linku:
        PasswordResetMailContentProvider passwordResetMailContentProvider = new PasswordResetMailContentProvider(randomProvider);

        //when
        String resetMailContent = passwordResetMailContentProvider.createResetMailContent();

        //then
        Assertions.assertThat(resetMailContent).isEqualTo("Czeœæ, aby przejœæ do resetowania has³a <a href=\"https://example.com/reset?key=asdfghjkl1234567890\">ten link</a>");
    }
}