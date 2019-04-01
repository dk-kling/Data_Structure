package NodeNBigInt;

public class BigInt {

	private Node head;
	private Node last;
	private int size;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isEmpty() {
		if (getSize() == 0)
			return true;
		else
			return false;
	}

	private static class Node {

		private int _element;
		private Node _next;
		private int digit;

		public int element() {
			return _element;
		}

		public void setElement(int element) {
			this._element = element;
		}

		public Node next() {
			return _next;		
		}

		public void setNext(Node next) {
			this._next = next;
		}

		public Node(int element) {
			this.setElement(element);
			this.setNext(null);
		}

		public Node(int element, Node next) {
			this.setElement(element);
			this.setNext(next);
		}

	}

	public void insert(int x) {

		if (isEmpty()) {
			Node newNode = new Node(x);

			newNode.setNext(getHead());
			setHead(newNode);

			if (getHead().next() == null)
				setLast(getHead());
		} else {
			Node newNode = new Node(x);

			for (Node p = getHead(); p != null; p.next()) {

			}
			getLast().setNext(newNode);

			// newNode == last
			if (newNode.next() == null)
				setLast(newNode);
		}

		// size up
		setSize(getSize() + 1);

	}

	public void delete(int x) {
		// 리스트에 있는 값 x를 찾아서 삭제하는 함수

		// 리스트에 일치하는 x 값이 여러 개일 경우, 가장 처음 만나는 값을 삭제한다
		if (getHead().element() == x) {
			Node tempNode = new Node(getHead().next().element(), getHead().next().next());
			setHead(tempNode);
			tempNode = null;
			setSize(getSize() - 1);
		}

		else {
			for (Node p = getHead(); p != null; p = p.next()) {
				if (p.next().element() == x) {
					p.setNext(p.next().next());
					setSize(getSize() - 1);
					if (p.next() == null)
						setLast(p);
					setSize(getSize() - 1);
				}
			}
		}
		// size를 1을 빼준다.
		setSize(getSize() - 1);
	}

	public Boolean addFirst(int x) {

		if (x < getHead().element()) {
			Node newNode = new Node(x);

			newNode.setNext(getHead());
			setHead(newNode);

			if (getHead().next() == null)
				setLast(getHead());
			setSize(getSize() + 1);

			return true;
		}

		return false;
		/*
		 * 리스트에 가장 앞에 값 x를 추가한다. 오름차순의 순서로 삽입되어야 하기 때문에 x가 가장 작은 값이 아닐 경우 , 리스트에
		 * 추가하지 않고, False를 반환한다
		 */

	}

	public Boolean addLast(int x) {

		if (x > getLast().element()) {
			Node newNode = new Node(x);

			getLast().setNext(newNode);
			setLast(newNode);
			setSize(getSize() + 1);

			return true;
		}

		return false;
		/*
		 * 리스트에 가장 마지막에 값 x를 추가한다. 오름차순의 순서로 삽입되어야 하기 때문에 x가 가장 큰 값이 아닐 경우 ,
		 * 리스트에 추가하지 않고, False를 반환한다
		 */

	}

	public int getLength() {
		// 리스트의 길이를 반환한다.
		return getSize();
	}

	public int getMaxValue() {
		/*
		 * 리스트에서 가장 큰 값을 반환한다.
		 */
		return getLast().element();

	}

	public int getMinValue() {
		/*
		 * 리스트에서 가장 작은 값을 반환한다.
		 */
		return getHead().element();
	}

	public void printList() {
		/*
		 * 리스트에 있는 값을 출력한다 ex) { 11, 22, 33, 44, 55, ... }
		 */
		System.out.println("{ ");
		for (Node p = getHead(); p != null; p.next()) {
			System.out.println(p.element() + " ");
		}
		System.out.println("}");
	}

	public void reversePrint() {
		/*
		 * 리스트에 있는 값을 거꾸로 출력한다 ex) {..., 55, 44, 33, 22, 11 } 재귀함수를 이용
		 */

		// 거꾸로 만들어주는 노드
		Node searchNode = getHead();
		Node returnNode = new Node(getLast().element());
		Node assistNode = new Node(getLast().element());
		int assistInt = getLast().element();

		while (assistInt != getHead().element()) {

			while (searchNode.element() != assistInt)
				if (searchNode.next().element() == returnNode.element()) {
					assistInt = searchNode.element();
					// assistNode.setElement(assistInt);
					assistNode.setElement(assistInt);
					assistNode = assistNode.next();
				} else {
					searchNode = searchNode.next();
				}
		}

		System.out.println("{ ");
		Node tempNode = returnNode;
		for (Node p = new Node(tempNode.element(), tempNode.next()); p != null; p.next()) {
			System.out.println(p.element() + " ");
		}
		System.out.println("}");

	}

