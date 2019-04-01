package ToGeneric;

public class LinkedList<T> {

	private Node<T> head;
	private Node<T> last;
	private int size;

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getLast() {
		return last;
	}

	public void setLast(Node<T> last) {
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

	public boolean add(T anElement) {

		if (isEmpty()) {
			Node<T> newNode = new Node<T>(anElement);

			newNode.setNext(getHead());
			setHead(newNode);

			// head == last
			if (getHead().next() == null)
				setLast(getHead());
		} else {
			Node<T> newNode = new Node<T>(anElement);

			getLast().setNext(newNode);

			// newNode == last
			if (newNode.next() == null)
				setLast(newNode);
		}
		// size up
		setSize(getSize() + 1);

		return true;
	}

	public boolean addLast(T anElement) {

		Node<T> newNode = new Node<T>(anElement);

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

	public T remove() {
		// head를 제거 하고 제거된 element를 return 해준다.
		T toReturn = getHead().element();
		Node<T> tempNode = new Node<T>(getHead().next().element(), getHead().next().next());
		setHead(tempNode);
		tempNode = null;
		// size를 1을 빼준다.
		setSize(getSize() - 1);

		return toReturn;
	}

	public boolean removeAny(T anElement) {
		// anElement가 존재 하는지 판별 해서 존재 할 경우
		if (getHead().element() == anElement) {
			Node<T> tempNode = new Node<T>(getHead().next().element(), getHead().next().next());
			setHead(tempNode);
			tempNode = null;
			// size를 1을 빼준다.
			setSize(getSize() - 1);
			return true;
		}

		else {
			for (Node<T> p = getHead(); p != null; p = p.next()) {
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

	private static class Node<T> {

		private T _element;
		private Node<T> _next;

		public T element() {
			return _element;
		}

		public void setElement(T element) {
			this._element = element;
		}

		public Node<T> next() {
			return _next;
		}

		public void setNext(Node<T> next) {
			this._next = next;
		}

		public Node(T element) {
			this.setElement(element);
			this.setNext(null);
		}

		public Node(T element, Node<T> next) {
			this.setElement(element);
			this.setNext(next);
		}

	}

}
