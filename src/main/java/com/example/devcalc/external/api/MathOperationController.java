package com.example.devcalc.external.api;

import com.example.devcalc.application.service.MathOperationService;
import com.example.devcalc.application.service.entities.domain.OperationEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/operation")
public class MathOperationController {

    private final MathOperationService service;

    public MathOperationController(MathOperationService service) {
        this.service = service;
    }

    @GetMapping("add")
    public double add(Double a, Double b) {
        return service.operation(a, b, OperationEnum.ADD);
    }

    @GetMapping("subtract")
    public double subtract(double a, double b) {
        return service.operation(a, b, OperationEnum.SUBTRACT);
    }

    @GetMapping("multiply")
    public double multiply(double a, double b) {
        return service.operation(a, b, OperationEnum.MULTIPLY);
    }

    @GetMapping("divide")
    public double divide(double a, double b) {
        return service.operation(a, b, OperationEnum.DIVIDE);
    }
}
