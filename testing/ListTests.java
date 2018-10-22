package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.hw06.*;

public class ListTests {
	private ArrayList<CustomClass<String>> lists = new ArrayList<>();
	
	@Before
	public void setupLListTest(){
		lists.add( new LList<String>() );
		lists.add( new LListWithTail<String>() );
		lists.add( new AList<String>() );
	}
	
	@Test
	public void testAddFirst(){
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			list.addFirst( "First" );
			assertEquals( "Failed for class " + list.getClass().getSimpleName(), "First", list.getEntry(1) );
		});
	}
	
	@Test
	public void testAddLast(){
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			list.addLast( "Last" );
			assertEquals( "Failed for class " + list.getClass().getSimpleName(), "Last", list.getEntry(3) );
		});
	}
	
	@Test
	public void testRemoveFirst(){
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			assertEquals( "Failed for class " + list.getClass().getSimpleName(), "Hello", list.removeFirst() );
			assertEquals( "Failed for class " + list.getClass().getSimpleName(), 1, list.getLength() );
		});
	}
	
	@Test
	public void testRemoveFirstException(){
		lists.forEach( (list)-> {
			try{ 
				list.removeFirst();
				fail( "Failed for class " + list.getClass().getSimpleName() );
			}catch( NoSuchElementException e ){
				
			}
		});
	}
	
	@Test
	public void testRemoveLast(){
		lists.forEach( (list)->{
			list.add( "Hello" );
			list.add( "World" );
			assertEquals( "Failed for class " + list.getClass().getSimpleName(), "World", list.removeLast() );
			assertEquals( "Failed for class " + list.getClass().getSimpleName(), 1, list.getLength() );
		});
	}
	
	@Test
	public void testRemoveLastException(){
		lists.forEach( (list) -> {
			try{
				list.removeLast();
				fail( "Failed for class " + list.getClass().getSimpleName() );
			}catch( NoSuchElementException e ){
				
			}
		});
	}
	
	@Test
	public void testGetFirst(){
		lists.forEach( (list)-> {
			list.add( "Hello" );
			list.add( "World" );
			assertEquals( "Failed for class " + list.getClass().getSimpleName(), "Hello", list.getFirst() );
		});
	}
	
	@Test
	public void testGetFirstException(){
		lists.forEach( (list) -> {
			try{
				list.getFirst();
				fail( "Failed for class " + list.getClass().getSimpleName() );
			}catch( NoSuchElementException e ){
				
			}
		});
	}
	
	@Test
	public void testGetLast(){
		lists.forEach( (list) -> {
			list.add( "Hello" );
			list.add( "World" );
			assertEquals( "Failed for class " + list.getClass().getSimpleName(), "World", list.getLast() );
		});
	}
	
	@Test
	public void testGetLastException(){
		lists.forEach( (list) -> {
			try{
				list.getLast();
				fail( "Failed for class " + list.getClass().getSimpleName() );
			}catch( NoSuchElementException e ){
				
			}
		});
	}
	
	@Test
	public void testMoveToEnd(){
		lists.forEach( (list) -> {
			list.add( "Hello" );
			list.add( "Element" );
			list.add( "World" );
			list.moveToEnd();
			assertArrayEquals( "Failed for class " + list.getClass().getSimpleName(), new String[]{"Element", "World", "Hello"}, list.toArray());
		} );
	}
	
	@Test
	public void testMoveToEndNoException(){
		lists.forEach( (list) -> {
			list.moveToEnd();
		});
	}
	
	@Test
	public void testRemove(){
		lists.forEach( (list) -> {
			list.add( "Hello" );
			list.add( "World" );
			assertTrue( "Failed for class " + list.getClass().getSimpleName(), list.remove( "Hello" ) );
			assertFalse( "Failed for class " + list.getClass().getSimpleName(), list.remove( "Element" ) );
			assertArrayEquals( "Failed for class " + list.getClass().getSimpleName(), new String[]{"World"}, list.toArray());
		});
	}
	
	@Test
	public void testGetPosition(){
		lists.forEach( (list) -> {
			list.add( "First" );
			list.add( "Second" );
			list.add( "Third" );
			System.out.println(java.util.Arrays.toString(list.toArray()));
			System.out.println("First: "+list.getPosition( "First"));
			assertEquals("Failed for class " + list.getClass().getSimpleName(), 1, list.getPosition( "First") );
			System.out.println("Second: "+list.getPosition( "Second"));
			assertEquals("Failed for class " + list.getClass().getSimpleName(), 2, list.getPosition( "Second") );
			System.out.println("Third: "+list.getPosition( "Third"));
			assertEquals("Failed for class " + list.getClass().getSimpleName(), 3, list.getPosition( "Third") );
			System.out.println("Hello: "+list.getPosition( "Hello"));
			assertEquals("Failed for class " + list.getClass().getSimpleName(), -1, list.getPosition( "Hello") );
			System.out.println();
		});
	}
}