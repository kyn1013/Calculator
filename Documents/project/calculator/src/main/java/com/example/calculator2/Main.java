package com.example.calculator2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while(true){
            int[] number = new int[2]; //피연산자를 담을 배열
            int answer = 0;

            System.out.print("숫자 2개를 입력하세요 : ");
            for (int i = 0; i < 2; i++){
                number[i] = sc.nextInt();
            }

            sc.nextLine();

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

        //연산 결과 조회, 수정, 삭제 부분
        int[] inputs = new int[3];
        System.out.println("전체 연산 결과 리스트: " + calculator.getAllResults());
        System.out.print("조회하고 싶은 인덱스를 입력하세요 : ");
        inputs[0] = sc.nextInt();
        System.out.println("해당 인덱스의 계산 결과값 : " + calculator.getResults(inputs[0]));
        System.out.print("수정할 인덱스 자리와 해당 값을 입력하세요((ex) 0, 2) : ");
        for (int i = 1; i < 3; i++){
            inputs[i] = sc.nextInt();
        }
        calculator.setResult(inputs[1], inputs[2]);
        System.out.println("전체 연산 결과 리스트: " + calculator.getAllResults());
        System.out.println("가장 먼저 저장된 계산 결과값을 삭제합니다!");
        calculator.deleteFirstResult();
        System.out.println("전체 연산 결과 리스트: " + calculator.getAllResults());
    }
}
