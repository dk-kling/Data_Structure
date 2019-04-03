package LinkedList_Node;

public class Node implements NodeInterface {
    /** 필드 선언 **/
    private int number;
    private Node next;
    private Node prev;
    /** NodeInterface의 메소드 구현(Getter&Setter) **/
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Node getPrev() {
        return prev;
    }

    @Override
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }
    /** 생성자 생성 **/
    public Node(int num, Node prevNode, Node nextNode) {        /** Node의 number와 prev, next Node가 주어질 때 **/
        this.setNumber(num);                                    /** 값을 주어진 값으로 초기화 **/
        this.setNext(nextNode);
        this.setPrev(prevNode);
    }

    public Node() {                 /** 주어진 값이 없는 경우 **/
        this.setNumber(0);          /** Node의 number를 0으로 초기화 **/
        this.setNext(null);         /** prev, next Node는 null로 초기화 **/
        this.setPrev(null);
    }

}