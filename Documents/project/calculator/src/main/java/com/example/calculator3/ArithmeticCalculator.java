package com.example.calculator3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {

    private OperatorType addOperator = OperatorType.ADD;
    private OperatorType subtractOperator = OperatorType.SUBTRACT;
    private OperatorType divideOperator = OperatorType.DIVIDE;
    private OperatorType multiplyOperator = OperatorType.MULTIPLY;

    private List<Double> results = new ArrayList<>();

    public String getResult(int minimum){
        String filterdResults =  this.results.stream()
                .filter( result -> result > minimum)
                .collect(Collectors.toList())
                .toString();

        return filterdResults;
    }

    public <T extends Number> Double calculate(T number1, T number2, char operator){
        double answer = 0.0;

        //연산 수행
        if (operator == addOperator.getOperator()) {
            answer = number1.doubleValue() + number2.doubleValue();
        } else if (operator == subtractOperator.getOperator()) {
            answer = number1.doubleValue() - number2.doubleValue();
        } else if (operator == multiplyOperator.getOperator()) {
            answer = number1.doubleValue() * number2.doubleValue();
        } else if (operator == divideOperator.getOperator()) {
            answer = number1.doubleValue() / number2.doubleValue();
        }

        results.add(answer);
        return answer;
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
