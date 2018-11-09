package edu.iastate.cs228.hw09;/** * An interface of basic methods for the ADT tree. *  * @author Frank M. Carrano * @author Timothy M. Henry */public interface TreeInterface<T>{  public T getRootData();  public int getHeight();  public int getNumberOfNodes();  public boolean isEmpty();  public void clear();} // end TreeInterface