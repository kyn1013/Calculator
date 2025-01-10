package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //값을 저장할 결과값 리스트 선언, 다형성을 위해 ArrayList를 List타입으로 선언
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

    // 연산 수행 메서드
    public int calculate(int number1, int number2, char operator){
        int answer = 0;

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
