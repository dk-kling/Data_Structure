package RPN;

//import week_04.ArrayStack;

public class RPN {

	/*public double RPN(String[] result) {
		ArrayStack<String> stack = new ArrayStack<String>(result.length);
		for (int indexOfResult = 0; indexOfResult < result.length; indexOfResult++) {
			if (this.isAnOperation(result[indexOfResult])) {
				double secondNum = Double.parseDouble(stack.pop());
				double firstNum = Double.parseDouble(stack.pop());
				double resultOfCal = this.evaluate(firstNum, secondNum, result[indexOfResult]);
				stack.push(Double.toString(resultOfCal));
			} else {
				stack.push(result[indexOfResult]);
			}
		}
		return Double.parseDouble(stack.pop());
	}

	private boolean isAnOperation(String str) {
		return (str.length() == 1 && "+-".indexOf(str) >= 0);
	}

	private double evaluate(double firstNum, double secondNum, String cal) {
		double result = 0;
		switch (cal) {
		case "+":
			result = firstNum + secondNum;
			break;
		case "-":
			result = firstNum - secondNum;
			break;
		case "*":
			result = firstNum * secondNum;
			break;
		case "/":
			result = firstNum / secondNum;
			break;
		}
		System.out.println(firstNum + " " + cal + " " + secondNum + " = " + result);
		return result;
	}*/
}