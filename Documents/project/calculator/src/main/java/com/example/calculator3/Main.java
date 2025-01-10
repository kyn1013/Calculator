package com.example.calculator3;

import com.example.common.exception.BadInputException;
import com.example.common.exception.DivideByZeroException;
import com.example.common.exception.InvalidOperatorException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();

        while(true){
            try{
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                String firstNumber = sc.nextLine();
                System.out.print("두 번째 숫자를 입력하세요 : ");
                String secondNumber = sc.nextLine();

                parser.validateInputNumbers(firstNumber, secondNumber);

                System.out.print("사칙연산 기호를 입력하세요 : ");
                String operator = sc.nextLine();

                parser.validateOperator(operator);

                System.out.println("결과 : " + parser.executeCalculator());
                System.out.print("종료하려면 exit 입력, 아니라면 enter을 입력하세요 : ");
                String exit = sc.nextLine();
                exit = exit.toLowerCase();
                if (exit.equals("exit")){
                    break;
                }
            } catch (BadInputException e) {
                System.out.println(e.getMessage());
            } catch (InvalidOperatorException e) {
                System.out.println(e.getMessage());
            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("계산기를 종료했습니다.");

        ArithmeticCalculator calculator = parser.getArithmeticCalculator();

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

        System.out.print("연산 결과 중에서 입력받을 해당 값보다 큰 값들만 출력할 예정입니다. 값을 입력해 주세요 : ");
        int minimum = sc.nextInt();
        System.out.println("입력된 값보다 큰 결과값 출력 : " + calculator.getResult(minimum));

    }
}
