package com.example.calculator3;

import com.example.common.exception.DivideByZeroException;

// 연산자 및 해당 연산자에 해당하는 연산메서드를 선언한 enum class
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

    //계산을 수행하는 메서드를 추상메서드로 선언하여 각각의 연산자 객체가 오버라이딩하여 구현
    public abstract <T extends Number> double calculate(T firstInput, T secondInput) throws DivideByZeroException;
}

