package com.example.app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MainTest {
    @Test
    public void shouldVerifyThatExceptionIsThrownWithoutFramework() {
        try {
            divideByZero();
        } catch (ArithmeticException e) {
            assertThat(e.getMessage()).isEqualTo("/ by zero");
            return;
        }
        Assertions.fail("Expected exception was not thrown!");
    }

    // Z wykorzystaniem JUnit5:
    @Test
    public void shouldVerifyThatExceptionIsThrownWithJUnit5() {
        ArithmeticException e = assertThrows(ArithmeticException.class, this::divideByZero);
        assertThat(e.getMessage()).isEqualTo("/ by zero");
    }

    // Z wykorzystaniem AssertJ:
    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJFail() {
        assertThatThrownBy(this::divideByZero)
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageEndingWith("zero");
    }

    // Opr�cz tego mo�emy r�wnie� wykorzysta� metody podobne do JUnit 5, gdzie dostajemy obiekt i unikamy zagnie�d�enia:
    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJLessFluent() {
        ArithmeticException at = catchThrowableOfType(this::divideByZero, ArithmeticException.class);
        Throwable t = catchThrowable(this::divideByZero);

        assertThat(t)
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageEndingWith("zero");
    }

    // Istniej� r�wnie� dodatkowe metody umo�liwiaj�ce po prostu przerwanie testu z informacj� o
    // braku po��danego wyj�tku. Wszystkie robi� to samo.
    @Test
    public void shouldThrow() {
        shouldHaveThrown(FileNotFoundException.class);
        failBecauseExceptionWasNotThrown(RuntimeException.class);
        shouldHaveThrown(IOException.class);
    }

    private void divideByZero() {
        int doNotDoThat = 5/0;
    }
}