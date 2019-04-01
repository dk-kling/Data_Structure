package Queue;

public class ArrayQueue<T> implements Queue<T> {
	
	private T[ ] _array;
	private int _front;
	private int _rear;
	private int _capacity;
	private int _size;
	
	private int getSize() {
		return _size;
	}
	
	private void setSize(int _size) {
		this._size = _size;
	}
	
	private int getCapacity() {
		return _capacity;
	}
	
	private void setCapacity(int capacity) {
		this._capacity = capacity;
	}
	
	private T[] getArray() {
		return _array;
	}
	
	private void setArray(T[] array) {
		this._array = array;
	}
	
	private int getFront() {
		return _front;
	}
	
	private void setFront(int front) {
		this._front = front % getCapacity();
	}
	
	private int getRear() {
		return _rear;
	}
	
	private void setRear(int rear) {
		this._rear = rear % getCapacity();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		 this.setArray((T[]) new Object[capacity]);
		 this.setFront(0);
		 this.setRear(0);
		 this.setSize(0);
		 this.setCapacity(capacity);
	}
	
	public boolean isEmpty() {
		return (getFront() == getRear());
	}
	
	@Override
	public int size() {
		return getSize();
	}
	
	@Override
	public boolean add(T object) {
		if(isFull()){
			return false; //꽉차있으면 false
		}
		else { //아니면
			getArray()[getRear()+1] = object; // rear다음 배열에 object 추가
			setRear(getRear()+1); //rear+1해줘
			setSize(getSize()+1); //size+1해줘
			return true;
		}
	}
	
	@Override
	public T poll() {
		if (isEmpty())
			return null; //비어있을 때 null리턴해
		else {
			T result = getArray()[getFront()+1]; //첫번째 값 저장해
			getArray()[getFront()+1] = null; //없애
			setFront(getFront()+1);
			setSize(getSize()-1);
			return result;
		}
	}
	
	@Override
	public T peek() {
		if (isEmpty()) // 없으면 예외처리
			throw new IllegalStateException("the queueis empty");
		else
			return getArray()[getFront()+1]; // 있으면 첫 번째 값 리턴
	}
	
	@Override
	public T remove() {
		if (isEmpty())
			throw new IllegalStateException("the queueis empty");
		else {
			T result = getArray()[getFront()+1]; //첫번째 값 저장해
			getArray()[getFront()+1] = null; //없애
			setFront(getFront()+1);
			setSize(getSize()-1);
			return result;
		}
	}
	
	@Override
	public boolean contains(T element) {
		for (int i = 0; i != getCapacity(); i++) { // 있으면 true
			if (getArray()[i] == element)
				return true;
		}
		return false; // 없으면 false
	}
	
	@Override
	public boolean remove(T element) {
		if (contains(element)) { // 있는 경우
			if (getArray()[getFront()+1] == element) { // front면 front 바꿔줘
				getArray()[getFront()+1] = null; //없애
				setFront(getFront()+1);
				setSize(getSize()-1);
				return true; // true 리턴해
			}
			else if (getArray()[getRear()] == element) {
				getArray()[getRear()] = null; //없애
				setRear(getRear()-1);
				setSize(getSize()-1);
				return true;
			}
			else { // front아니면 찾아야돼
				for (int i = 0; i != getCapacity(); i++) {
					if (getArray()[i] == element) { // 찾으면
					getArray()[i] = null;
					setSize(getSize()-1);
					for (int j = (i+1) % getCapacity(); i != j; j = ((j+1) % getCapacity())) {
						getArray()[j-1] = getArray()[j];
				    	}
					}
				}
				return true;
			}
		}
		else // 없는 경우 false
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		this.setArray((T[]) new Object[0]);
		 this.setFront(0);
		 this.setRear(0);
		 this.setSize(0);
		 this.setCapacity(0);
		
	}
	
	@Override
	public boolean isFull() {
		return (getSize() == (getCapacity()-1));
	}
	
	@Override
	public String print() {
		StringBuilder result = new StringBuilder();
		if (isEmpty()) // Queue가 비어 있는 경우 예외처리
			return "Queue is empty...";
		else {// Queue에 데이터가 있을 때
			for (int i = 0; i != getCapacity(); i++) {
				result.append(getArray()[i]); // for문 돌려서 저장
			}
		}
		return result.toString();
	}
	
	@Override
	public String reversePrint() {
		int i = 0;
		StringBuilder result = new StringBuilder();
		reverse(i, result);
		return result.toString();
	}

	private String reverse(int i, StringBuilder result) {
		
		if (isEmpty()) // Queue가 비어 있는 경우 예외처리
			return "Queue is empty...";
		
		else { // Queue에 데이터가 있을 때
			if (i != getCapacity()) {
				reverse(i+1, result);
				result.append(getArray()[i]);
			}
			return result.toString();
		}
	}
}
