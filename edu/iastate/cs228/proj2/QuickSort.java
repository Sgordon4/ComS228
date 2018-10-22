package edu.iastate.cs228.proj2;

import java.util.Comparator;

/**
*
* @author Sean Gordon
*
*/

public class QuickSort extends SorterWithStatistics {

	//This method will be called by the base class sort() method to 
	// actually perform the sort. 
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
		quickSort(words, 0, words.length-1, comp);
	}
	
	void quickSort(String[] arr, int low, int high, Comparator<String> comp) {
		if (low < high) 
        { 
            //Set correct partition
            int part = partition(arr, low, high, comp); 
  
            quickSort(arr, low, part-1, comp); 
            quickSort(arr, part+1, high, comp); 
        } 
	}
	int partition(String[] arr, int low, int high, Comparator<String> comp) {
		String pivot = arr[high];  
        int i = low-1;
        
        for (int j = low; j < high; j++) 
        { 
        	//Is arr[j] smaller than pivot
            if (comp.compare(arr[j], pivot) <= 0) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                String temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        String temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
	}
}
