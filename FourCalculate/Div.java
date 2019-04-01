package FourCalculate;

public class Div extends CalculateOfPrint {

	public Div(double first, double second) {
		super(first, second);
	}

	public double calculate() {
		double first = this.get_firstNum();
		double second = this.get_secondNum();
		return first / second;

	}
	
}
