package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {10, 3628800}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorial(int input, long expected) {
        Assert.assertEquals(FactorialCalculator.factorial(input), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }
}