package Map;

public class Entry {

	private String key; //key값
    private int value; 
    //key값의 개수를 나타내주는 변수

    //편의를 위한 Setter
    public void setKey(String key) {
    	this.key = key;
    }
    
    private void setValue(int value) {
    	this.value = value;
    } 

    //key값을 넣고 Value를 1로 만들어주는 생성자
    public Entry(String key) {
    	setKey(key);
    	setValue(1);
    }

    //Value를 1 더해주는 함수
    public void addValue() {
    	setValue(getValue() + 1);
    }

    //편의를 위한 Getter
    public String getKey() {
    	return key;
    }

    public int getValue() {
    	return value;
    }
}
