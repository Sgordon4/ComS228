package testing;

import edu.iastate.cs228.hw08.LinkedDictionary;

public class LinkedTest {
	public static void main(String[] args) {
		LinkedDictionary<Integer, String> dict = new LinkedDictionary<Integer, String>();
		
		dict.add(1, "Hello");
		dict.add(2, "world");
		
		System.out.println(dict.toString());
	}
}
