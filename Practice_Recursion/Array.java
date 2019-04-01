package Practice_Recursion;

import java.util.Random;

public class Array {

	private int[] array;
	Random random = new Random();
	private int index = 0;

	private int[] getArray() {
		return array;
	}

	private void setArray(int[] array) {
		this.array = array;
	}

	private int getSize() {
		return getArray().length;
	}

	public Array(int a) {
		setArray(new int[a]);
		for (int i = 0; i < a; i++)
			array[i] = random.nextInt(20);
	}

	public void PrintArray() {
		if (index < getSize()) {
			System.out.print(getArray()[index] + "\t");
			index++;
			if (index == getSize())
				System.out.println();
			PrintArray();
		}
		index = 0;
	}

	public void ReversePrintArray(int num) {
		if (num < getSize()) {
			ReversePrintArray(num + 1);
			System.out.print(getArray()[num] + "\t");
		}
		if (num == 0) {
			System.out.println();
			index = 0;
		}
	}

}
