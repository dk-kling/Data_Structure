package Map;

public class ArrayMap implements Map {

	private static final int LENGTH = 10;
	//초기 Entry[]의 크기를 지정해주는 상수
	private int size;
	//entry가 가진 배열 수를 나타내는 변수
	private Entry[] entry = new Entry[LENGTH];
	//Entry를 가지는 배열 entry를 만들어줌
	
	//편의를 위해 만든 Getter/Setter
	private int getSize() {
		return size;
	}
	
	private void setSize(int size) {
		this.size = size;
	}
	
	private Entry[] getEntry() {
		return entry;
	}
	
	private void setEntry(Entry[] entry) {
		this.entry = entry;
	}

	@Override
	public int getValue(String key) {
		//주어진 key값의 Value값을 return하는 함수
		//entry[]를 처음부터 끝까지 색인하고
		for (int tempInt = 0; tempInt < getSize(); tempInt++) {
			//key값과 같은 key 값을 가진 Entry의 Value값 return
			if (getEntry()[tempInt].getKey().equals(key)) {
				return getEntry()[tempInt].getValue();
			}
		}
		//일치하는 key값이 없을 때 0 return
		return 0;
	}

	@Override
	public void put(String key) {
		//주어진 key를 entry에 저장하는 함수
		//entry[]를 처음부터 끝까지 색인하고
		for (int tempInt = 0; tempInt < getSize(); tempInt++) {
			//입력받은 key값이 entry의 key값과 같을 때 Value + 1하고 return
			if (getEntry()[tempInt].getKey().equals(key)) {
				getEntry()[tempInt].addValue();
				return;
			}
		}
		//입력받은 key값이 entry의 key값과 같은 경우가 없을 때
		//size와 entry의 길이가 같으면 resize를 해줌
		if (getSize() == getEntry().length)
			resize();
		//또 새로운 key값을 마지막 index에 추가하고 size++, return
		getEntry()[getSize()] = new Entry(key);
		setSize(getSize() + 1);
			return;
		}

	@Override
	public void print() {
		//index를 모두 색인하고 key와 value를 출력하는 함수
		for (int tempInt = 0; tempInt < getSize(); tempInt++)
			System.out.println(getEntry()[tempInt].getKey() + ", " + getEntry()[tempInt].getValue());
	}

	private void resize() {
		//2배 크기의 배열을 만들어 entry의 크기를 새로 세팅해주는 함수
		Entry[] tempEntry = new Entry[2 * getEntry().length];
		System.arraycopy(getEntry(), 0, tempEntry, 0, getEntry().length);
		setEntry(tempEntry);
	}

	/*
	 * private boolean find(String key) { for (int tempInt = 0; tempInt <
	 * getSize(); tempInt++) { if (getEntry()[tempInt].getKey() == key) { return
	 * true; } } return false; }
	 */

}
