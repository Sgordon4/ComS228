package edu.iastate.cs228.hw05;

/**
 * 
 * @author
 * Sean Gordon
 * 
 * NOTE:
 * 0. Put your Firstname and Lastname after above author tag.
 * 			Make sure that in both cases the first letter is uppercase
 *    and all others are lowercase.
 * 1. In all of these methods implementations you are allowed
 *    to use the StringBuilder class. 
 * 2. You are allowed to create and use your own private helper methods.
 * 3. No data fields can be introduced.
 * 4. No custom classes of your own can be introduced or used.
 * 5. Import statements are not allowed.
 * 6. Fully qualified class names usage is not allowed.
 * 7. You are allowed to reuse any part of the source codes provided
 *    or shown under lecture notes.
 * 
 */


public class SortingExercises
{
	/**
	 * Recursive implementation of selection sort.
	 * 
	 * @param arr Array of ints to be sorted in nondecreasing order.
	 */
	public static void selectionSort_Rec(int[] arr)
	{
		if(arr == null) throw new NullPointerException();
		if(arr.length == 0) throw new IllegalArgumentException();
		if(arr.length == 1) return;

		nicerSelectionSort_Rec(arr, 0);
	}
	/**
	 * Selection sort, but with an index parameter to keep track of current position.
	 * 
	 * @param arr Array of ints to be sorted in nondecreasing order.
	 * @param index Current position to check in array.
	 */
	public static void nicerSelectionSort_Rec(int[] arr, int index) {

		int min = index;
		for(int i = index+1; i < arr.length; i++) {
			if(arr[i] < arr[min])
				min = i;
		}

		int temp = arr[min];
		arr[min] = arr[index];
		arr[index] = temp;

		if(index+1 < arr.length)
			nicerSelectionSort_Rec(arr, index + 1);
	}

	/**
	 * Recursive implementation of insertion sort.
	 * 
	 * @param arr Array of ints to be sorted in nondecreasing order.
	 */
	public static void insertionSort_Rec(int[] arr)
	{
		if(arr == null) throw new NullPointerException();
		if(arr.length == 0) throw new IllegalArgumentException();
		if(arr.length == 1) return;

		nicerInsertionSort_Rec(arr, arr.length);
	}
	/**
	 * Insertion sort, but with an index parameter to keep track of current position.
	 * 
	 * @param arr Array of ints to be sorted in nondecreasing order.
	 * @param n Current position to check in array.
	 */
	public static void nicerInsertionSort_Rec(int[] arr, int n) {
		if(n <= 1) return;

		nicerInsertionSort_Rec(arr, n - 1);

		int i;
		int temp = arr[n-1];
		for(i = n-2; i >= 0 && arr[i] > temp; i--) 
			arr[i+1] = arr[i];

		arr[i+1] = temp;
	}

	/**
	 * Iterative implementation of selection sort with modifications as follows.
	 * On each pass in this case the method finds both the largest and smallest
	 * values in the unsorted portion of the array, and places them in the correct
	 * locations.
	 * 
	 * @param arr Array of ints to be sorted in nondecreasing order.
	 */
	public static void selectionSort_Itr(int[] arr)
	{
		if(arr == null) throw new NullPointerException();
		if(arr.length == 0) throw new IllegalArgumentException();
		if(arr.length == 1) return;

		for(int x = 0; x < arr.length - 1; x++) {

			int min = x;
			for(int y = x+1; y < arr.length; y++) {
				if(arr[y] < arr[min])
					min = y;
			}
			
			int temp = arr[min];
			arr[min] = arr[x];
			arr[x] = temp;
		}
	}

	/**
	 * A bubble sort can sort an array of n entries into ascending order by 
	 * makeing n-1 passes through the array. On each pass, it compares adjacent
	 * entries and swaps them if they are out or order. For example, on the 
	 * first pass, it compares the first and second entries, then the second and
	 * third entries, and so on. At the end of the first pass, the largest entry
	 * is in its proper position at the end of the array. We say that it has bubbled
	 * to its correct spot. Each subsequent pass ignores the entries at the end of
	 * the array, since they are sorted and are larger than any of the remaining
	 * entries. Thus, each pass makes one fewer comparison than the previous pass.
	 * Check the figure under HW05 assignment on Canvas.
	 * 
	 * This method implements bubble sort iteratively.
	 * 
	 * @param arr Array of objects (with specific bounds) to be sorted in nondecreasing order.
	 */
	public static <T extends Comparable<? super T>> void bubbleSort_Itr(T[] arr)
	{
		if(arr == null) throw new NullPointerException();
		if(arr.length == 0) throw new IllegalArgumentException();
		if(arr.length == 1) return;

		T temp;
		for(int x = 0; x < arr.length; x++) {
			
			for(int y = 1; y < arr.length-x; y++) {
				
				if(arr[y-1].compareTo(arr[y]) > 0) {
					temp = arr[y-1];  
                    arr[y-1] = arr[y];  
                    arr[y] = temp;  
				}
			}
		}
	}

	/**
	 * A bubble sort can sort an array of n entries into ascending order by 
	 * makeing n-1 passes through the array. On each pass, it compares adjacent
	 * entries and swaps them if they are out or order. For example, on the 
	 * first pass, it compares the first and second entries, then the second and
	 * third entries, and so on. At the end of the first pass, the largest entry
	 * is in its proper position at the end of the array. We say that it has bubbled
	 * to its correct spot. Each subsequent pass ignores the entries at the end of
	 * the array, since they are sorted and are larger than any of the remaining
	 * entries. Thus, each pass makes one fewer comparison than the previous pass.
	 * Check the figure under HW05 assignment on Canvas.
	 * 
	 * This method implements bubble sort recursively.
	 * 
	 * @param arr Array of ints to be sorted in nondecreasing order.
	 */
	public static void bubbleSort_Rec(int[] arr)
	{
		if(arr == null) throw new NullPointerException();
		if(arr.length == 0) throw new IllegalArgumentException();
		if(arr.length == 1) return;

		nicerBubbleSort_Rec(arr, arr.length);
	} 
	/**
	 * Bubble sort, but with an index parameter to keep track of current position.
	 * 
	 * @param arr Array of ints to be sorted in nondecreasing order.
	 * @param index Current position to check in array.
	 */
	public static void nicerBubbleSort_Rec(int[] arr, int index) {
		if(index == 1) return;
		
		int temp;
		for(int i = 0; i < index-1; i++) {
			
			if(arr[i] > arr[i+1]) {
				temp = arr[i];  
                arr[i] = arr[i+1];  
                arr[i+1] = temp;  
			}
		}
		
		nicerBubbleSort_Rec(arr, index-1);
	}

}
