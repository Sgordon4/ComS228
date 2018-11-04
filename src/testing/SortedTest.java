package testing;

import java.util.Vector;

import edu.iastate.cs228.hw08.SortedVectorDictionary;;

public class SortedTest {
	public static void main(String[] args) {
		SortedVectorDictionary<Integer, String> dict = new SortedVectorDictionary<Integer, String>();
		
		Vector<String> vect = new Vector<String>(); 
		
		vect.add(0, "E");
		System.out.println(vect.toString());
		
		dict.add(1, "Hello");
		dict.add(3, "world");
		dict.add(4, "!");
		dict.add(2, " ");
		
		
		System.out.println(dict.toString());
	}
	
}
