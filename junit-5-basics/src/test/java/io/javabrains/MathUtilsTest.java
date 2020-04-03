package io.javabrains;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Nested
    @DisplayName("Add method")
    class AddTest {

        @Test
        @DisplayName("When adding two positive numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
        }

        @Test
        @DisplayName("When adding two negative numbers")
        void testAddNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1, -1);

            assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
        }
    }

    @Test
    @DisplayName("multiply method")
    void testMultiply() {
        assertAll(() -> assertEquals(4, mathUtils.multiply(2, 2)), () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1)));
    }

    @Test
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");
    }

    @Test
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                "The computeCircleArea method should compute two numbers");
    }
}
