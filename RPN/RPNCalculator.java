package RPN;

public class RPNCalculator {

	/*public RPNCalculator(String[] args) {
		// TODO Auto-generated method stub
		week_04.ArrayStack<String> stack = new week_04.ArrayStack<String>(args.length);
		for (int i = 0; i < args.length; i++) {
		String input = args[i];
		if (isAnOperator(input)) {
		double y = Double.parseDouble((String)stack.pop());
		double x = Double.parseDouble((String)stack.pop());
		double z = evaluate(x, y, input);
		stack.push("" + z);
		}
		else stack.push(input);
		}
	}
	private boolean isAnOperator(String s) {
		return (s.length() == 1 && "ASMD".indexOf(s) >= 0);
	}
	
	private double evaluate(double x, double y, String op) {
		double z = 0;
		if (op.equals("A")) z = x + y;
		else if (op.equals("S")) z = x - y;
		else if (op.equals("M")) z = x * y;
		else z = x / y;
		System.out.println(x + " " + op + " " + y + " = " + z);
		return z;
	
	}
		public static void main(String[] args) {
		AppController appController = new AppController() ;
		appController.run();
		}*/

}
