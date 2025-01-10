package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {

    private OperatorType addOperator = OperatorType.ADD;
    private OperatorType subtractOperator = OperatorType.SUBTRACT;
    private OperatorType divideOperator = OperatorType.DIVIDE;
    private OperatorType multiplyOperator = OperatorType.MULTIPLY;

    private List<Double> results = new ArrayList<>();

    public <T extends Number> Double calculate(T number1, T number2, String operator){
        double answer = 0.0;

        //연산 수행
        if (operator.equals(addOperator.getOperator())) {
            answer = number1.doubleValue() + number2.doubleValue();
        } else if (operator.equals(subtractOperator.getOperator())) {
            answer = number1.doubleValue() - number2.doubleValue();
        } else if (operator.equals(multiplyOperator.getOperator())) {
            answer = number1.doubleValue() * number2.doubleValue();
        } else if (operator.equals(divideOperator.getOperator())) {
            answer = number1.doubleValue() / number2.doubleValue();
        }

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
