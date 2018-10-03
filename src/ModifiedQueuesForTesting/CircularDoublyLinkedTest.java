package ModifiedQueuesForTesting;

public class CircularDoublyLinkedTest {
	public static void main(String[] args) {
		CircularDoublyLinkedDeque<Integer> queue = new CircularDoublyLinkedDeque<Integer>();
		 
		
		System.out.print("isEmpty -\nExpected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.println("\nExpected: null for all:   ");
		System.out.print("getFront -    ");
		System.out.println(queue.getFront());
		System.out.print("getBack -     ");
		System.out.println(queue.getBack());
		
		System.out.print("removeFront - ");
		System.out.println(queue.removeFront());
		System.out.print("removeBack -  ");
		System.out.println(queue.removeBack());
		System.out.println("---------------------\n");
		
		queue.clear();				//Expected no errors
		
		queue.addToFront(17);
		queue.addToFront(27);		//Expected no errors
		queue.addToFront(37);
		
		System.out.println(queue.testContents());
		
		System.out.print("\ngetFront -\nExpected: 37\nActual:   ");
		System.out.println(queue.getFront());
		System.out.print("\ngetBack -\nExpected: 17\nActual:   ");
		System.out.println(queue.getBack());
		System.out.println();
		
		System.out.print("\nremoveFront -\nExpected: 37\nActual:   ");
		System.out.println(queue.removeFront());
		System.out.println(queue.testContents());
		System.out.print("\nremoveFront -\nExpected: 27\nActual:   ");
		System.out.println(queue.removeFront());
		System.out.println(queue.testContents());
		
		System.out.print("\nisEmpty -\nExpected: false\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.print("\nremoveFront -\nExpected: 17\nActual:   ");
		System.out.println(queue.removeFront());
		System.out.println(queue.testContents());
		
		System.out.print("\nisEmpty -\nExpected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.print("\nremoveFront -\nExpected: null\nActual:   ");
		System.out.println(queue.removeFront());
		System.out.println(queue.testContents());
		System.out.print("\nremoveFront -\nExpected: null\nActual:   ");
		System.out.println(queue.removeFront());
		System.out.println(queue.testContents());
		
		queue.addToBack(17);
		queue.clear();
		
		System.out.print("\nisEmpty -\nExpected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.println("---------------------");
		System.out.println("---------------------\n");
		
		queue.clear();				//Expected no errors
		
		queue.addToFront(17);
		queue.addToFront(27);		//Expected no errors
		queue.addToFront(37);
		
		System.out.println(queue.testContents());
		
		System.out.print("\nremoveBack -\nExpected: 17\nActual:   ");
		System.out.println(queue.removeBack());
		System.out.println(queue.testContents());
		System.out.print("\nremoveBack -\nExpected: 27\nActual:   ");
		System.out.println(queue.removeBack());
		System.out.println(queue.testContents());
		
		System.out.print("\nisEmpty -\nExpected: false\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.print("\nremoveBack -\nExpected: 37\nActual:   ");
		System.out.println(queue.removeBack());
		System.out.println(queue.testContents());
		
		System.out.print("\nisEmpty -\nExpected: true\nActual:   ");
		System.out.println(queue.isEmpty());
		
		System.out.print("\nremoveBack -\nExpected: null\nActual:   ");
		System.out.println(queue.removeBack());
		System.out.println(queue.testContents());
		System.out.print("\nremoveBack -\nExpected: null\nActual:   ");
		System.out.println(queue.removeBack());
		System.out.println(queue.testContents());
	}
}
