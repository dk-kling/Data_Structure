package Map;

public interface Map {
	//인터페이스로 Map을 선언
	
    public int getValue(String key);
    //해당되는 key의 Value값을 리턴하는 함수
    public void put(String key);
    //주어진 key값을 가진 Entry를 만들어주는 함수
    public void print();
    //Map을 출력하는 함수
    
}
