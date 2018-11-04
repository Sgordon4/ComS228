package edu.iastate.cs228.hw08;


import java.util.Vector;
import java.util.Iterator;
import java.util.Objects;
import java.util.NoSuchElementException;

/**
 * A class that implements a sorted dictionary by using a Vector.
 * Entries are sorted based on keys in nondecreasing order. 
 * The dictionary has distinct search keys, i.e., can have duplicate
 * values, however, those are differentiated based on their keys.
 * 
 * @author 
 * 
 * 
 * 
 * NOTEs and REQUIREMENTs:
 *  
 * 0. Put your Firstname and Lastname after above empty author tag.
 * 	  Make sure that in both cases the first letter is uppercase
 *    and all others are lowercase.
 * 1. You are allowed to create and use your own private helper methods.
 * 	  If you are introducing your own helper methods those need to be 
 *    private and properly documented as per Javadoc style. Already 
 *    existing methods declaration cannot be changed, too.     
 * 2. No additional data fields can be introduced in any of the 
 *    classes below. You are not allowed to change the case of the ones
 *    already existing, or rename those.
 * 3. No custom classes of your own can be introduced or used.
 * 4. Import statements are not allowed, besides the ones that are
 *    already provided.
 * 5. Fully qualified class names usage is not allowed.
 * 6. You are allowed to reuse any part of the provided source codes
 *    or shown under lecture notes section of Canvas, which do not 
 *    violate any of above.
 * 7. If you have any additional questions PLEASE ask on Piazza Q/A
 *    platform, but first PLEASE search and make sure that it was not
 *    already asked and answered. PLEASE setup your notifications for 
 *    both Canvas and Piazza so that you are updated whenever there
 *    are any changes immediately.
 * 8. You need to provide implementation to all methods and constructors
 *    which have a comment //TODO in their body. For all of these methods
 *    and constructors there is no need to provide comments.    
 * 
 *    
 *    
 * 
 */ 

public class SortedVectorDictionary<K extends Comparable<? super K>, V> 
       implements DictionaryInterface<K, V>
{
 private Vector<Entry> dict; 	

 public SortedVectorDictionary()
 {
  dict = new Vector<>();
 }

 public SortedVectorDictionary(int initialCapacity)
 {
  dict = new Vector<>(initialCapacity);
 }

 public V add(K key, V value)
 {
  if(Objects.isNull(key) || Objects.isNull(value))
	throw new IllegalArgumentException();
  
  //TODO
  
  return null;
 }

 public V remove(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
  
  // TODO
  
  return null;  
 }

 public V getValue(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
	   
  // TODO
  
  return null;
 }

 public boolean contains(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
		   
  // TODO
	   
  return false; 
 }

 public boolean isEmpty()
 {
  // TODO
  return false;
 }
	
 public int getSize()
 {
  // TODO
  return -1;
 }

 public void clear()
 {
  // TODO		
 }

 public String toString()
 {
  return dict.toString();  
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
  private Iterator<Entry> iter;
		
  private KeyIterator()
  {
   // TODO
  }
		
  public boolean hasNext() 
  {
   // TODO	
   return false;
  }
		
  public K next()
  {
   // TODO	
   return null;	
  }
 } 
	
 private class ValueIterator implements Iterator<V>
 {
  private Iterator<Entry> iter;
		
  private ValueIterator()
  {
   // TODO
  }
		
  public boolean hasNext() 
  {
   // TODO	 
   return false;
  }
		
  public V next()
  {
   // TODO
   return null;
  }
 }
	
 private class Entry
 {
  private K key;
  private V value;
		
  private Entry(K searchKey, V dataValue)
  {
   key = searchKey;
   value = dataValue;
  }
  
  private K getKey()
  {
   return key;
  }
		
  private V getValue()
  {
   return value;
  }
		
  private void setValue(V dataValue)
  {
   value = dataValue;
  }
  
  public String toString()
  {
   return "("+key+":"+value+")";	
  }
 }
}
		
