package com.example.app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MainWithMockitoTest {

    @Test
    public void shouldThrowNoAccessException() {
        UserManager userManager = mock(UserManager.class);

        when(userManager.findById(1L)).thenThrow(new NoAccessException());

        //to samo co wy¿ej, przydatne w przypadku gdyby metoda findById zwraca³a void
        doThrow(new NoAccessException()).when(userManager).findById(1L);

        assertThatThrownBy(() -> userManager.findById(1L))
                .isInstanceOf(NoAccessException.class);
    }

    private interface UserManager {
        User findById(Long id);
    }

    private static interface User { }
    private static class NoAccessException extends RuntimeException { }
}