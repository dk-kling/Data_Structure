package Stack;

public class TestArrayStack {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayStack<String> crates = new ArrayStack(4);
		crates.push("CARROTS");
		crates.push("ORANGES");
		crates.push("RAISINS");
		crates.push("PICKLES");
		crates.push("BANANAS");
		System.out.println("crates.size(): " + crates.size() + "  crates.peek(): " + crates.peek());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.size(): " + crates.size() + "  crates.peek(): " + crates.peek());
		crates.push("WALNUTS");
		crates.push("OYSTERS");
		System.out.println("crates.size(): " + crates.size() + "  crates.peek(): " + crates.peek());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
	}

}
