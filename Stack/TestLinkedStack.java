package Stack;

public class TestLinkedStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedStack<Object> crates = new LinkedStack<Object>();
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
