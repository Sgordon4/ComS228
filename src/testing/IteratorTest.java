package testing;

import java.util.Iterator;

import edu.iastate.cs228.hw09.BinaryTree;

public class IteratorTest {
	public static void main(String[] args) {
		BinaryTree<String> left1Tree = new BinaryTree<String>("1");
		BinaryTree<String> right1Tree = new BinaryTree<String>("3");
		BinaryTree<String> firstTree = new BinaryTree<String>();
		firstTree.setTree("2", left1Tree, right1Tree);

		BinaryTree<String> left2Tree = new BinaryTree<String>("5");
		BinaryTree<String> right2Tree = new BinaryTree<String>("7");
		BinaryTree<String> secondTree = new BinaryTree<String>();
		secondTree.setTree("6", left2Tree, right2Tree);

		BinaryTree<String> thirdTree = new BinaryTree<String>();
		thirdTree.setTree("4", firstTree, secondTree); 

		/*
		 *       4		
		 *      / \
		 *     2   6
		 *    / \ / \
		 *   1  3 5  7
		 *   
		 */
		
		System.out.println("InOrder ------------------------------");
		System.out.println("Expected: 1 2 3 4 5 6 7");
		System.out.print("  Actual: ");
		thirdTree.iterativeInorderTraverse();
		System.out.println("\nPreOrder -----------------------------");
		System.out.println("Expected: 4 2 1 3 6 5 7");
		System.out.print("  Actual: ");
		thirdTree.iterativePreorderTraverse();
		System.out.println("\nPostOrder ----------------------------");
		System.out.println("Expected: 1 3 2 5 7 6 4");
		System.out.print("  Actual: ");
		thirdTree.iterativePostorderTraverse();
		System.out.println("\nLevelOrder ---------------------------");
		System.out.println("Expected: 4 2 6 1 3 5 7");
		System.out.print("  Actual: ");
		thirdTree.iterativeLevelorderTraverse();
		
		System.out.println("\n\n======================================\n");
		
		System.out.println("PreOrder -----------------------------");
		System.out.println("Expected: 4 2 1 3 6 5 7");
		System.out.print("  Actual: ");
		Iterator<String> preIter = thirdTree.getPreorderIterator();
		while(preIter.hasNext()) {
			System.out.print(preIter.next()+ " ");
		}

		System.out.println("\nPostOrder ----------------------------");
		System.out.println("Expected: 1 3 2 5 7 6 4");
		System.out.print("  Actual: ");
		Iterator<String> postIter = thirdTree.getPostorderIterator();
		while(postIter.hasNext()) {
			System.out.print(postIter.next()+ " ");
		}

		System.out.println("\nLevelOrder ---------------------------");
		System.out.println("Expected: 4 2 6 1 3 5 7");
		System.out.print("  Actual: ");
		Iterator<String> levelIter = thirdTree.getLevelOrderIterator();
		while(levelIter.hasNext()) {
			System.out.print(levelIter.next()+ " ");
		}
	}
}
