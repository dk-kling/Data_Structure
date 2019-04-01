package Stack;

import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {

	private Node<T> _top;
	private int _size;

	private Node<T> getTop() {
		return _top;
	}

	private void setTop(Node<T> top) {
		this._top = top;
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

		private T element() {
			return _element;
		}

		private void setElement(T element) {
			this._element = element;
		}

		private Node<T> next() {
			return _next;
		}

		private void setNext(Node<T> next) {
			this._next = next;
		}

		/*
		 * public Node(T element) { this.setElement(element);
		 * this.setNext(null); }
		 */

		private Node(T element, Node<T> next) {
			this.setElement(element);
			this.setNext(next);
		}
	}

	public LinkedStack() {
		this.setTop(null);
		this.setSize(0);

	}

	public boolean isEmpty() {
		return (getSize() == 0);
	}

	public T peek() {
		if (getSize() == 0) // 없을 때 예외처리
			throw new NoSuchElementException();
		return getTop().element(); // 있을 때 Top값 peek
	}

	public T pop() {
		if (getSize() == 0) // 없을 때 예외처리
			throw new NoSuchElementException();
		else {
			T object = getTop().element(); // Top값 저장
			setTop(getTop().next());
			setSize(getSize() - 1); // size down
			return object; // 리턴값 리턴
		}
	}

	public void push(T element) {

		Node<T> newNode = new Node<T>(element, this.getTop());
		setTop(newNode);
		setSize(getSize() + 1);
	}

	public int size() {
		return getSize();
	}
}
