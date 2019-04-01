package Queue;

public class LinkedQueue<T> implements Queue<T> {

	private Node<T> _front;
	private Node<T> _rear;
	private int _size;

	private Node<T> getFront() {
		return _front;
	}

	private void setFront(Node<T> front) {
		this._front = front;
	}

	private Node<T> getRear() {
		return _rear;
	}

	private void setRear(Node<T> rear) {
		this._rear = rear;
	}

	private int getSize() {
		return _size;
	}

	private void setSize(int size) {
		this._size = size;
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

		public Node(T element, Node<T> next) {
			this.setElement(element);
			this.setNext(next);
		}

	}

	public boolean isEmpty() {
		return (getSize() == 0); // 비어있으면 true
	}

	@Override
	public boolean add(T object) {
		if (isEmpty()) { // 아무것도 없을 때 추가하고 front, Rear값으로
			setFront(new Node<T>(object, null));
			setRear(getFront());
		}

		else { // 있을 때 Rear.next에 추가하고 rear로 바꿔줘
			Node<T> temp = new Node<T>(object, null);
			getRear().setNext(temp);
			setRear(temp);
		}
		setSize(getSize() + 1); // size up
		return true;
	}

	@Override
	public T remove() {
		if (isEmpty()) { // 비어 있을 때 삭제 못하니까 예외처리
			throw new IllegalStateException("the queueis empty");
		} else {
			T temp = getFront().element(); // front temp에 자장하고
			setFront(getFront().next()); // front.next를 front로 바꾼다음
			setSize(getSize() - 1); // size down하고
			return temp; // temp리턴해
		}
	}

	@Override
	public int size() {
		return getSize(); // size 가져와
	}

	@Override
	public T poll() {
		if (isEmpty()) // 비어있으면 null 리턴해
			return null;
		else { // 존재 할 경우에는 front의 element를 temp에 저장하고
			T temp = getFront().element();
			setFront(getFront().next()); // front.next를 front로 바꾼다음
			setSize(getSize() - 1); // size down하고
			return temp; // temp리턴해
		}
	}

	@Override
	public T peek() {
		if (getSize() == 0) // 없으면 예외처리
			throw new IllegalStateException("the queueis empty");
		else
			return getFront().element(); // 있으면 front값 리턴
	}

	@Override
	public boolean contains(T element) {

		for (Node<T> p = getFront(); p != null; p = p.next()) { // 있으면 true
			if (p.element() == element)

				return true;
		}
		return false; // 없으면 false
	}

	@Override
	public boolean remove(T element) {

		if (contains(element)) { // 있는 경우

			if (getFront().element() == element) { // front면 front 바꿔줘
				setFront(getFront().next());
				setSize(getSize() - 1); // size를 1 빼줘
				return true; // true 리턴해
			}

			else { // front아니면 찾아야돼
				for (Node<T> p = getFront(); p != null; p = p.next()) {
					if (p.next().element() == element) { // 찾으면
						p.setNext(p.next().next()); // 전꺼 next 바꿔 garbage로 없어지겠지
						setSize(getSize() - 1); // size 1 빼
						if (p.next() == null) { // next가 null이면
							setRear(p); // rear 최신화해
							return true;
						}
					}
				}
				return true;
			}
		}
		else{
			return false;
			// 없는 경우 false
		}
	}

	@Override
	public void clear() { // 초기화
		setFront(null);
		setRear(null);
		setSize(0);
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public String print() {
		StringBuilder result = new StringBuilder();

		if (isEmpty()) // Queue가 비어 있는 경우 예외처리
			return "Queue is empty...";

		else {// Queue에 데이터가 있을 때
			for (Node<T> temp = getFront(); temp != null; temp = temp.next()) {
				result.append(temp.element()); // for문 돌려서 저장
			}
		}
		return result.toString();
	}

	public String reversePrint() {
		StringBuilder result = new StringBuilder();
		Node<T> tempNode = this.getFront();
		reverse(tempNode, result);
		return result.toString();
	}

	private String reverse(Node<T> temp, StringBuilder result) {
		
		if (isEmpty()) // Queue가 비어 있는 경우 예외처리
			return "Queue is empty...";
		
		else { // Queue에 데이터가 있을 때
			if (temp != null) {
				reverse(temp.next(), result);
				result.append(temp.element());
			}
			return result.toString();
		}
	}

}
