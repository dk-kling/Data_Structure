package Bag;

public class ArrayBag implements Bag {

	private Object[] array;
	private int size;
	private int index;
	public final int capacity = 1000;
	private int finderInt;

	public Object[] getArray() {
		return array;
	}

	public void setArray(Object[] objects) {
		this.array = objects;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getFinderInt() {
		return finderInt;
	}

	public void setFinderInt(int finderInt) {
		this.finderInt = finderInt;
	}

	public ArrayBag() {
		this.setIndex(0);
		this.setArray(new Object[this.capacity]);
		this.setSize(0);
		this.setFinderInt(0);
	}

	@Override
	public boolean add(Object object) {
		// TODO Auto-generated method stub
		getArray()[getSize()] = object;
		setSize(getSize() + 1);
		return true;
	}

	@Override
	public boolean contains(Object object) {
		for (int i = 0; i < getSize(); i++) {
			if (object == array[i]) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		setIndex(0);
		return getArray()[0];
	}

	@Override
	public Object getNext() {
		// TODO Auto-generated method stub
		setIndex(getIndex() + 1);
		return getArray()[getIndex()];
	}

	@Override
	public boolean remove(Object object) {
		// TODO Auto-generated method stub
		if (contains(object)) {
			for (int i = 0; i < getSize(); i++) {
				if (object == getArray()[i]) {
					setFinderInt(i);
					break;
				}
			}
			for (int i = this.getFinderInt(); i < getSize(); i++) {
				getArray()[i] = getArray()[i + 1];
			}
			setSize(getSize() - 1);
			setFinderInt(0);
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return getSize();
	}

}
