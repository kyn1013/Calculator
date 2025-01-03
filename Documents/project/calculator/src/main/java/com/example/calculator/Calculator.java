package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] number = new int[2]; // 숫자를 담을 배열
        int answer = 0;

        for (int i = 0; i < 2; i++){
            number[i] = sc.nextInt();
        }

        sc.nextLine(); //버퍼 비우기

        System.out.print("사칙연산 기호를 입력하세요 : ");
        String operatorStr = sc.nextLine();
        char operator = operatorStr.charAt(0);
        System.out.println(operator);

        switch (operator) {
            case '+':
                answer = number[0] + number[1];
                break;

            case '-':
                answer = number[0] - number[1];
                break;

            case '*':
                answer = number[0] * number[1];
                break;

            case '/':
                answer = number[0] / number[1];
                break;
        }

        System.out.println("결과 : " + answer);
    }
}
