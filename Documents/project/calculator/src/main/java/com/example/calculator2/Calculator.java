package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results = new ArrayList<Integer>();

    public String getAllResults(){
        return results.toString();
    }

    public int getResults(int index){
        return results.get(index);
    }

    public void setResult(int index, int value){
        results.set(index, value);
    }

    public void deleteFirstResult(){
        results.remove(0);
    }

    public int calculate(int number1, int number2, char operator){
        int answer = 0;

        //연산 수행
        if (operator == '+') {
            answer = number1 + number2;
        } else if (operator == '-') {
            answer = number1 - number2;
        } else if (operator == '*') {
            answer = number1 * number2;
        } else if (operator == '/') {
            answer = number1 / number2;
        }

        results.add(answer);
        return answer;
    }
}
