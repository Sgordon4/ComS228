package edu.iastate.cs228.hw03;

/**
 * 
 * @author
 * Sean Gordon
 * 
 */
public class HW03_Part2
{
	/*
	 * Answers to short questions:
	 * 
	 * 1. O(n)
	 * 
	 * 2. O(log(n))
	 * 
	 * 3. O(n^3)
	 * 
	 * 4. O(n^2)
	 * 
	 * 5. O(n^2)
	 * 
	 */

	/*
	 In all of the following methods you can assume that
	 array will always have elements (ints) in it.
	 And will have proper integers as defined in the 
	 description of HW03, i.e., in first two it will be
	 in the range, and in last two it will be composed of
	 negative and positive values only.
	 */

	public static int findMissingInt_a_On2(int [] array)
	{
		int n = array.length;
		int missing = -1;

		for(int count = 1; count <= n+1; count++) {		//Entirely redundant count loop
			missing = count;
			for(int i = 0; i < n; i++) {
				if(array[i] == count) {
					missing = -1;
					break;
				}
			}
			if(missing != -1)
				break;
		}

		return missing;
	}

	public static int findMissingInt_b_On1(int [] array)
	{
		int n = array.length;
		int total = ((n+1) * (n+2))/2;		//Finds total if all numbers were present

		for(int i = 0; i < n; i++) {
			total -= array[i];		//Finds missing number by subtracting all present numbers
		}							//from the expected total 
		return total;
	}

	public static void rearrange_a_On2(int [] array)
	{
		//Just using insertion sort
		int temp;

		for(int x = 1; x < array.length; x++) {
			for(int y = x; y > 0; y--) {
				if(array[y] < array[y-1]) {
					temp = array[y];
					array[y] = array[y-1];
					array[y-1] = temp;
				}
			}
		}
	}

	public static void rearrange_b_On1(int [] array)
	{
		int y = 0, temp;
		for (int x = 0; x < array.length; x++)
		{
			if (array[x] < 0)
			{
				temp = array[x];
				array[x] = array[y];
				array[y] = temp;
				y++;
			}
		}
	}

}