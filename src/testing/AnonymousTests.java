package testing;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Stack;

import org.junit.Test;

import edu.iastate.cs228.proj5.DFS;
import edu.iastate.cs228.proj5.DiGraph;
import edu.iastate.cs228.proj5.MaxPath;

public class AnonymousTests {
	//Anonymous extra tests
	
		@Test 
		public void cyclicTest1() {
			DiGraph<String> G8 = new DiGraph<>();
			G8.addEdge("W", "A", 5);
			G8.addEdge("A", "L", 3);
			assertNotNull(DFS.depthFirstSearch(G8));
			G8.addEdge("L", "W", 999);
			assertNull(DFS.depthFirstSearch(G8));
		}
		
		@Test 
		public void cyclicTest2() {
			DiGraph<String> G8 = new DiGraph<>();
			G8.addEdge("W", "A", 1);
			G8.addEdge("A", "L", 1);
			assertNotNull(DFS.depthFirstSearch(G8));
			G8.addEdge("L", "W", 1);
			assertNull(DFS.depthFirstSearch(G8));
		}
		
		@Test (expected=IllegalArgumentException.class)
		public void cyclicTest3() {
			DiGraph<String> G8 = new DiGraph<>();
			G8.addEdge("W", "A", 1);
			G8.addEdge("A", "L", 1);
			G8.addEdge("L", "W", 1);
			Stack<String> path = new Stack<>();
			MaxPath.findMaxPath(G8, path);
		}
		
		@Test (expected=IllegalStateException.class)
		public void noEntriesTest() {
			DiGraph<String> G8 = new DiGraph<>();
			Stack<String> path = new Stack<>();
			MaxPath.findMaxPath(G8, path);
		}
}
