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

    // Oprócz tego mo¿emy równie¿ wykorzystaæ metody podobne do JUnit 5, gdzie dostajemy obiekt i unikamy zagnie¿d¿enia:
    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJLessFluent() {
        ArithmeticException at = catchThrowableOfType(this::divideByZero, ArithmeticException.class);
        Throwable t = catchThrowable(this::divideByZero);

        assertThat(t)
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageEndingWith("zero");
    }

    // Istniej¹ równie¿ dodatkowe metody umo¿liwiaj¹ce po prostu przerwanie testu z informacj¹ o
    // braku po¿¹danego wyj¹tku. Wszystkie robi¹ to samo.
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