	// public void deleteLast() {
	/*
	 * 가장 마지막에 있는 노드를 삭제한다.
	 */

	// }

	// public Node copy() {
	/*
	 * 현재 LinkedList의 리스트를 복사하여 만든 새로운 리스트를 반환한다. 완전히 새로운 Node를 만들어서 반환해야 한다
	 */
	// return getHead();
	// }

	// public Node merged(Node List1, Node List2) {
	/*
	 * 리스트 1과 2를 합쳐 완전히 새로운 리스트를 생성한다. 모든 값은 오름차순으로 정렬되어야 한다 ex) list1 = { 11,
	 * 33, 55 } , List2 = {22, 44, 66 } Retuen Node = { 11, 22, 33, 44, 55, 66 }
	 */
	// return getHead();
	// }

	// public void PerfectSuffle() {
	/*
	 * 4주차 실습에 했던 Perfect Suffle 을 Linked List로 구현하라 초기상태 = {0, 1, 2, 3, 4, 5,
	 * 6, 7} 함수 1회 실행 = {0, 4, 1, 5, 2, 6, 3, 7} 함수 2회 실행 = {0, 2, 4, 6, 1, 3,
	 * 5, 7}
	 */

	// }

	// public String toString() {

	// }
	/*
	 * 리스트에 있는 값을 수로 표현하는것 ex) 1 -> 2 -> 3 -> 4 -> 5의 리스트 구성시 12345 출력
	 */
	public BigInt(int n) {
		if (n < 0)
			throw new IllegalArgumentException(n + "<0");
		Node start = new Node(n % 10);
		Node p = start;
		n /= 10;
		while (n > 0) {
			p = p._next = new Node(n % 10);
			n /= 10;
		}
	}

	public BigInt(String n) {

		if (n.length() == 0)
			throw new IllegalArgumentException("empty string");
		Node start = new Node(digit(n, n.length() - 1));
		Node p = start;
		for (int i = n.length() - 2; i >= 0; i--) {
			p = p.next();
		    p.setNext(new Node(digit(n, i)));
		}
	}

	public BigInt plus(BigInt y) {

		Node p = getHead();
		Node q = y.getHead();
		int n = p.digit + q.digit;
		BigInt z = new BigInt(n % 10);
		Node r = z.getHead();
		p = p.next();
		q = q.next();

		while (p != null && q != null) {
			n = n / 10 + p.digit + q.digit;
			r.setNext(new Node(n % 10));
			p = p.next();
			q = q.next();
			r = r.next();
		}

		while (p != null) {
			n = n / 10 + p.digit;
			r.setNext(new Node(n % 10));
			p = p.next();
			r = r.next();
		}

		while (q != null) {
			n = n / 10 + q.digit;
			r.setNext(new Node(n % 10));
			q = q.next();
			r = r.next();
		}
		if (n > 9)
			r.setNext(new Node(n/10));
		return z;
		

	}

	private int digit(String s, int i) {
		String ss = s.substring(i, i + 1);
		return Integer.parseInt(ss);
	}
	/*
	 * String 타입의 값을 바탕으로 리스트를 생성하는 생성자 작성 ex) BigInt x = new BigInt(“1234567”);
	 */

	/*
	 * 큰 정수를 더하는 메소드 두 개의 BigInt 객체를 더해서 새로운 BigInt 를 생성한다
	 */
	public BigInt minus(BigInt y) {
		
		
		return y;
	}
	/*
	 * 큰 정수를 빼는 메소드 두 개의 BigInt 객체를 빼서 새로운 BigInt 를 생성한다
	 */
	/*
	 * Boolean equals(BigInt y) { return false; }
	 */

	/*
	 * 두 개의 정수를 비교하는 메소드 두 개의 BigInt가 완전히 동일할 경우 True, 아닐 경우 False
	 */
	/*
	 * int intValue() { return 0; }
	 */
	/*
	 * BigInt로 구성되어 있는 값을 int 타입으로 반환한다 값이 int 타입에서 받을 수 있는 최대값으로 제한한다
	 */
	/*
	 * int numdigits() { return 0; }
	 */
	/*
	 * 자리 수를 반환한다
	 */

	/*
	 * BigInt times (int n) { return BigInt(n); } 두 BigInt를 곱하는 함수를 작성하라
	 */

}
