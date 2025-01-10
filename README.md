## Calculator
Enum, 제네릭, 람다 & 스트림을 적용한 사칙연산 계산기
- 피연산자 2개와 +, -, *, / 연산자를 입력받아 사칙연산을 수행 
- 사칙연산을 수행한 결과에 대해서 조회, 수정, 삭제 가능
- 최소값을 입력받아 해당 값 이상의 결과값만 조회하는 기능
- 정수형, 부동소수점형에 대해서 연산 가능
- 연산자 및 피연산자에 대한 예외처리
- 0으로 나눈 경우에 대한 예외처리 

### Parser (Class)
- 입력받은 연산자 및 피연산자 값들에 대해서 검증하는 역할의 class
    - BadInputException : 숫자 타입을 입력하지 않은 경우 발생하는 예외
    - InvalidOperatorException : 사칙연산 기호가 아닌 다른 값을 입력했을 때 발생하는 예외

###  ArithmeticCalculator (Class)
- OperatorType을 이용하여 연산을 수행하는 역할의 class
- 수행한 연산의 결과값을 저장, 수정, 삭제, 조회
- 연산의 결과값을 정확하게 저장 위해 수행한 연산의 결과값을 저장할 요소 타입은 Double로 선언
- DivideByZeroException : 0으로 나눈 경우에 발생하는 예외

### OperatorType (Enum)
- +, -, *, / 에 대한 class
- calculate의 매게변수 타입을 제네릭으로 선언하여 Parser Class의 executeCalculator 메서드에서 정수나 부동소수점형을 삽입 할 수 있음  
- calculate 메서드를 추상 메서드로 선언 후 각각의 연산자 타입에서 오버라이딩 하여 다르게 구현
