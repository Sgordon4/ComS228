package edu.iastate.cs228.hw04;

public class CircularLinkedTest {
	public static void main(String[] args) {
		CircularLinkedQueue<Integer> queue = new CircularLinkedQueue<Integer>();
		
		
		System.out.print("Expected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.print("Expected: null\nActual:   ");
		System.out.println(queue.getFront());
		
		System.out.print("Expected: null\nActual:   ");
		System.out.println(queue.dequeue());
		
		queue.clear();			//Expected no errors
		
		queue.enqueue(17);
		queue.enqueue(27);
		queue.enqueue(37);		//Expected no errors
		queue.enqueue(47);
		queue.enqueue(97);
		
		System.out.print("Expected: 17\nActual:   ");
		System.out.println(queue.getFront());
		
		System.out.print("Expected: 17\nActual:   ");
		System.out.println(queue.dequeue());
		System.out.print("Expected: 27\nActual:   ");
		System.out.println(queue.dequeue());
		
		System.out.print("Expected: false\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.print("Expected: 37\nActual:   ");
		System.out.println(queue.dequeue());
		System.out.print("Expected: 47\nActual:   ");
		System.out.println(queue.dequeue());
		System.out.print("Expected: 97\nActual:   ");
		System.out.println(queue.dequeue());
		
		System.out.print("Expected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		queue.enqueue(17);
		queue.clear();
		
		System.out.print("Expected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		
	}
}
