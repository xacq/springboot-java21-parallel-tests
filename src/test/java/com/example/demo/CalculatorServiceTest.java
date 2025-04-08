package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    void testSum() {
        CalculatorService calculator = new CalculatorService();
        int result = calculator.sum(2, 3);
        assertEquals(5, result, "Sum of 2 and 3 should be 5");
    }
}
