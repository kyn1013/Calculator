package com.example.calculator3;

public enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operator;

    public String getOperator(){
        return operator;
    }

    OperatorType(String operator) {
        this.operator = operator;
    }

}
