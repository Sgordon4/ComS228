package Testing;

import edu.iastate.cs228.hw05.LinkedPriorityQueue;

public class LinkedPriorityQueueTest {
	public static void main(String[] args) {
		LinkedPriorityQueue<Integer> oOf = new LinkedPriorityQueue<Integer>();
		
		//	Testing empty and null cases  \\
				
		System.out.println("Testing empty and null cases:");
		System.out.println(oOf.toString());
		System.out.println("isEmpty: " + oOf.isEmpty());
		System.out.println("peek: " + oOf.peek());
		System.out.println("remove: " + oOf.remove());
		System.out.println();
		
		//	Testing adding	\\
		
		System.out.println("Testing adding:");
		oOf.add(new Integer(14));
		oOf.add(new Integer(2));
		oOf.add(new Integer(17));
		oOf.add(new Integer(39));
		oOf.add(new Integer(7));
		
		System.out.println(oOf.toString());
		System.out.println("peek: " + oOf.peek());
		System.out.println("isEmpty: " + oOf.isEmpty());
		System.out.println();
		
		oOf.clear();
		
		//	Testing removing  \\
		
		System.out.println("Testing removing:");
		oOf.add(new Integer(14));
		oOf.add(new Integer(2));
		oOf.add(new Integer(17));
		oOf.add(new Integer(39));
		oOf.add(new Integer(7));
		
		System.out.println(oOf.toString());
		System.out.println("remove: " + oOf.remove());
		System.out.println("isEmpty: " + oOf.isEmpty());
		System.out.println("remove: " + oOf.remove());
		
		System.out.println("Adding 23 and 6");
		oOf.add(new Integer(23));
		oOf.add(new Integer(6));
		System.out.println(oOf.toString());
		
		System.out.println("remove: " + oOf.remove());
		System.out.println("remove: " + oOf.remove());
		System.out.println("remove: " + oOf.remove());
		
	}
}
