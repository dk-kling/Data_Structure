package Queue;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q1 = new ArrayQueue<Integer>(5);
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		System.out.println(q1.print());
		System.out.println(q1.reversePrint());
	}

}
