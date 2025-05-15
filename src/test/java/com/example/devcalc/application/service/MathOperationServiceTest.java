package com.example.devcalc.application.service;

import com.example.devcalc.application.service.entities.domain.OperationEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathOperationServiceTest {

    private MathOperationService service;

    @BeforeEach
    void setUp() {
        service = new MathOperationService();
    }

    @Test
    void shouldAddNumbersCorrectly() {
        double result = service.operation(5, 3, OperationEnum.ADD);
        assertEquals(8, result);
    }

    @Test
    void shouldSubtractNumbersCorrectly() {
        double result = service.operation(10, 4, OperationEnum.SUBTRACT);
        assertEquals(6, result);
    }

    @Test
    void shouldMultiplyNumbersCorrectly() {
        double result = service.operation(2, 3, OperationEnum.MULTIPLY);
        assertEquals(6, result);
    }

    @Test
    void shouldThrowError() {
        assertThrows(IllegalArgumentException.class, () -> service.operation(2, 3, OperationEnum.valueOf("TESTE")));
    }

    @Test
    void shouldDivideNumbersCorrectly() {
        double result = service.operation(10, 2, OperationEnum.DIVIDE);
        assertEquals(5, result);
    }

    @Test
    void shouldThrowArithmeticExceptionWhenDividingByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> service.operation(10, 0, OperationEnum.DIVIDE)
        );
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }
}
