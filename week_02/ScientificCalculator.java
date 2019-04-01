package week_02;

public class ScientificCalculator extends Calculate { 
	// 추상클래스 Calculate를 상속받는 클래스를 만듭니다.

	// 추상클래스 Calculate의 추상메소드를 재정의 합니다.
	public int sum(int a, int b) {
		return (a + b);
	}

	public int sub(int a, int b) {
		return (a - b);
	}

	public int mul(int a, int b) {
		return (a * b);
	}

	public double div(int a, int b) {
		if (b == 0) // 나누는 값이 0일 경우 예외처리합니다.
			throw new IllegalArgumentException("나누는 수는 0이 될 수 없습니다.");
		return (a / b);
	}

	public double log(int a, int b) {
		if (b == 0) // 로그의 윗수 값이 0일 경우 예외처리합니다.
			throw new IllegalArgumentException("로그의 윗수는 0이 될 수 없습니다.");
		return (a * Math.log(b)); // Math 함수를 사용해 계산합니다.
	}

	public double square(int a, int b) {
		return Math.pow(a, b); // Math 함수를 사용해 계산합니다.
	}
}
