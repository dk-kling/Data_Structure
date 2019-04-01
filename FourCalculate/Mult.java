package FourCalculate;

public class Mult extends CalculateOfPrint {

	public Mult(double first, double second) {
		super(first, second);
	}

	public double calculate() {
		double first = this.get_firstNum();
		double second = this.get_secondNum();
		return first * second;

	}
	
}
