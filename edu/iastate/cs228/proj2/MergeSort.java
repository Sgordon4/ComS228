package edu.iastate.cs228.proj2;

import java.util.Comparator;

/**
*
* @author Sean Gordon
*
*/

public class MergeSort extends SorterWithStatistics {
	
	//This method will be called by the base class sort() method to 
	// actually perform the sort. 
	@Override
	public void sortHelper(String[] words, Comparator<String> comp) {
		if(words == null)
			throw new NullPointerException();
		if(words.length == 0) 
			throw new IllegalArgumentException("Words list has no content!");
		if(words.length == 1)
			return;
		
		
		int low = 0;
        int high = words.length - 1;

        String[] temp = new String[words.length];
        for(int i = 0; i < words.length; i++) {		//Deep copy array
        	temp[i] = words[i];
        }

        // divide the array into blocks of size m
        // m = [1, 2, 4, 8, 16...]
        for (int m = 1; m <= high - low; m = 2*m)
        {
            // for m = 1, i = 0, 2, 4, 6, 8...
            // for m = 2, i = 0, 4, 8, 12...
            // for m = 4, i = 0, 8, 16...
            // ...
            for (int i = low; i < high; i += 2*m)
            {
                int from = i;
                int mid = i + m - 1;
                int to = Integer.min(i + 2 * m - 1, high);

                merge(words, temp, from, mid, to, comp);
            }
        }
		
	}
	
	public void merge(String[] A, String[] temp, int from, int mid, int to, Comparator<String> comp)
    {
        int k = from, i = from, j = mid + 1;

        // loop till there are elements in the left and right runs
        while (i <= mid && j <= to) {
            if (comp.compare(A[i], A[i]) < 0) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }

        // Copy remaining elements
        while (i < A.length && i <= mid) {
            temp[k++] = A[i++];
        }

        // Don't need to copy second half

        // copy back to the original array to reflect sorted order
        for (i = from; i <= to; i++) {
            A[i] = temp[i];
        }
    }
}
