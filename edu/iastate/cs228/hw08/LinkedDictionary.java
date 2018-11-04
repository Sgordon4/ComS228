
package edu.iastate.cs228.hw08;



import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
/**
 * 
 * 
 * A class that implements the ADT dictionary by using a chain of nodes.
 * The dictionary is unsorted and has distinct search keys, i.e., can have 
 * duplicate values, however, those are differentiated based on their keys.
 * 
 * @author Sean Gordon
 * 
 * NOTEs and REQUIREMENTs:
 * 
 * Exactly same as the ones listed for SortedVectorDictionary class.
 * 
 * In addition to above ANSWER the following 6 QUESTIONS, inside these 
 * comments right below each question. Figures needed to answer questions
 * 3, 4, and 5 are shown on Canvas under description of HW08.
 * 
 * =========================================================================
 * Q1. (a) What is the height of the shortest binary tree that contains 22
 *     nodes? (b) Is this tree full? (c) Is it balanced?
 *     
 * A1. (a)
 *     (b)
 *     (c)
 * =========================================================================
 * Q2. Consider a binary tree that has four levels.
 *     (a) What is the maximum number of nodes in this tree?
 *     (b) What is the maximum number of leaves in this tree?
 *     
 * A2. (a)
 *     (b)    
 * =========================================================================
 * Q3. Consider a traversal of a binary tree, which contains Integer data. 
 *     Suppose that visiting a node means to simply display the data in the 
 *     node. What are the results of each of the following traversals of the 
 *     binary tree shown in Figure 1.
 *     (a) Preorder
 *     (b) Postorder
 *     (c) Inorder
 *     (d) Level order
 *     
 * A3. (a)
 *     (b)
 *     (c)
 *     (d)
 *     
 * =========================================================================
 * Q4. Repeat Q3 but for the binary tree shwn in Figure 2. 
 * A4. (a)
 *     (b)
 *     (c)
 *     (d)
 *  
 * =========================================================================
 * Q5. The two binary trees shown in Figures 1 and 2 contain Integer data.
 *     (a) Is the tree in Figure 1 a binary search tree? Why or why not?
 *     (b) Is the tree in Figure 2 a maxheap? Why or why not?
 *  
 * A5. (a)
 *     (b)
 *     
 * =========================================================================
 * Q6. Can a binary search tree ever be a maxheap? Explain.
 * A6.                           
 *     
 *     
 *     
 *     
 *     
 *     
 */
public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>
{
	private Node firstNode;   // Reference to first node of chain
	private int  numberOfEntries; 

	public LinkedDictionary()
	{
		firstNode = null;
		numberOfEntries = 0;
	}

	public V add(K key, V value)
	{
		if(Objects.isNull(key) || Objects.isNull(value))
			throw new IllegalArgumentException();

		V val = null;
		if(contains(key))
			val = remove(key);

		Node newNode = new Node(key, value, firstNode);
		firstNode = newNode;

		numberOfEntries++;

		return val;
	}

	public V remove(K key)
	{
		if(Objects.isNull(key))
			throw new IllegalArgumentException();
		
		Node nextNode = firstNode;
		V val = null;
		
		if(nextNode.getKey() == key) {
			val = firstNode.getValue();
			firstNode = firstNode.getNextNode();
		}
		
		for(int i = 0; i < getSize()-1; i++) {
			if(nextNode.getNextNode().getKey() == key) {
				val = nextNode.getNextNode().getValue();
				nextNode.setNextNode(nextNode.getNextNode().getNextNode());
			}
		}
		
		return val;
	}

	public V getValue(K key)
	{
		if(Objects.isNull(key))
			throw new IllegalArgumentException();

		Node nextNode = firstNode;
		
		while(nextNode != null) {
			if(nextNode.getKey() == key)
				return nextNode.getValue();
			
			nextNode = nextNode.getNextNode();
		}

		return null;
	}

	public boolean contains(K key)
	{
		if(Objects.isNull(key))
			throw new IllegalArgumentException();

		Iterator<K> iterator = getKeyIterator();
		
		while(iterator.hasNext()) {
			if(iterator.next() == key)
				return true;
		}

		return false; 
	}

	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}

	public int getSize()
	{
		return numberOfEntries;
	}

	public void clear()
	{
		firstNode = null;
		numberOfEntries = 0;
	}

	// Needs to output String representation in exact same
	// format as the one done by SortedVectorDictionary.
	public String toString()
	{
		// TODO  
		return "";
	}

	public Iterator<K> getKeyIterator()
	{
		return new KeyIterator();
	}

	public Iterator<V> getValueIterator()
	{
		return new ValueIterator();
	}

	private class KeyIterator implements Iterator<K>
	{
		private Node nextNode;

		private KeyIterator()
		{
			nextNode = firstNode;
		}

		public boolean hasNext() 
		{
			return (nextNode.getNextNode() != null);
		}

		public K next()
		{
			K temp = nextNode.getKey();
			nextNode.setNextNode(nextNode.getNextNode());
			return temp;
		}
	} 

	private class ValueIterator implements Iterator<V>
	{
		private Node nextNode;

		private ValueIterator()
		{
			nextNode = firstNode;
		}

		public boolean hasNext() 
		{
			return (nextNode.getNextNode() != null);
		}

		public V next()
		{
			V temp = nextNode.getValue();
			nextNode.setNextNode(nextNode.getNextNode());
			return temp;
		}
	}

	private class Node
	{
		private K key;
		private V value;
		private Node next;

		private Node(K searchKey, V dataValue)
		{
			key = searchKey;
			value = dataValue;
			next = null;	
		}

		private Node(K searchKey, V dataValue, Node nextNode)
		{
			key = searchKey;
			value = dataValue;
			next = nextNode;	
		}

		private K getKey()
		{
			return key;
		}

		private V getValue()
		{
			return value;
		}

		private void setValue(V newValue)
		{
			value = newValue;
		}

		private Node getNextNode()
		{
			return next;
		}

		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		}

		public String toString()
		{
			return "("+key+":"+value+")";	
		}
	}
}

