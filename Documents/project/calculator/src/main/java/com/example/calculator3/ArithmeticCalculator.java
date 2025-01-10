package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {

    private List<Double> results = new ArrayList<>();

    public <T extends Number> Double calculate(T number1, T number2, String operator){
        double answer = switch (operator) {
            case "+" -> OperatorType.PLUS.calculate(number1, number2);
            case "-" -> OperatorType.MINUS.calculate(number1, number2);
            case "*" -> OperatorType.MULTIPLY.calculate(number1, number2);
            case "/" -> OperatorType.DIVIDE.calculate(number1, number2);
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
