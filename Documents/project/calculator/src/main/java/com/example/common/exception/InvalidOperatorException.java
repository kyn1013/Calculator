package com.example.common.exception;

public class InvalidOperatorException extends Exception{
    public InvalidOperatorException(){
        super("사칙연산 기호만 입력해 주세요! (+, -, *, /)");
    }
}
