package com.example.calculator3;

import com.example.common.exception.DivideByZeroException;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {

    private List<Double> results = new ArrayList<>();

    public <T extends Number> Double calculate(T firstInput, T secondInput, String operator) throws DivideByZeroException {
        double answer = switch (operator) {
            case "+" -> OperatorType.PLUS.calculate(firstInput, secondInput);
            case "-" -> OperatorType.MINUS.calculate(firstInput, secondInput);
            case "*" -> OperatorType.MULTIPLY.calculate(firstInput, secondInput);
            case "/" -> OperatorType.DIVIDE.calculate(firstInput, secondInput);
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };

        results.add(answer);
        return answer;
    }

    public String getResult(int minimum){
        String filterdResults =  this.results.stream()
                .filter( result -> result > minimum)
                .toList()
                .toString();

        return filterdResults;
    }

    public String getAllResults(){
        return results.toString();
    }

    public Double getResults(int index){
        return results.get(index);
    }

    public void setResult(int index, double value){
        results.set(index, value);
    }

    public void deleteFirstResult(){
        results.remove(0);
    }

}
