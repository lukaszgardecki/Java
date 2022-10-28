package math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    void beforeAll() {
        System.out.println("Metoda wykonuje siê przed wszystkimi");
    }

    @Nested
    @Tag("Math")
    class AddTest {
        @Test
        @DisplayName("Test for positive")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1));
        }

        @Test
        @DisplayName("Test  for negative")
        void testAddNegative() {
            assertEquals(-2, mathUtils.add(-1, -1));
        }
    }



    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    @Disabled
    void tearDown() {
        System.out.println("Metoda wykonuje siê po ka¿dym teœcie");
    }

    @Test
    @DisplayName("Dodawanie liczb.")
    void should_add_two_numbers() {
        //given
        int expected = 2;

        //when
        int actual = mathUtils.add(1, 1);

        //then
        assertEquals(expected, actual, "The add method should add two numbers");
    }

    @RepeatedTest(5)
    void should_subtract_two_numbers(RepetitionInfo repetitionInfo) {
        repetitionInfo.getCurrentRepetition();
        assertEquals(5, mathUtils.subtract(7, 2));
    }

    @Test
    @DisplayName("Dzielenie dwóch liczb.")
    @DisabledOnOs(OS.MAC)
    void should_divide_two_numbers() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);


        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");

    }

    @Test
    @DisplayName("Pole powierzchni ko³a o zadanej œrednicy.")
    void should_compute_circle_area() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

    @Test
    @DisplayName("Test jest zaliczony gdy wszystkie zawarte w nim testy s¹ zaliczone")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }


}
