package Queue;

public interface Queue<T> {

	public boolean add(T object);
	// 추가

	public T poll();
	// 아무것도 없을 경우 null을 return 하고 element가 한개라도 존재 할 경우에는 front의 element를 temp에
	// 저장하고
	// front를 제거한다 그리고 temp를 return 한다.

	public T peek();
	// font의 element를 return 한다.

	public T remove();
	// 아무것도 없을 경우

	public int size();
	// 안엥있는 데이터 개수를 return

	public boolean isEmpty();
	// 배열이나 list가 비어있는지 확인하고 return

	public boolean contains(T element);
	// T라는 data를 가지고 있는지 아닌지를 판별하고 있으면 true 없으면 false로 return 한다.

	public boolean remove(T element);
	// element가 존재할 경우 그 데이터를 제거하고 다시 배열과 list를 정렬 해 준다. 그리고 return true 해 준다 없을
	// 경우
	// false를 리턴한다

	public void clear();
	// 모든 배열과 list를 다시 처음 상태로 초기화 해 준다

	public boolean isFull();
	// list일 경우 에는 무조건 false를 리턴하고 array일 경우 데이터가 꼭차있는지 확인해 준다

	public String print(); // 모든 순서대로 element출력하기

	// public String reversePrint(Node<T> node);
	// 반대로 출력하기 -> 재귀로 짤것, 변형해도 상관없음

	public String reversePrint();

}
