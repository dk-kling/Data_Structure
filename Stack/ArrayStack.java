package Stack;

import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {

	private T[] _array;
	private int _size;
	private int _capacity;
	private int _top;
	private static final int DEFAULT_CAPACITY = 100;

	private T[] getArray() {
		return _array;
	}

	private void setArray(T[] array) {
		this._array = array;
	}

	private int getSize() {
		return _size;
	}

	private void setSize(int size) {
		this._size = size;
	}

	private int getCapacity() {
		return _capacity;
	}

	private void setCapacity(int _capacity) {
		this._capacity = _capacity;
	}

	private int getTop() {
		return _top;
	}

	private void setTop(int _top) {
		this._top = _top;
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int newCapacity) {

		this.setTop(-1);
		this.setCapacity(newCapacity);
		this.setArray((T[]) new Object[newCapacity]);
		this.setSize(0);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack() {

		this.setCapacity(ArrayStack.DEFAULT_CAPACITY);
		this.setTop(-1);
		this.setArray((T[]) new Object[this.getCapacity()]);
		this.setSize(0);
	}

	public boolean isEmpty() {

		return (getSize() == 0);
	}

	public boolean isFull() {

		return getSize() == getArray().length;
	}

	public T peek() {
		if (getSize() == 0)
			throw new NoSuchElementException();
		return getArray()[getTop()];
	}

	public T pop() {
		if (isEmpty())
			throw new NoSuchElementException();
		T object = getArray()[getTop()];
		getArray()[getSize()] = null;
		setSize(getTop());
		setTop(getTop() - 1);
		return object;
	}

	public void push(T object) {
		if (isFull()) {
			resize();
		}
		getArray()[getSize()] = object;
		setSize(getSize() + 1);
		setTop(getTop() + 1);
	}

	public int size() {
		return getSize();
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		Object[] aa = getArray();
		setArray((T[]) new Object[2 * aa.length]);
		System.arraycopy(aa, 0, getArray(), 0, _size);
	}

}
