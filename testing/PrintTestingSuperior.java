package testing;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import edu.iastate.cs228.hw06.AList;
import edu.iastate.cs228.hw06.CustomClass;
import edu.iastate.cs228.hw06.LList;
import edu.iastate.cs228.hw06.LListWithTail;

public class PrintTestingSuperior {
	private static ArrayList<CustomClass<String>> lists = new ArrayList<>();

	public static void main(String[] args) {
		//Testing addFirst
		System.out.println("Testing addFirst");
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			list.addFirst( "First" );

			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("----------------");
		});
		System.out.println();
		clearList();

		//Testing addLast
		System.out.println("Testing addLast");
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			list.addLast( "Last" );

			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("----------------");
		});
		System.out.println();
		clearList();

		//Testing removeFirst
		System.out.println("Testing removeFirst");
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			list.removeFirst();

			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("----------------");
		});
		clearList();
		//Testing removeFirst exception
		System.out.println("======Testing exception======");
		lists.forEach( (list)-> {
			try {
				list.removeFirst();
				System.out.println("No exception, no good");
				System.out.println("----------------");
			}catch( NoSuchElementException e) {
				System.out.println(e.getMessage());
				System.out.println("----------------");
			}
		});
		System.out.println();

		//Testing removeLast
		System.out.println("Testing removeLast");
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			list.removeLast();

			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("----------------");
		});
		clearList();
		//Testing removeLast exception
		System.out.println("======Testing exception======");
		lists.forEach( (list)-> {
			try {
				list.removeLast();
				System.out.println("No exception, no good");
				System.out.println("----------------");
			}catch( NoSuchElementException e) {
				System.out.println(e.getMessage());
				System.out.println("----------------");
			}
		});
		System.out.println();


		//Testing getFirst
		System.out.println("Testing getFirst");
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			System.out.println(list.getFirst());

			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("----------------");
		});
		clearList();
		//Testing getFirst exception
		System.out.println("======Testing exception======");
		lists.forEach( (list)-> {
			try {
				list.getFirst();
				System.out.println("No exception, no good");
				System.out.println("----------------");
			}catch( NoSuchElementException e) {
				System.out.println(e.getMessage());
				System.out.println("----------------");
			}
		});
		System.out.println();

		//Testing getLast
		System.out.println("Testing getLast");
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			System.out.println(list.getLast());

			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("----------------");
		});
		clearList();
		//Testing getLast exception
		System.out.println("======Testing exception======");
		lists.forEach( (list)-> {
			try {
				list.getLast();
				System.out.println("No exception, no good");
				System.out.println("----------------");
			}catch( NoSuchElementException e) {
				System.out.println(e.getMessage());
				System.out.println("----------------");
			}
		});
		System.out.println();


		//Testing moveToEnd
		System.out.println("Testing moveToEnd");
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "Element" );
			list.add( "World" );
			list.moveToEnd();

			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("----------------");
		});
		clearList();
		//Testing moveToEnd exception
		System.out.println("======Testing exception======");
		lists.forEach( (list)-> {
			try {
				list.moveToEnd();
				System.out.println("No exception, yes, good");
				System.out.println("----------------");
			}catch( NoSuchElementException e) {
				System.out.println("ooOOoOooofff, Ce n'est pas bien");
				System.out.println(e.getMessage());
				System.out.println("----------------");
			}
		});
		System.out.println();


		//Testing remove
		System.out.println("Testing remove");
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			System.out.println("True - Hello: "+list.remove("Hello" ));
			System.out.println("False - Element: "+list.remove("Element" ));

			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("----------------");
		});
		System.out.println();
		clearList();


		//Testing getPosition
		System.out.println("Testing getPosition");
		lists.forEach( (list)-> {
			list.add( "First" );
			list.add( "Second" );
			list.add( "Third" );

			System.out.println("1 - First: "+list.getPosition( "First"));
			System.out.println("2 - Second: "+list.getPosition( "Second"));
			System.out.println("3 - Third: "+list.getPosition( "Third"));
			System.out.println("-1 - oOf: "+list.getPosition( "oOf"));

			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("----------------");
		});
		System.out.println();
		clearList();



	}

	public static void clearList() {
		lists.clear();

		lists.add( new LList<String>() );
		lists.add( new LListWithTail<String>() );
		lists.add( new AList<String>() );
	}
}
