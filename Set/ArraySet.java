package Set;

public class ArraySet implements Set {

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

	public ArraySet() {
		this.setIndex(0);
		this.setArray(new Object[this.capacity]);
		this.setSize(0);
		this.setFinderInt(0);
	}

	public boolean contains(Object object) {
		for (int i = 0; i < getSize(); i++) {
			if (object == getArray()[i]) {
				return true;
			}
		}
		return false;
	}

	public boolean add(Object object) {
		if (!contains(object)) {
			getArray()[getSize()] = object;
			setSize(getSize() + 1);
			return true;
		} else
			return false;
	}

	public boolean remove(Object object) {

		if (contains(object)) {
			for (int i = 0; i < getSize(); i++) {
				if (object == getArray()[i]) {
					setFinderInt(i);
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

	public int size() {
		return getSize();
	}

	public Object getFirst() {
		setIndex(0);
		return getArray()[0];
	}

	public Object getNext() {
		setIndex(getIndex() + 1);
		return getArray()[getIndex()];
	}

}
