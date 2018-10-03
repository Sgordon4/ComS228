package edu.iastate.cs228.hw04;

public class CircularDoublyLinkedTest {
	public static void main(String[] args) {
		CircularDoublyLinkedDeque<Integer> queue = new CircularDoublyLinkedDeque<Integer>();
		
		
		System.out.print("Expected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.print("Expected: null\nActual:   ");
		System.out.println(queue.getFront());
		System.out.print("Expected: null\nActual:   ");
		System.out.println(queue.getBack());
		
		System.out.print("Expected: null\nActual:   ");
		System.out.println(queue.removeFront());
		System.out.print("Expected: null\nActual:   ");
		System.out.println(queue.removeBack());
		
		queue.clear();				//Expected no errors
		
		queue.addToFront(17);
		queue.addToFront(27);		//Expected no errors
		queue.addToFront(37);
		
		System.out.print("Expected: 17\nActual:   ");
		System.out.println(queue.getFront());
		System.out.print("Expected: 37\nActual:   ");
		System.out.println(queue.getBack());
		
		System.out.print("Expected: 17\nActual:   ");
		System.out.println(queue.removeFront());
		System.out.print("Expected: 27\nActual:   ");
		System.out.println(queue.removeFront());
		
		System.out.print("Expected: false\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.print("Expected: 37\nActual:   ");
		System.out.println(queue.removeBack());
		
		System.out.print("Expected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		queue.addToBack(17);
		queue.clear();
		
		System.out.print("Expected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		
	}
}
