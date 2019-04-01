package FourCalculate;

public class Sub extends CalculateOfPrint {

	public Sub(double first, double second) {
		super(first, second);
	}

	public double calculate() {
		double first = this.get_firstNum();
		double second = this.get_secondNum();
		return first - second;

	}
	
}
