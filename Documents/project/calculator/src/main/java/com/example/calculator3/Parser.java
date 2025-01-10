package com.example.calculator3;

import com.example.common.exception.BadInputException;
import com.example.common.exception.DivideByZeroException;
import com.example.common.exception.InvalidOperatorException;

import java.util.regex.Pattern;

/*
* 입력값을 검증하는 class, ArithmeticCalculator에 입력값 검증까지 포함하면 책임이 너무 커지기에 분리
*/
public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private String firstInput;
    private String secondInput;
    private String operator;

    private final ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

    public ArithmeticCalculator getArithmeticCalculator() {
        return arithmeticCalculator;
    }

    //입력받은 피연산자가 숫자가 아닌 경우룰 처리하는 예외 처리 메서드
    public void validateInputNumbers(String firstInput, String secondInput) throws BadInputException {
        if (!Pattern.matches(NUMBER_REG, firstInput) || !Pattern.matches(NUMBER_REG, secondInput)) {
            throw new BadInputException("숫자타입");
        }
        setFirstInput(firstInput);
        setSecondInput(secondInput);
    }

    //입력받은 연산자가 사칙연산자에서 벗어난 경우룰 처리하는 예외 처리 메서드
    public void validateOperator(String operator) throws InvalidOperatorException{
        if (!Pattern.matches(OPERATION_REG, operator)) {
            throw new InvalidOperatorException();
        }
        setOperator(operator);
    }

    //필드로 가지고 있는 ArithmeticCalculator를 호출하여 연산을 수행
    public Double executeCalculator() throws DivideByZeroException {
        // 여기서 String 타입의 피연산자들을 실수형이나 정수형으로 변환하여 자유롭게 넣어 줄 수 있음, Integer도 가능
        Double firstNumber = Double.parseDouble(firstInput);
        Double secondNumber = Double.parseDouble(secondInput);
        return arithmeticCalculator.calculate(firstNumber, secondNumber, operator);
    }

    public void setFirstInput(String firstInput) {
        this.firstInput = firstInput;
    }

    public void setSecondInput(String secondInput) {
        this.secondInput = secondInput;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
