package com.example.calculator3;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operator;

    public char getOperator(){
        return operator;
    }

    OperatorType(char operator) {
        this.operator = operator;
    }

}
