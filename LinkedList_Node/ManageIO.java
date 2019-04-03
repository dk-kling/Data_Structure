package LinkedList_Node;
/** LinkedList를 출력하는 메소드를 가진 class**/
public class ManageIO {
    /** LinkedList를 받고 그 내용을 출력하는 메소드**/
    public static void PrintList(LinkedList bigint) {
        for (Node p = bigint.getHead().getNext(); p != bigint.getTail(); p = p.getNext()) {
            System.out.print(p.getNumber());
        }
        System.out.println();
    }
    /** 주어진 실행화면과 같이 출력을 해주는 메소드(3개의 LinkedList를 입력받음) **/
    public static void PrintFinal(LinkedList firstint, LinkedList secondint, LinkedList resultint) {
        System.out.print("첫 번째 숫자 : ");
        PrintList(firstint);                /** 첫 번째 LinkedList를 출력 **/
        System.out.print("두 번째 숫자 : ");
        PrintList(secondint);               /** 두 번째 LinkedList를 출력 **/
        System.out.print("결과 : ");
        PrintList(resultint);               /** 세 번째 LinkedList를 출력 **/
    }
}
