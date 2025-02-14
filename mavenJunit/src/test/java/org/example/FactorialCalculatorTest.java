package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0), "Факториал 0 должен быть 1");
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1), "Факториал 1 должен быть 1");
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.factorial(5), "Факториал 5 должен быть 120");
    }

    @Test
    void testFactorialOfLargeNumber() {
        assertEquals(3628800, FactorialCalculator.factorial(10), "Факториал 10 должен быть 3628800");
    }

    @Test
    void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                FactorialCalculator.factorial(-5);
            }
        });
        assertEquals("Число должно быть неотрицательным", exception.getMessage());
    }
}
