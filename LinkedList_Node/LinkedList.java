package LinkedList_Node;

public class LinkedList implements LinkedListInterface {
    /** 필드 선언 **/
    public Node head;
    public Node tail;
    /** Getter&Setter 구현 **/
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    /** 생성자 생성 **/
    public LinkedList() {
        setHead(new Node(0, null, getTail()));
        setTail(new Node(0, getHead(), null));
    }
    /** target 앞에 node 삽입하는 메소드 **/
    @Override
    public void insert(Node target, int number) {
        Node prev = target.getPrev();                   /** target의 prev를 prev라는 Node에 저장 **/
        Node next = target;                             /** target을 next라는 Node에 저장 **/
        Node newNode = new Node(number, prev, next);    /** number를 가지는 Node newNode를 생성자로 선언**/

        prev.setNext(newNode);          /** prev의 next를 newNode로 저장 **/
        next.setPrev(newNode);          /** next의 prev를 newNode로 저장 **/
    }
    /** 두 개의 LinkedList의 값을 더해 새로운 LinkedList를 만드는 메소드 **/
    @Override
    public LinkedList add(LinkedList smallNumber) {         /** 현재 LinkedList에 smallNumber를 덧셈**/
        Node smallNode = smallNumber.getTail().getPrev();   /** smallNumber의 tail의 prev Node를 smallNode로 선언 **/

        LinkedList resultint = new LinkedList();                /** 결과값을 저장해줄 LinkedList resultint를 생성 **/
        resultint.insert(resultint.getTail(), 0);       /** 맨처음 head, tail을 제외한 Node를 하나 insert **/
        Node resultNode = resultint.getTail().getPrev();        /** 처음 result를 탐색할 resultNode를 tail의 prev로 지정 **/
        /** 클래스의 LinkedList(더 큰 수)를 탐색하는 bigNode를 선언하고, prev해주며 head가 나올 때까지 색인을 위한 반복 **/
        for (Node bigNode = getTail().getPrev(); bigNode != getHead(); bigNode = bigNode.getPrev()) {
            int sum = bigNode.getNumber() + smallNode.getNumber();      /** int sum을 선언해 bigNode와 smallNode의 number를 더한 값을 저장 **/
            if (resultNode.getPrev() == resultint.getHead())            /** resultNode의 prev가 head라면 **/
                resultint.insert(resultNode, 0);                /** 밑에서 null을 참조하게 되기 때문에 insert로 Node 생성 **/

            resultNode.setNumber(resultNode.getNumber() + (sum % 10));                      /** sum값을 10으로 나눈 나머지와 resultNode에 있는 number를 더해서 저장 **/
            resultNode.getPrev().setNumber(resultNode.getPrev().getNumber() + (sum / 10));  /** 올림수가 sum / 10이므로 이를 prev에 더해서 prev에 저장 **/

            if (smallNode != smallNumber.getHead())     /** smallNode가 head가 아니면 smallNode의 자리수를 옮겨야 하므로 **/
                smallNode = smallNode.getPrev();        /** prev로 변경 / head라면 smallNode의 연산이 끝났으므로 number가 0인 head값 유지 **/
            if (bigNode.getPrev() != getHead())         /** bigNode가 head가 아니면 연산이 끝나지 않았으므로 **/
                resultNode = resultNode.getPrev();      /** prev로 변경 **/
        }
        if (resultint.getHead().getNext().getNumber() == 0) {                       /** 앞의 코드에서 head의 next에 올림수가 있을 수 있기 때문에 Node를 만들어줬었지만 **/
            resultint.getHead().setNext(resultint.getHead().getNext().getNext());   /** 그 수가 0이라면 필요 없는 수이므로 참조값을 바꿔서 삭제 / 참조해주는 Node가 없어 Garbage Collector가 자동 삭제 **/
        }
        return resultint;
    }
}