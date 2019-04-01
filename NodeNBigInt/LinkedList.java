package NodeNBigInt;

public class LinkedList {

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

	public LinkedList() {
		this.reset();
	}

	public boolean isEmpty() {
		if (getSize() == 0)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		return false;
	}

	public boolean add(Object anElement) {

		if (isEmpty()) {
			Node newNode = new Node(anElement);

			newNode.setNext(getHead());
			setHead(newNode);

			// head == last
			if (getHead().next() == null)
				setLast(getHead());
		} else {
			Node newNode = new Node(anElement);

			getLast().setNext(newNode);

			// newNode == last
			if (newNode.next() == null)
				setLast(newNode);
		}
		// size up
		setSize(getSize() + 1);

		return true;
	}

	public boolean addLast(Object anElement) {

		Node newNode = new Node(anElement);

		if (getSize() == 0) {
			add(anElement);
		}

		else {

			getLast().setNext(newNode);
			setLast(newNode);
			setSize(getSize() + 1);
		}

		return true;
	}

	public Object remove() {
		// head를 제거 하고 제거된 element를 return 해준다.
		Object toReturn = getHead().element();
		Node tempNode = new Node(getHead().next().element(), getHead().next().next());
		setHead(tempNode);
		tempNode = null;
		// size를 1을 빼준다.
		setSize(getSize() - 1);

		return toReturn;
	}

	public boolean removeAny(Object anElement) {
		// anElement가 존재 하는지 판별 해서 존재 할 경우
		if (getHead().element() == anElement) {
			Node tempNode = new Node(getHead().next().element(), getHead().next().next());
			setHead(tempNode);
			tempNode = null;
			// size를 1을 빼준다.
			setSize(getSize() - 1);
			return true;
		}

		else {
			for (Node p = getHead(); p != null; p = p.next()) {
				if (p.next().element() == anElement) {
					p.setNext(p.next().next());
					setSize(getSize() - 1);
					if (p.next() == null) {
						setLast(p);
					}
					return true;
				}
			}
		}
		return false;
	}

	public void reset() {
		this.setHead(null);
		this.setLast(null);
		this.setSize(0);
	}

	public String toString() {
		// 모든 원소 출력
		return null;
	}

	private static class Node {

		private Object _element;
		private Node _next;

		public Object element() {
			return _element;
		}

		public void setElement(Object element) {
			this._element = element;
		}

		public Node next() {
			return _next;
		}

		public void setNext(Node next) {
			this._next = next;
		}

		public Node(Object element) {
			this.setElement(element);
			this.setNext(null);
		}

		public Node(Object element, Node next) {
			this.setElement(element);
			this.setNext(next);
		}

	}

}
