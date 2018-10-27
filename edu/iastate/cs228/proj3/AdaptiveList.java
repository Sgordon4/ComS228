package edu.iastate.cs228.proj3;

/*
 *  @author Sean Gordon
 *
 *
 *  An implementation of List<E> based on a doubly-linked list 
 *  with an array for indexed reads/writes
 *
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class AdaptiveList<E> implements List<E>
{
	public class ListNode 
	{                     
		public E data;        
		public ListNode next; 
		public ListNode prev; 

		public ListNode(E item)
		{
			data = item;
			next = prev = null;
		}
	}

	public ListNode head;  // dummy node made public for testing.
	public ListNode tail;  // dummy node made public for testing.
	private int numItems;  // number of data items
	private boolean linkedUTD; // true if the linked list is up-to-date.

	public E[] theArray;  // the array for storing elements
	private boolean arrayUTD; // true if the array is up-to-date.

	public AdaptiveList()
	{
		clear();
	}

	@Override
	public void clear()
	{
		head = new ListNode(null);
		tail = new ListNode(null);
		head.next = tail;
		tail.prev = head;
		numItems = 0;
		linkedUTD = true;
		arrayUTD = false;
		theArray = null;
	}

	public boolean getlinkedUTD()
	{
		return linkedUTD;
	}

	public boolean getarrayUTD()
	{
		return arrayUTD;
	}

	public AdaptiveList(Collection<? extends E> c)
	{
		clear();
		addAll(c);
	}

	// Removes the node from the linked list.
	// This method should be used to remove a node 
	// from the linked list.
	private void unlink(ListNode toRemove)
	{
		if ( toRemove == head || toRemove == tail )
			throw new RuntimeException("An attempt to remove head or tail");
		toRemove.prev.next = toRemove.next;
		toRemove.next.prev = toRemove.prev;
	}

	// Inserts new node toAdd right after old node current.
	// This method should be used to add a node to the linked list.
	private void link(ListNode current, ListNode toAdd)
	{
		if ( current == tail )
			throw new RuntimeException("An attempt to chain after tail");
		if ( toAdd == head || toAdd == tail )
			throw new RuntimeException("An attempt to add head/tail as a new node");
		toAdd.next = current.next;
		toAdd.next.prev = toAdd;
		toAdd.prev = current;
		current.next = toAdd;
	}

	private void updateArray() // makes theArray up-to-date.
	{
		if ( numItems < 0 )
			throw new RuntimeException("numItems is negative: " + numItems);
		if ( ! linkedUTD )
			throw new RuntimeException("linkedUTD is false");


		@SuppressWarnings("unchecked")			//OK because new & of type Object
		E[] arr = (E[])new Object[numItems];	//Make a new array to fill
		ListNode tempNode = head.next;			//Create an iterator node, can replace with iterator later

		for(int i = 0; i < numItems; i++) {
			arr[i] = tempNode.data;
			tempNode = tempNode.next;
		}

		this.theArray = arr;

		arrayUTD = true;
	}

	private void updateLinked() // makes the linked list up-to-date.
	{
		if ( numItems < 0 )
			throw new RuntimeException("numItems is negative: " + numItems);
		if ( ! arrayUTD )
			throw new RuntimeException("arrayUTD is false");

		if ( theArray == null || theArray.length < numItems )
			throw new RuntimeException("theArray is null or shorter");

		head.next = tail;				//Clear linkedList
		tail.prev = head;

		for(E data : theArray) {
			add(data);
		}

		linkedUTD = true;
	}

	@Override
	public int size()
	{
		return numItems;
	}

	@Override
	public boolean isEmpty()
	{
		return numItems == 0;
	}



	//Start of methods that change linkedUTD and arrayUTD

	/*---- Start of methods using linkedList ----*/

	@Override
	public boolean add(E obj)
	{
		if(!linkedUTD)
			updateLinked();

		add(numItems-1, obj);

		arrayUTD = false;
		return true;
	}

	@Override
	public boolean addAll(Collection< ? extends E> c)
	{
		if(!linkedUTD)
			updateLinked();

		addAll(numItems-1, c);

		arrayUTD = false;
		return true;
		/*
		Iterator<? extends E> iterator = c.iterator();		//Can't use this iterator nm

		while(iterator.hasNext()) {			//--Default-Java-iterator-implementation--
			add(iterator.next());			//Can't use this, for loop master race apparently idk
		}
		return true; 
		 */
	}

	@Override
	public boolean remove(Object obj)
	{
		if(!linkedUTD)
			updateLinked();

		E IDKWhatToDoWithThis = remove(indexOf(obj));

		arrayUTD = false;
		return true;

		/*
		unlink(findNode(indexOf(obj)));

		numItems--;
		return true;
		 */
	}

	//---------------------------------------------------------

	private void checkIndex(int pos) // a helper method
	{
		if ( pos >= numItems || pos < 0 )
			throw new IndexOutOfBoundsException(
					"Index: " + pos + ", Size: " + numItems);
	}

	private void checkIndex2(int pos) // a helper method
	{
		if ( pos > numItems || pos < 0 )
			throw new IndexOutOfBoundsException(
					"Index: " + pos + ", Size: " + numItems);
	}

	private void checkNode(ListNode cur) // a helper method
	{
		if ( cur == null || cur == tail )
			throw new RuntimeException(
					"numItems: " + numItems + " is too large");
	}

	//This method should never be called before an update, as we can't change it to update the list
	private ListNode findNode(int pos)   // a helper method
	{
		ListNode cur = head;
		for ( int i = 0; i < pos; i++ )
		{
			checkNode(cur);
			cur = cur.next;
		}
		checkNode(cur);
		return cur;
	}

	//---------------------------------------------------------

	@Override
	public void add(int pos, E obj)
	{
		if(!linkedUTD)
			updateLinked();

		ListNode newNode = new ListNode(obj);

		link(findNode(pos), newNode);

		arrayUTD = false;
		numItems++;
	}

	@Override
	public boolean addAll(int pos, Collection< ? extends E> c)
	{
		if(!linkedUTD)
			updateLinked();

		Iterator<? extends E> iterator = c.iterator();

		while(iterator.hasNext()) {			//Default Java iterator implementation
			add(pos++, iterator.next());	//Add at position, then shift position over
		}

		arrayUTD = false;
		return true; 
	}

	@Override
	public E remove(int pos)
	{
		if(!linkedUTD)
			updateLinked();

		ListNode nodeToRemove = findNode(pos);
		unlink(nodeToRemove);

		numItems--;
		arrayUTD = false;
		return nodeToRemove.data; 
	}


	/*---- Start of methods using theArray ----*/

	@Override
	public E get(int pos)
	{
		if(!arrayUTD)
			updateArray();

		return theArray[pos]; 
	}

	@Override
	public E set(int pos, E obj)
	{
		if(!arrayUTD)
			updateArray();

		E temp = theArray[pos];
		theArray[pos] = obj;

		linkedUTD = false;
		return temp; 
	} 

	/**
	 *  If the number of elements is at most 1, 
	 *  the method returns false. Otherwise, it 
	 *  reverses the order of the elements in the 
	 *  array without using any additional array, 
	 *  and returns true. Note that if the array 
	 *  is modified, then linkedUTD needs to be set 
	 *  to false.
	 */
	public boolean reverse()
	{
		if(!arrayUTD)
			updateArray();
		
		if(theArray.length < 2)
			return false;

		int left = 0;
		int right = theArray.length-1;
		E temp;

		while(left < right) {
			temp 			= theArray[left];
			theArray[left] 	= theArray[right];
			theArray[right] = temp;
		}

		linkedUTD = false;
		return true;
	}


	/** 
	 *  If the number of elements is at most 1, 
	 *  the method returns false. Otherwise, it 
	 *  swaps the items positioned at even index 
	 *  with the subsequent one in odd index without 
	 *  using any additional array, and returns true.
	 *  Note that if the array is modified, then 
	 *  linkedUTD needs to be set to false. 
	 */
	public boolean reorderOddEven()
	{
		if(!arrayUTD)
			updateArray();
		
		if(theArray.length < 2)
			return false;

		int pos = 0;
		E temp;

		while(pos+1 < theArray.length) {
			temp 			= theArray[pos];
			theArray[pos]	= theArray[pos+1];
			theArray[pos+1] = temp;
		}

		linkedUTD = false;
		return true;
	}
	
	/*---- End of methods using theArray ----*/

	
	@Override
	public boolean contains(Object obj)
	{
		if(!linkedUTD)
			updateLinked();
		
		AdaptiveListIterator iterator = new AdaptiveListIterator();

		while(iterator.hasNext()) {
			if(iterator.next().equals(obj))
				return true;
		}

		return false;
	}

	@Override
	public boolean containsAll(Collection< ? > c)
	{
		if(!linkedUTD)
			updateLinked();
		
		Iterator<?> iterator = c.iterator();

		while(iterator.hasNext()) {
			if(!contains(iterator.next()))
				return false;
		}

		return true; 
	}


	@Override
	public int indexOf(Object obj)
	{
		if(!linkedUTD)
			updateLinked();
		
		AdaptiveListIterator iterator = new AdaptiveListIterator();

		while(iterator.hasNext()) {
			if(iterator.next().equals(obj))
				break;
		}
		return iterator.previousIndex(); 
	}

	@Override
	public int lastIndexOf(Object obj)	//TODO
	{
		if(!linkedUTD)
			updateLinked();
		
		AdaptiveListIterator iterator = new AdaptiveListIterator();

		while(iterator.hasNext()) {
			if(iterator.next().equals(obj))
				break;
		}
		return iterator.previousIndex(); 
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		if(!linkedUTD)
			updateLinked();
		
		AdaptiveListIterator iterator = new AdaptiveListIterator();
		E temp;

		while(iterator.hasNext()) {
			temp = iterator.next();
			if(c.contains(temp))
				remove(temp);
		}

		arrayUTD = false;
		return true; 
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		if(!linkedUTD)
			updateLinked();
		
		AdaptiveListIterator iterator = new AdaptiveListIterator();
		E temp;

		while(iterator.hasNext()) {
			temp = iterator.next();
			if(!c.contains(temp))
				remove(temp);
		}

		arrayUTD = false;
		return true; 
	}

	@Override
	public Object[] toArray()
	{
		if(!arrayUTD)
			updateArray();
		
		return toArray(theArray);
		
		/*						Didn't realize we had a methd to copy theArray so I made this. Now obsolete
		if(!linkedUTD)
			updateLinked();
		
		Object[] newObj= new Object[numItems];
		AdaptiveListIterator iterator = new AdaptiveListIterator();

		int index = 0;
		while(iterator.hasNext()) {					//While there are more nodes to loop through...
			newObj[index++] = iterator.next();		//Insert next data element into array at index, then increment index
		}

		arrayUTD = false;
		return newObj; 
		*/
	}


	/**
	 * In here you are allowed to use only 
	 * java.util.Arrays.copyOf method.
	 */
	@Override
	public <T> T[] toArray(T[] arr)
	{
		return java.util.Arrays.copyOf(arr, arr.length); 
	}

	@Override
	public List<E> subList(int fromPos, int toPos)
	{
		throw new UnsupportedOperationException();
	}

	private class AdaptiveListIterator implements ListIterator<E>
	{
		private int    index;  // index of next node;
		private ListNode cur;  // node at index - 1
		private ListNode last; // node last visited by next() or previous()

		public AdaptiveListIterator()
		{
			this(0);
		}
		public AdaptiveListIterator(int pos)
		{
			if ( ! linkedUTD ) updateLinked();

			index = pos;
			cur = findNode(pos);
			last = new ListNode(null);
		}

		@Override
		public boolean hasNext()
		{
			return index < AdaptiveList.this.size();
		}

		@Override
		public E next()
		{
			if(!hasNext())
				throw new NoSuchElementException();
			//	Assume cur is pointing to the node to its right
			index++;					//            cur					L = something
			last = cur;					// 4       5   |>  6       7		
			cur = cur.next;				//			       L  cur			
			return last.data;			// 4       5      *6*  |>  7
		} 

		@Override
		public boolean hasPrevious()
		{
			return index > 1;
		}

		@Override
		public E previous()
		{								
			if(!hasPrevious())
				throw new NoSuchElementException();
			//	Assume cur is pointing to the node to its right
			index--;					//            cur					L = something
			last = cur;					// 4       5   |>  6       7		
			cur = cur.prev;				//	  cur  L						L and current are actually pointing
			return cur.data;			// 4   |> *5*      6       7		to the same node now
		}

		@Override
		public int nextIndex()
		{
			return index; 
		}

		@Override
		public int previousIndex()
		{
			return index-1; 
		}

		@Override
		public void remove()			//Remove is defined to act on the last node returned by next/previous
		{
			if(last == null)			//Must call next or previous first
				throw new IllegalStateException();

			unlink(last);

			if(cur == last)				//If prev is called, then remove, next() would otherwise return 
				cur = cur.next;			//the removed node
			last = null;

			numItems--;

			/*
			last.prev.next = last.next;
			last.next.prev = last.prev;
			 */
		}

		@Override
		public void add(E obj)			//add() is defined to add the new node immediately before the next node to be
		{ 								//returned by next() and after the node that would be returned by previous
			ListNode newNode = new ListNode(obj);
			link(cur.prev, newNode);
			//As specified by official documentation, remove or set
			last = null;				//cannot be called after this method, so set last=null
			numItems++;

			/*
			cur.prev.next = newNode;
			cur.prev = newNode;
			 */
		} 

		@Override
		public void set(E obj)
		{
			if(last == null)			//Must call next or previous first
				throw new IllegalStateException();

			last.data = obj;
		}
	} // AdaptiveListIterator

	@Override
	public boolean equals(Object obj)
	{
		if ( ! linkedUTD ) updateLinked();
		if ( (obj == null) || ! ( obj instanceof List<?> ) )
			return false;
		List<?> list = (List<?>) obj;
		if ( list.size() != numItems ) return false;
		Iterator<?> iter = list.iterator();
		for ( ListNode tmp = head.next; tmp != tail; tmp = tmp.next )
		{
			if ( ! iter.hasNext() ) return false;
			Object t = iter.next();
			if ( ! (t == tmp.data || t != null && t.equals(tmp.data) ) )
				return false;
		}
		if ( iter.hasNext() ) return false;
		return true;
	}

	@Override
	public Iterator<E> iterator()
	{
		return new AdaptiveListIterator();
	}

	@Override
	public ListIterator<E> listIterator()
	{
		return new AdaptiveListIterator();
	}

	@Override
	public ListIterator<E> listIterator(int pos)
	{
		checkIndex2(pos);
		return new AdaptiveListIterator(pos);
	}

	// Adopted from the List<E> interface.
	@Override
	public int hashCode()
	{
		if ( ! linkedUTD ) updateLinked();
		int hashCode = 1;
		for ( E e : this )
			hashCode = 31 * hashCode + ( e == null ? 0 : e.hashCode() );
		return hashCode;
	}

	// You should use the toString*() methods to see if your code works as expected.
	@Override
	public String toString()
	{
		// Other options System.lineSeparator or
		// String.format with %n token...
		// Not making data field.
		String eol = System.getProperty("line.separator");
		return toStringArray() + eol + toStringLinked();
	}

	public String toStringArray()
	{
		String eol = System.getProperty("line.separator");
		StringBuilder strb = new StringBuilder();
		strb.append("A sequence of items from the most recent array:" + eol );
		strb.append('[');
		if ( theArray != null )
			for ( int j = 0; j < theArray.length; )
			{
				if ( theArray[j] != null )
					strb.append( theArray[j].toString() );
				else
					strb.append("-");
				j++;
				if ( j < theArray.length )
					strb.append(", ");
			}
		strb.append(']');
		return strb.toString();
	}

	public String toStringLinked()
	{
		return toStringLinked(null);
	}

	// iter can be null.
	public String toStringLinked(ListIterator<E> iter)
	{
		int cnt = 0;
		int loc = iter == null? -1 : iter.nextIndex();

		String eol = System.getProperty("line.separator");
		StringBuilder strb = new StringBuilder();
		strb.append("A sequence of items from the most recent linked list:" + eol );
		strb.append('(');
		for ( ListNode cur = head.next; cur != tail; )
		{
			if ( cur.data != null )
			{
				if ( loc == cnt )
				{
					strb.append("| ");
					loc = -1;
				}
				strb.append(cur.data.toString());
				cnt++;

				if ( loc == numItems && cnt == numItems )
				{
					strb.append(" |");
					loc = -1;
				}
			}
			else
				strb.append("-");

			cur = cur.next;
			if ( cur != tail )
				strb.append(", ");
		}
		strb.append(')');
		return strb.toString();
	}
}
