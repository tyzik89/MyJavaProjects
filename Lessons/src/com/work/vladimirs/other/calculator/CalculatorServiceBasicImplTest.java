package com.work.vladimirs.other.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

class CalculatorServiceBasicImplTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void init() {
        calculatorService = new CalculatorServiceBasicImpl();
    }

    @Test
    void calculate() {
        double actual = calculatorService.calculate("5");
        Assertions.assertEquals(5, actual);

        actual = calculatorService.calculate("-5");
        Assertions.assertEquals(-5, actual);

        actual = calculatorService.calculate("5-5");
        Assertions.assertEquals(0, actual);

        actual = calculatorService.calculate("5+5");
        Assertions.assertEquals(10, actual);

        actual = calculatorService.calculate("4-5");
        Assertions.assertEquals(-1, actual);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> calculatorService.calculate("5-"));
    }
}