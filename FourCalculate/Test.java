package FourCalculate;

import java.util.Scanner;

public class Test {
	
	public static void main (String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		Calculate mainCalculate;
		int choice;
		double main_firstNum = 0;
		double main_secondNum = 0;
		
		do {
		System.out.println("숫자를 입력해 선택지를 고르세요.");
		System.out.println("1.덧셈 2.뺄셈 3.곱셈 4.나눗셈 5.시스템 종료");
		choice = input.nextInt();
		}
		while (choice > 5 || choice < 1);
		
		if (choice < 5){
			System.out.println("첫 번째 수를 입력하시오.");
		    main_firstNum = input.nextDouble();
		
		    System.out.println("두 번째 수를 입력하시오.");
		    main_secondNum = input.nextDouble();
		}
		
		
		switch (choice) {
		case 1:
			mainCalculate = new Add(main_firstNum, main_secondNum);
			mainCalculate.printThem();
			break;
		case 2:
			mainCalculate = new Sub(main_firstNum, main_secondNum);
			mainCalculate.printThem();
			break;
		case 3:
			mainCalculate = new Mult(main_firstNum, main_secondNum);
			mainCalculate.printThem();
			break;
		case 4:
			mainCalculate = new Div(main_firstNum, main_secondNum);
			mainCalculate.printThem();
			break;
		case 5:
			System.out.println("시스템을 종료합니다.");
			return;
		}
			
	}

}

