package edu.iastate.cs228.hw02;

import java.util.Arrays;

public class LinkedBagTest {
	public static void main(String[] args) 
	{
		// Tests on a bag that is empty
		System.out.println("Creating an empty bag.");
		BagInterface<String> aBag = new LinkedBag<>();
		displayBag(aBag);
		testIsEmpty(aBag, true);
		String[] testStrings1 = {"", "B"};
		testFrequency(aBag, testStrings1);
		testContains(aBag, testStrings1);
		testRemove(aBag, testStrings1);

		// Adding strings
		String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);

		// Tests on a bag that is not empty
		testIsEmpty(aBag, false);
		String[] testStrings2 = {"A", "B", "C", "D", "Z"};
		testFrequency(aBag, testStrings2);
		testContains(aBag, testStrings2);

		// Removing strings
		String[] testStrings3 = {"", "B", "A", "C", "Z"};
		testRemove(aBag, testStrings3);

		System.out.println("\nClearing the bag:");
		aBag.clear();
		testIsEmpty(aBag, true);
		displayBag(aBag);
		
		System.out.println("\n-------------------");
		System.out.println("     New Tests");
		System.out.println("-------------------\n");

		
		BagInterface<String> bag1 = new LinkedBag<>();
		String[] contentsOfBag1 = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(bag1, contentsOfBag1);

		BagInterface<String> bag2 = new LinkedBag<>();
		String[] contentsOfBag2 = {"A", "D", "B", "A", "C"};
		testAdd(bag2, contentsOfBag2);
		
		System.out.println();
		System.out.println("Testing union,");
		System.out.println("Origionals:");
		System.out.println(Arrays.toString(bag1.toArray()));
		System.out.println(Arrays.toString(bag2.toArray()));
		System.out.println("Expected: \n[A, D, B, A, C, A, D, A, D, B, A, C]");
		System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
		
		System.out.println();
		System.out.println("Testing intersection,");
		System.out.println("Origionals:");
		System.out.println(Arrays.toString(bag1.toArray()));
		System.out.println(Arrays.toString(bag2.toArray()));
		System.out.println("Expected: \n[A, D, B, A, C]");
		System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
		
		System.out.println();
		System.out.println("Testing difference,");
		System.out.println("Origionals:");
		System.out.println(Arrays.toString(bag1.toArray()));
		System.out.println(Arrays.toString(bag2.toArray()));
		System.out.println("Expected: \n[A, D]");
		System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
		
		System.out.println();
		System.out.println("Testing replace(\"Z\"),");
		
		System.out.println("Origional:");
		System.out.println(Arrays.toString(bag1.toArray()));
		bag1.replace("Z");
		System.out.println(Arrays.toString(bag1.toArray()));
		
		System.out.println();
		System.out.println("Testing removeEvery(\"A\"),");
		System.out.println("Origional:");
		System.out.println(Arrays.toString(bag1.toArray()));
		bag1.removeEvery("A");
		System.out.println(Arrays.toString(bag1.toArray()));
		
		System.out.println();
		System.out.println("Testing equals,");
		System.out.println("Expected: \nfalse");
		System.out.println(bag1.equals(bag2));
		
		System.out.println();
		System.out.println("Testing equals,");
		System.out.println("Expected: \ntrue");
		System.out.println(bag1.equals(bag1));
		
		System.out.println();
		System.out.println("Testing difference again, cause Amith thinks it's wrong,");
		System.out.println("Origionals:");
		System.out.println(Arrays.toString(bag1.toArray()));
		System.out.println(Arrays.toString(bag2.toArray()));
		System.out.println("Expected: \n[Z]");
		System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
	} // end main

	// Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
			System.out.print(content[index] + " ");
		} // end for
		System.out.println();

		displayBag(aBag);
	} // end testAdd

	// Tests the two remove methods.
	private static void testRemove(BagInterface<String> aBag, String[] tests)
	{
		for (int index = 0; index < tests.length; index++)
		{
			String aString = tests[index];
			if (aString.equals("") || (aString == null))
			{
				// test remove()
				System.out.println("\nRemoving a string from the bag:");
				String removedString = aBag.remove();
				System.out.println("remove() returns " + removedString);
			}
			else
			{
				// test remove(aString)
				System.out.println("\nRemoving \"" + aString + "\" from the bag:");
				boolean result = aBag.remove(aString);
				System.out.println("remove(\"" + aString + "\") returns " + result);
			} // end if

			displayBag(aBag);
		} // end for
	} // end testRemove

	// Tests the method isEmpty.
	// correctResult indicates what isEmpty should return.   
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult)
	{
		System.out.print("Testing isEmpty with ");
		if (correctResult)
			System.out.println("an empty bag:");
		else
			System.out.println("a bag that is not empty:");

		System.out.print("isEmpty finds the bag ");
		if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
		System.out.println();
	} // end testIsEmpty

	// Tests the method getFrequencyOf.
	private static void testFrequency(BagInterface<String> aBag, String[] tests)
	{
		System.out.println("\nTesting the method getFrequencyOf:");
		for (int index = 0; index < tests.length; index++)
			System.out.println("In this bag, the count of " + tests[index] + 
					" is " + aBag.getFrequencyOf(tests[index]));
	} // end testFrequency

	// Tests the method contains.
	private static void testContains(BagInterface<String> aBag, String[] tests)
	{
		System.out.println("\nTesting the method contains:");
		for (int index = 0; index < tests.length; index++)
			System.out.println("Does this bag contain " + tests[index] + 
					"? " + aBag.contains(tests[index]));
	} // end testContains

	// Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
				" string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for

		System.out.println();
	} // end displayBag
}
