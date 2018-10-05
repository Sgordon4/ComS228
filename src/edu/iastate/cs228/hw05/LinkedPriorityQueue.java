package edu.iastate.cs228.hw05;

/**
 * A class of priority queues represented by a chain of linked nodes.
 * 
 * @author
 * Sean Gordon
 * 
 * NOTE: 
 * 0. Put your Firstname and Lastname after above author tag.
 * 			Make sure that in both cases the first letter is uppercase
 *    and all others are lowercase.
 * 1. You are allowed to create and use your own private helper methods. 
 * 2. No additional data fields can be introduced.
 * 3. No custom classes of your own can be introduced or used.
 * 4. Import statements are not allowed.
 * 5. Fully qualified class names usage is not allowed.
 * 6. You are allowed to reuse any part of the source codes of provided 
 *    source codes or shown under lecture notes.
 * 7. You are not allowed to create arrays of objects and manipulate
 *    queue objects using arrays.
 *  
 *
 * DESCRIPTION:
 * A class of priority queues represented by a linked chain of nodes.
 * 
 * For details of priority queue implementation using linked chain of nodes, 
 * check slide number 14 of "queueDequePriorityQueueImplementations_part3.pdf" 
 * file under lecture notes of Friday of Week 5 on Canvas.
 */


public final class LinkedPriorityQueue<T extends Comparable<? super T>>
implements PriorityQueueInterface<T>
{
	private Node firstNode; // Reference to first node of chain and the front
	// of the priority queue, which has the highest priority
	private int  length;    // Number of entries in chain

	public LinkedPriorityQueue()
	{
		firstNode = null;
		length = 0;
	}

	//I am keeping high priority items at the front of the list for easier use
	public void add(T newEntry)
	{
		if(newEntry == null)
			throw new IllegalArgumentException();

		Node newNode = new Node(newEntry);

		//If there are no existing nodes or this node is highest priority, add it to the front
		if(firstNode == null || firstNode.getData().compareTo(newEntry) < 0) {
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		}

		//Else, iterate through the list until a node that is smaller than newEntry is found and put it there
		else {
			Node temp = firstNode;
			while(temp.getNextNode() != null && 							//Is this next node null
					temp.getNextNode().getData().compareTo(newEntry) > 0) {	//or is it smaller?
				temp = temp.getNextNode();									//If not, select it and repeat
			}
			//							   (or null)
			//Stick newEntry in between the smaller node and the currently selected one
			newNode.setNextNode(temp.getNextNode());
			temp.setNextNode(newNode);
		}

		length++;				//Just added a node, so length goes up
	} 

	//Highest priority nodes are at the front, so remove is easy to implement
	public T remove()
	{
		if(firstNode == null)
			return null;
		
		Node temp = firstNode;
		firstNode = firstNode.getNextNode();
		
		return temp.getData();
	}

	//Highest priority nodes are at the front, so peek is easy to implement
	public T peek()
	{
		if(firstNode == null)
			return null;
		
		return firstNode.getData();
	}

	/**
	 * If queue is empty returns [].
	 * Else, returns as [1, 2, 3]
	 * Important: note a comma and single space before every
	 * item except the last, and after last there is no space.
	 * In both cases before and after square brackets there
	 * is no space.
	 *    
	 */
	@Override
	public String toString()
	{
		Node temp = firstNode;
		String ret = "]";
		while(temp != null) {
			ret = ", " +temp.getData() +  ret;
			temp = temp.getNextNode();
		}
		ret = "[" + ret.replaceAll("^, ", "");
		return ret;
	}


	public boolean isEmpty()
	{
		boolean result;

		if (length == 0)
		{
			assert firstNode == null;
			result = true;
		}
		else
		{
			assert firstNode != null;
			result = false;
		}

		return result;
	}

	public int getSize()
	{
		return length;
	}

	public void clear()
	{
		firstNode = null;
		length = 0;
	}


	private class Node
	{
		private T    data; // Entry in priority queue
		private Node next; // Link to next node

		private Node(T dataPortion) 
		{
			data = dataPortion;
			next = null;	
		}

		private Node(T dataPortion, Node nextNode) 
		{
			data = dataPortion;
			next = nextNode;	
		}

		private T getData()
		{
			return data;
		}

		private void setData(T newData)
		{
			data = newData;
		}

		private Node getNextNode()
		{
			return next;
		}

		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		}
	}
} // end LinkedPriorityQueue