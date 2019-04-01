package Bag;

import Bag.ArrayBag;
import Bag.Bag;
import Bag.TestArrayBag;

public class TestArrayBag {
	public TestArrayBag() {
		Bag Bag = new ArrayBag();
		System.out.println("Bag.add(\"CA\"):\t" + Bag.add("CA"));
		System.out.println("Bag.add(\"US\"):\t" + Bag.add("US"));
		System.out.println("Bag.add(\"MX\"):\t" + Bag.add("MX"));
		System.out.println("Bag.add(\"CA\"):\t" + Bag.add("CA"));
		System.out.println("Bag.add(\"US\"):\t" + Bag.add("US"));
		System.out.println("Bag.size():\t" + Bag.size());
		print(Bag);
		System.out.println("Bag.contains(\"CA\"):\t" + Bag.contains("CA"));
		System.out.println("Bag.remove(\"CA\"):\t" + Bag.remove("CA"));
		System.out.println("Bag.size(): " + Bag.size());
		print(Bag);
		System.out.println("Bag.contains(\"CA\"):\t" + Bag.contains("CA"));
		System.out.println("Bag.remove(\"CA\"):\t" + Bag.remove("CA"));
		System.out.println("Bag.size(): " + Bag.size());
		print(Bag);
		System.out.println("Bag.contains(\"MX\"):\t" + Bag.contains("MX"));
		System.out.println("Bag.contains(\"AR\"):\t" + Bag.contains("AR"));
	}

	public void print(Bag Bag) {
		System.out.print(Bag.getFirst());
		for (int i = 1; i < Bag.size(); i++)
			System.out.print(", " + Bag.getNext());
		System.out.println();
	}

	public static void main(String[] args) {
		new TestArrayBag();
	}
}
