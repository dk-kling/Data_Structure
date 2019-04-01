package week_03;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 9;
		MagicSquare magicSquare = new MagicSquare(a);
        magicSquare.make();
        magicSquare.print();
        
        for (int i = 0; i < a; i++) {
        	System.out.println(magicSquare.sumColumn(i));
        	System.out.println(magicSquare.sumRow(i));
        	System.out.println(magicSquare.sumDiagonal());
        }
	}
}
