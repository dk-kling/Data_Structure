package RPN;
/*
import java.util.LinkedList;
import java.util.Queue;
import week_04.ArrayStack;

public class PostFix {
	
	public String input = null;		// 입력 문자열
	public ArrayStack<String> stack = null;		// 스택
	public String output = null;	// 출력 문자열 (postfix)
	
    private int setThePriority(String str) { // 기호들의 연산 우선 순위 정하는 것
        int priority = 0;
        switch (str) {
        case "+":
        case "-":
           priority = 1;
           break;
        case "*":
        case "/":
           priority = 2;
           break;
        default:
           priority = -1;
           break;
        }
        return priority;
     }

   private String[] makeTheToken(String input) {
      Queue<Character> queue = new LinkedList<Character>();
      char[] str = input.toCharArray();
      int indexOfString = 0;
      String[] strQueue = new String[str.length];
      StringBuffer forQue = new StringBuffer();

      for (int index = 0; index < str.length; index++) {
         switch (str[index]) {
         case '/':
         case '*':
         case '+':
         case '-':
         case '(':
         case ')':
            while (!queue.isEmpty()) {
               forQue.append(Character.toString(queue.remove()));
            }
            if (!forQue.toString().equals("")) {
               strQueue[indexOfString++] = forQue.toString();// 배열 추가
               forQue = new StringBuffer();// 다시 버퍼 초기화
            }
            strQueue[indexOfString++] = Character.toString(str[index]);// 연산문 추가
            break;
         case ' ':
            continue;
         default:
            queue.add(str[index]);
         }
      }
      while (!queue.isEmpty()) {// 마지막 부분처리
         forQue.append(Character.toString(queue.remove()));
      }
      if (str.length > indexOfString && !forQue.toString().equals("")) {
         strQueue[indexOfString++] = forQue.toString();
      }
      String[] returnArray = new String[indexOfString];
      System.arraycopy(strQueue, 0, returnArray, 0, indexOfString);
      return returnArray;
   }

}*/
