package edu.iastate.cs228.hw07;


/**
 * 
 * @author Sean Gordon
 * 
 * NOTE:
 * 
 * 0. Put your Firstname and Lastname after above author tag.
 * 			Make sure that in both cases the first letter is uppercase
 *    and all others are lowercase.
 * 1. You are allowed to create and use your own private helper methods.
 *    If you are introducing your own helper methods those need to be
 *    private and properly documented as per Javadoc style.
 * 2. No data fields can be introduced.
 * 3. No custom classes of your own can be introduced or used.
 * 4. Import statements are not allowed.
 * 5. Fully qualified class names usage is not allowed.
 * 	  Except the ones that are already provided to you.
 * 6. You are allowed to reuse any part of the provided source codes
 *    or shown under lecture notes, which do not violate any of above.
 * 7. If you have any additional questions please ask on Piazza Q/A
 *    platform, but first PLEASE search and make sure that it was not
 *    already asked and answered. PLEASE setup your notifications for 
 *    both Canvas and Piazza so that you are updated whenever there
 *    are any changes immediately.
 *    
 * 
 * 8. You need to answer the questions below for each method.     
 * 
 */


public class SearchingExercises
{
	/**
	 * Assume you are given an array of Integer values sorted in strictly
	 * increasing order, and a List of unsorted Integer values. Your task in 
	 * this method is to find the minimal interval, i.e., to compute the 
	 * smallest range, of array indices that contains all of the target values 
	 * in a given List givenValues. If the value in givenValues is smaller than 
	 * sortedArr[0], then it means that range will start at -1. If the value in 
	 * givenValue is larger than sortedArr[sortedArray.length-1], then it means 
	 * that range will end at sortedArray.length.
	 * 
	 * For example, if the givenValue is composed of [8, 2, 9, 17], and the
	 * sortedArr is composed of {5, 8, 10, 13, 15, 20, 22, 26}, the range
	 * returned would be {-1, 5}.
	 *
	 * 
	 * QUESTION: Assuming sortedArr has m elements and givenValues has n values, 
	 * what is the Big Oh performance of your algorithm?
	 * 
	 * ANSWER:
	 * The function performance is O(n), as there is one for loop with worst case o(n), and two modified
	 * binary searches with worst case O(log n), leaving the for loop to overpower the two binary searches
	 * and result in a time complexity of O(n)	
	 * 
	 * NOTE: Brief description is required as part of your answer.
	 * 
	 * @param sortedArr an array of Integers sorted in strictly increasing order. At least one element will be present. No null.
	 * @param givenValues a List of unsorted Integer values. At least one element will be present. No null.
	 * @return a two element array of Integers indicating mininmal lower and upper
	 * bounds (indices) in sortedArr which would include all List values. 
	 */
	public static Integer[] findMinInterval(Integer[] sortedArr, java.util.List<Integer> givenValues)
	{
		Integer min = givenValues.get(0); 
		Integer max = min;
		for(int i = 0; i < givenValues.size(); i++) {		//Find min and max in givenValues
			if(givenValues.get(i).compareTo(min) < 0)
				min = givenValues.get(i);
			if(givenValues.get(i).compareTo(max) > 0)
				max = givenValues.get(i);
		}

		int minIndex = binarySearch(sortedArr, min, false);
		int maxIndex = binarySearch(sortedArr, max, true);
		
		return new Integer[]{minIndex, maxIndex};
	}

	/**
	 * 
	 * @param arr	Sorted array used to find nearest index
	 * @param x		Value to find nearest index for
	 * @return		Index of value closest to specified value
	 */
	private static int binarySearch(Integer arr[], Integer x, boolean max) {
		if(x.compareTo(arr[0]) < 0)
			return -1;
		else if(x.compareTo(arr[arr.length-1]) > 0)
			return arr.length-1;
		
		int l = 0;
		int r = arr.length - 1;
		int m;
		
		while (l <= r)
		{
			m = (l + r) / 2; 	//Find midpoint

			if(x.compareTo(arr[m]) < 0)
				r = m-1;
			
			else if(x.compareTo(arr[m]) > 0)
				l = m+1;
			
			else
				return m;
		}

		//If element is not in list, return nearest 
		if((arr[l] - x) < (x - arr[r]))
			return l;
		if(max)				//Could have done this another way but this is easier
			return r+1;
		return r;
		
		//[8, 2, 9, 17], {5, 8, 10, 13, 15, 20, 22, 26}
	}


	/**
	 * Assume that you are given a two-dimensional array with Comparable
	 * items stored in it. For example, consider the following 3 by 4
	 * two-dimensional array
	 * 
	 *  1,   4,  55,  88
	 *  7,  15,  61,  91
	 * 14,  89,  90,  99
	 * 
	 * Values in each row and column of this two-dimensional array are
	 * always come sorted in strictly increasing order. 
	 * 
	 * Our method find2D needs to inform the user whether the the 
	 * user searched key exists in this two-dimensional array or not.
	 * You can assume that two-dimensional array will have at least one
	 * element in it.
	 *  
	 * 
	 * QUESTION: Assuming arr has m rows and n columns, what is the 
	 * Big Oh performance of your algorithm?
	 * 
	 * ANSWER:
	 * The function time complexity is O(n^2), as there are two for loops, one nested inside the other,
	 * and as I didn't have the time to spend creating a more efficient algorithm, both loops are of 
	 * complexity O(n)
	 * 
	 * 
	 * NOTE: Brief description is required as part of your answer.
	 * 
	 * @param arr two-dimensional array of Comparable objects.
	 *        At least will have a single element. No null values.	
	 * @param key searched Comparable object. Not null.
	 * @return indication of whether key exists in arr or not.
	 *  
	 */
	public static <T extends Comparable<? super T>> boolean find2D(T[][] arr, T key)
	{
		if(key.compareTo(arr[0][0]) < 0 || key.compareTo(arr[arr.length-1][arr[0].length-1]) > 0)
			return false;
		
		int i, j;		//Going brute force here
		for(i = 0; i < arr.length; i++) {
			for(j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == key)
					return true;
			}
		}
		return false;
	}
}
