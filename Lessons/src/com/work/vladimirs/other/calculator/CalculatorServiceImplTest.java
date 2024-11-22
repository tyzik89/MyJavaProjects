package com.work.vladimirs.other.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorServiceImplTest {

    private CalculatorService calculatorService;

    @Test
    void calculateUltraExtended() {
        calculatorService = new CalculatorServiceUltraExtendedImpl();

        double actual = calculatorService.calculate("5 * (5 - 1)"); // 5  5  1 - *
        Assertions.assertEquals(20, actual);

        actual = calculatorService.calculate("2 - (8 + 6) + 1 * 6 * (2 / 2) - 1"); // 2  8  6 + - 1  6 * 2  2 / * + 1 -
        Assertions.assertEquals(-7, actual);

        actual = calculatorService.calculate("2 - (8 + 6) + 1 * 6 * (((2 / 2) - 1) + 1)"); // 2  8  6 + - 1  6 * 2  2 /  1 -  1 + * +
        Assertions.assertEquals(-6, actual);
    }

    @Test
    void calculateExtended() {
        calculatorService = new CalculatorServiceExtendedImpl();

        double actual = calculatorService.calculate("5 * 5");
        Assertions.assertEquals(25, actual);

        actual = calculatorService.calculate("10 + 2 * 8 - 3");
        Assertions.assertEquals(23, actual);

        actual = calculatorService.calculate("10 + 2 * 8 - 3 * 3");
        Assertions.assertEquals(17, actual);

        actual = calculatorService.calculate("2 * 8 / 4 * 3");
        Assertions.assertEquals(12, actual);

        actual = calculatorService.calculate("2 - 8 + 6 + 1 * 6 * 2 / 2 - 1");
        Assertions.assertEquals(5, actual);
    }

    @Test
    void calculateBasic() {
        calculatorService = new CalculatorServiceBasicImpl();

        double actual = calculatorService.calculate("5");
        Assertions.assertEquals(5, actual);

        actual = calculatorService.calculate("5 - 5");
        Assertions.assertEquals(0, actual);

        actual = calculatorService.calculate("5 + 5");
        Assertions.assertEquals(10, actual);

        actual = calculatorService.calculate("4 - 5");
        Assertions.assertEquals(-1, actual);

        actual = calculatorService.calculate("4 - 5 + 8");
        Assertions.assertEquals(7, actual);

        actual = calculatorService.calculate("10 + 2 - 8 + 3");
        Assertions.assertEquals(7, actual);

        actual = calculatorService.calculate("-5");
        Assertions.assertEquals(-5, actual);

        Assertions.assertThrows(UnsupportedOperationException.class, () -> calculatorService.calculate("5-"));
    }
}