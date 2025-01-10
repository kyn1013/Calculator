package com.example.calculator3;

import com.example.common.exception.DivideByZeroException;

public enum OperatorType {
    PLUS("+") {
        @Override
        public <T extends Number> double calculate(T firstInput, T secondInput) {
            return firstInput.doubleValue() + secondInput.doubleValue();
        }
    },
    MINUS("-") {
        @Override
        public <T extends Number> double calculate(T firstInput, T secondInput) {
            return firstInput.doubleValue() - secondInput.doubleValue();
        }
    },
    MULTIPLY("*") {
        @Override
        public <T extends Number> double calculate(T firstInput, T secondInput) {
            return firstInput.doubleValue() * secondInput.doubleValue();
        }
    },
    DIVIDE("/") {
        @Override
        public <T extends Number> double calculate(T firstInput, T secondInput) throws DivideByZeroException {
            if (secondInput.doubleValue() == 0) {
                throw new DivideByZeroException();
            }
            return firstInput.doubleValue() / secondInput.doubleValue();
        }
    };

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public abstract <T extends Number> double calculate(T firstInput, T secondInput) throws DivideByZeroException;
}

