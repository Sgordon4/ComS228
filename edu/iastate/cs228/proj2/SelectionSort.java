package edu.iastate.cs228.proj2;

import java.util.Comparator;

/**
*
* @author Sean Gordon
*
*/

public class SelectionSort extends SorterWithStatistics {
	
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
		
		System.out.println(java.util.Arrays.toString(words));
		
		String smaller;
		
		for (int i = 0; i < words.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < words.length; j++){  
                if (comp.compare(words[j], words[j]) < 0){  
                    index = j;//searching for lowest index  
                }  
            }  
            smaller = words[index];   
            words[index] = words[i];  
            words[i] = smaller;  
        }  
    }
}
