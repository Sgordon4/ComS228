package ModifiedQueuesForTesting;

import edu.iastate.cs228.hw04.RecursionExercises;

public class RecursiveTesting {
	public static void main(String[] args) {
		System.out.println(RecursionExercises.displayRowOfCharacters('+', 5));
		System.out.println();
		
		System.out.println(RecursionExercises.displayBackwards(new int[]{1,2,3,4}, 2));
		System.out.println();
		
		System.out.println(RecursionExercises.isPalindrome("deed"));
		System.out.println(RecursionExercises.isPalindrome("racecar"));
		System.out.println(RecursionExercises.isPalindrome("notAPalindrome"));
		System.out.println();
		
		System.out.println(RecursionExercises.getSecondSmallest(new Integer[]{-1,10,3,2},4));
		System.out.println(RecursionExercises.getSecondSmallest(new Integer[]{17,18,3,2},4));
		System.out.println(RecursionExercises.getSecondSmallest(new Integer[]{3,3,3,3},4));
		System.out.println(RecursionExercises.getSecondSmallest(new Integer[]{1,2},2));
	}
}
