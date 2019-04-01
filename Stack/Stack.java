package Stack;

public interface Stack<T> {
	
	public T peek();
	
	public T pop();
	
	public void push(T object);
	
	public int size();

}
