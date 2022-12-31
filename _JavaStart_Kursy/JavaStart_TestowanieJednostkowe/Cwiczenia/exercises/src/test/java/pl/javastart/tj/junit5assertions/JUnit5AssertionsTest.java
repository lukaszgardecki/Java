package pl.javastart.tj.junit5assertions;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit5AssertionsTest {
    private JUnit5Assertions entity;

    @BeforeEach
    public void init() {
        entity = new JUnit5Assertions();
    }

    @Test
    @DisplayName("Is prime number? 2 -> true")
    public void shouldReturnTrueFor2() {
        boolean primeNumber = entity.isPrimeNumber(2);
        assertTrue(primeNumber);
    }

    @Test
    @DisplayName("Is prime number? 12 -> false")
    public void shouldReturnFalseFor12() {
        boolean primeNumber = entity.isPrimeNumber(12);
        assertFalse(primeNumber);
    }

    @Test
    @DisplayName("Is prime number? 5 -> true")
    public void shouldReturnTrueFor5() {
        boolean primeNumber = entity.isPrimeNumber(5);
        assertTrue(primeNumber);
    }

    @Test
    public void shouldReturnValidCode() {
        JUnit5Assertions.Code code = entity.getCode("a");

        assertEquals("a", code.getKey());
        assertNotNull(code.getCreatedAtTimestamp());
        assertNotNull(code.getCode());
    }

    @Test
    public void shouldReturnSameObjects() {
        JUnit5Assertions.Code code1 = entity.getCode("a");
        JUnit5Assertions.Code code2 = entity.getCode("a");
        assertSame(code1, code2);
    }

    @Test
    public void shouldReturnDifferentObjects() {
        JUnit5Assertions.Code code1 = entity.getCode("a");
        JUnit5Assertions.Code code2 = entity.getCode("b");
        assertNotSame(code1, code2);
    }


    @Test
    public void allJUnit5Assertions() {
//        Assertions.assertFalse();
//        Assertions.assertTrue();
//
//        Assertions.assertNull();
//        Assertions.assertNotNull();
//
//        Assertions.assertEquals();
//        Assertions.assertNotEquals();
//
//        Assertions.assertSame();
//        Assertions.assertNotSame();
//
//        Assertions.assertThrows()
//        Assertions.assertDoesNotThrow();
//
//        Assertions.assertLinesMatch();
//
//        Assertions.assertTimeout()
//        Assertions.assertTimeoutPreemptively();
//
//        Assertions.assertIterableEquals();
//        Assertions.assertArrayEquals();
//
//        Assertions.fail();
//        Assertions.assertAll();
    }

}
