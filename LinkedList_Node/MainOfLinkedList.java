package LinkedList_Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static LinkedList_Node.ManageIO.PrintFinal;
/** 주어진 Test 소스코드를 응용해서 만든 main 메소드 **/
public class MainOfLinkedList {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        LinkedList firstList = new LinkedList();
        LinkedList secondList = new LinkedList();
        LinkedList number[] = {firstList, secondList};
        String lines[] = new String[2];

        FileReader fileReader = new FileReader("C:\\Users\\DEOKK\\Desktop\\GitHub\\Data_Structure\\src\\LinkedList_Node\\test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = "";
        for (int i = 0; (line = bufferedReader.readLine()) != null; i++) {
            number[i] = new LinkedList();
            lines[i] = line;
            for (int j = 0; j < line.length(); j++) {
                number[i].insert(number[i].tail, line.charAt(j) - '0');
            }
        }
        LinkedList result = number[0].add(number[1]);   /** 덧셈 **/
        PrintFinal(number[0], number[1], result);       /** 프린트 **/
    }
}
