package com.example.calculator3;

public enum OperatorType {
    PLUS("+") {
        @Override
        public <T extends Number> double calculate(T x, T y) {
            return x.doubleValue() + y.doubleValue();
        }
    },
    MINUS("-") {
        @Override
        public <T extends Number> double calculate(T x, T y) {
            return x.doubleValue() - y.doubleValue();
        }
    },
    MULTIPLY("*") {
        @Override
        public <T extends Number> double calculate(T x, T y) {
            return x.doubleValue() * y.doubleValue();
        }
    },
    DIVIDE("/") {
        @Override
        public <T extends Number> double calculate(T x, T y) {
            if (y.doubleValue() == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return x.doubleValue() / y.doubleValue();
        }
    };

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public abstract <T extends Number> double calculate(T x, T y);
}

