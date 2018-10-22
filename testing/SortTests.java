package testing;

import edu.iastate.cs228.hw06.SortingExercise;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class SortTests {
	int[] arr = {5, 8, 6, 4, 9, 3, 7, 1, 2};
	
	@Test
	public void sort9(){
		SortingExercise.modifiedQuickSort(arr);
		assertArrayEquals( new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr );
	}
	
	@Test
	public void sort23(){
		for( int i = 0; i < 10; i++ ) sort(23);
	}
	
	@Test
	public void sort50(){
		for( int i = 0; i < 10; i++ ) sort(50);
	}
	
	@Test
	public void sort100(){
		for( int i = 0; i < 10; i++ ) sort(100);
	}
	
	private void sort( int num ){
		int[] toSort = new int[ num ];
		for( int i = 0; i < num; i++ ){
			toSort[i] = (int)(Math.random() * 100 );
		}
		int[] expected = Arrays.copyOf( toSort, num );
		
		SortingExercise.modifiedQuickSort( toSort );
		Arrays.sort( expected );
		
		assertArrayEquals( expected, toSort );
	}
}