package week_02;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 객체 생성
		ScientificCalculator calculator = new ScientificCalculator();

		// 필드 선언
		int choice = 0; // 연산 선택하는 변수
		int firstNum = 0; // 연산하는 첫 번째 변수
		int secondNum = 0; // 연산하는 두 번째 변수
		
		while (choice != 9){
		choice = calculator.inputChoice();
		//연산 선택 변수 입력/저장
		if (choice < 7) { // 연산이 선택 되었을 때 계산할 2개의 값 입력/저장
			firstNum = calculator.inputFirstNum();
			secondNum = calculator.inputSecondNum();
		}
		//출력
		calculator.printResult(choice, firstNum, secondNum);

		}
	}
}
