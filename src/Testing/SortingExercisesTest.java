package Testing;

import java.util.Arrays;

import edu.iastate.cs228.hw05.SortingExercises;

public class SortingExercisesTest {
	public static void main(String[] args) {
		
		int[] oOf = {1, 14, 7, 6, 8, 19};
		System.out.println("Pre-sort:  " + Arrays.toString(oOf));
		SortingExercises.selectionSort_Rec(oOf);
		System.out.println("Post-sort: " + Arrays.toString(oOf));
		System.out.println();
		
		int[] oOf2 = {1, 14, 7, 6, 8, 19};
		System.out.println("Pre-sort:  " + Arrays.toString(oOf2));
		SortingExercises.insertionSort_Rec(oOf2);
		System.out.println("Post-sort: " + Arrays.toString(oOf2));
		System.out.println();
		
		int[] oOf3 = {1, 14, 7, 6, 8, 19};
		System.out.println("Pre-sort:  " + Arrays.toString(oOf3));
		SortingExercises.selectionSort_Itr(oOf3);
		System.out.println("Post-sort: " + Arrays.toString(oOf3));
		System.out.println();
		
		Integer[] oOf4 = {new Integer(1), new Integer(14), new Integer(7), new Integer(6), new Integer(8), new Integer(19)};
		System.out.println("Pre-sort:  " + Arrays.toString(oOf4));
		SortingExercises.bubbleSort_Itr(oOf4);
		System.out.println("Post-sort: " + Arrays.toString(oOf4));
		System.out.println();
		
		int[] oOf5 = {1, 14, 7, 6, 8, 19};
		System.out.println("Pre-sort:  " + Arrays.toString(oOf5));
		SortingExercises.bubbleSort_Rec(oOf5);
		System.out.println("Post-sort: " + Arrays.toString(oOf5));
		System.out.println();
	}
}
