package com.example.devcalc.application.service;

import com.example.devcalc.application.service.entities.domain.OperationEnum;
import org.springframework.stereotype.Service;

@Service
public class MathOperationService {

    public double operation(double a, double b, OperationEnum operation) {
        switch (operation) {
            case ADD -> {
                return a + b;
            }
            case SUBTRACT -> {
                return a - b;
            }
            case MULTIPLY -> {
                return a * b;
            }
            case DIVIDE -> {
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                return a / b;
            }
        }
        throw new IllegalArgumentException("Operation not mapped.");
    }
}
