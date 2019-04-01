package Set;

//  Data Structures with Java
//  by John R. Hubbard and Anita Huray
//  Copyright 2004 by Prentice Hall
//  chap02\prob03\TestArraySet.java

public class TestArraySet {
	public TestArraySet() {
		Set set = new ArraySet();
		System.out.println("set.add(\"CA\"):\t" + set.add("CA"));
		System.out.println("set.add(\"US\"):\t" + set.add("US"));
		System.out.println("set.add(\"MX\"):\t" + set.add("MX"));
		System.out.println("set.add(\"CA\"):\t" + set.add("CA"));
		System.out.println("set.add(\"US\"):\t" + set.add("US"));
		System.out.println("set.size():\t" + set.size());
		print(set);
		System.out.println("set.contains(\"CA\"):\t" + set.contains("US"));
		System.out.println("set.remove(\"CA\"):\t" + set.remove("US"));
		System.out.println("set.size(): " + set.size());
		print(set);
		System.out.println("set.contains(\"CA\"):\t" + set.contains("CA"));
		System.out.println("set.remove(\"CA\"):\t" + set.remove("CA"));
		System.out.println("set.size(): " + set.size());
		print(set);
		System.out.println("set.contains(\"MX\"):\t" + set.contains("MX"));
		System.out.println("set.contains(\"AR\"):\t" + set.contains("AR"));
	}

	public void print(Set set) {
		System.out.print(set.getFirst());
		for (int i = 1; i < set.size(); i++)
			System.out.print(", " + set.getNext());
		System.out.println();
	}

	public static void main(String[] args) {
		new TestArraySet();
	}
}

/*
 * Output: set.add("CA"): true set.add("US"): true set.add("MX"): true
 * set.add("CA"): false set.add("US"): false set.size(): 3 CA, US, MX
 * set.contains("CA"): true set.remove("CA"): true set.size(): 2 US, MX
 * set.contains("CA"): false set.remove("CA"): false set.size(): 2 US, MX
 * set.contains("MX"): true set.contains("AR"): false
 */
