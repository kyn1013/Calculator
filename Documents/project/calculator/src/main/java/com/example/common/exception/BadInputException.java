package com.example.common.exception;

public class BadInputException extends Exception{
    public BadInputException(String type) {
        super("올바르지 않은 입력값입니다. " + type + "을 입력해 주세요!");
    }
}
