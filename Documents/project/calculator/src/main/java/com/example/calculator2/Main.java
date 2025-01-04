package com.example.calculator2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while(true){
            int[] number = new int[2]; // 숫자를 담을 배열
            int answer = 0;

            System.out.print("숫자 2개를 입력하세요 : ");
            for (int i = 0; i < 2; i++){
                number[i] = sc.nextInt();
            }

            sc.nextLine(); //버퍼 비우기

            System.out.print("사칙연산 기호를 입력하세요 : ");
            String operatorStr = sc.nextLine();
            char operator = operatorStr.charAt(0);

            //잘못된 입력값 검증
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/'){
                System.out.println("+, -, *, / 만 입력해 주세요.");
                continue;
            }

            if (number[1] == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }

            answer = calculator.calculate(number[0], number[1], operator);

            System.out.println("결과 : " + answer);
            System.out.print("종료하려면 exit 입력, 아니라면 enter을 입력하세요 : ");
            String exit = sc.nextLine();
            exit = exit.toLowerCase();
            if (exit.equals("exit")){
                break;
            }
        }

        System.out.println("계산기를 종료했습니다.");
    }
}
