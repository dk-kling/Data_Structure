package week_02;

import java.util.Scanner;

public abstract class Calculate implements ManageIO { 
	// 추상 클래스 Calculate를 만듭니다
	Scanner input = new Scanner(System.in);

	// 각 연산에 해당하는 추상메소드를 정의합니다.
	public abstract int sum(int a, int b);
	public abstract int sub(int a, int b);
	public abstract int mul(int a, int b);
	public abstract double div(int a, int b);
	public abstract double log(int a, int b);
	public abstract double square(int a, int b);

	//인터페이스 ManageIO의 메소드를 재정의합니다.
	
	// ManageIO에서 받아온 메소드를 재정의합니다.
	@Override
	public void printResult(int choiceNum, int a, int b) {
		// 출력문을 만드는 메소드입니다.
		String cal = null; // 어떤 연산인지를 저장하는 String cal을 선언합니다.
		double result = 0; // 계산 결과값

		switch (choiceNum) { // 연산 선택에 사용되는 변수 cho에 따라 cal의 값을 저장합니다.
		case 1: // sum
			result = sum(a, b);
			cal = " + ";
			break;
		case 2: // sub
			result = sub(a, b);
			cal = " - ";
			break;
		case 3: // mul
			result = mul(a, b);
			cal = " * ";
			break;
		case 4: // div
			result = div(a, b);
			cal = " / ";
			break;
		case 5: // log
			result = log(a, b);
			cal = " * log ";
			break;
		case 6: // square
			result = square(a, b);
			cal = " ^ ";
			break;
		case 9:
			System.out.println("시스템을 종료합니다.");
			return;
		}
		// 계산식을 출력합니다.
		System.out.println(a + cal + b + " = " + result);
	}

	@Override
	public int inputChoice() {

		int choiceNum;
		// do-while문을 이용한 연산 선택
		do { // 연산 선택
			System.out.print("연산 선택 (1.sum 2.sub 3.mul 4.div 5.log 6.square 9.종료");
			choiceNum = input.nextInt();
		} while ((choiceNum > 6 && choiceNum != 9) || choiceNum < 1);
		// 연산 선택의 범주에 없으면 다시 연산 선택

		return choiceNum; // 연산 선택 변수 리턴
	}

	@Override
	public int inputFirstNum() {
		// 첫 번째 수를 받아옵니다.
		System.out.print("첫 번째 수 : ");
		return input.nextInt();
	}

	@Override
	public int inputSecondNum() {
		// 두 번째 수를 받아옵니다.
		System.out.print("두 번째 수 : ");
		return input.nextInt();
	}
}
