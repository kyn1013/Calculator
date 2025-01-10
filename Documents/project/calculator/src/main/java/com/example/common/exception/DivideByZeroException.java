package com.example.common.exception;

public class DivideByZeroException extends Exception{
    public DivideByZeroException (){
        super("0으로 나눌 수는 없습니다!");
    }
}
