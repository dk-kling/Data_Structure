package FourCalculate;

public abstract class CalculateOfPrint implements Calculate {

	private double _firstNum;
	private double _secondNum;

	public double get_firstNum() {
		return _firstNum;
	}

	public void set_firstNum(double firstNum) {
		this._firstNum = firstNum;
	}

	public double get_secondNum() {
		return _secondNum;
	}

	public void set_secondNum(double secondNum) {
		this._secondNum = secondNum;
	}

	protected CalculateOfPrint(double firstNum, double secondNum) {
		this.set_firstNum(firstNum);
		this.set_secondNum(secondNum);
	}

	public void printThem() {
		System.out.println("결과 " + calculate() );
	}

}
