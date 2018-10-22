package edu.iastate.cs228.proj2;

import java.util.Comparator;

/**
*
* @author Sean Gordon
*
*/

public class LexiconImpl implements Lexicon, Comparator<String> {

	/***
	 * Lookup table mapping characters in lexicographical order to
	 * to their input order. This is public to support automated grading. 
	 */
	public CharacterValue[] characterOrdering; 

	/***
	 * Creates an array of CharacterValue from characterOrdering.  Sorts
	 * it using java.util.Arrays.sort().
	 * @param characterOrdering character order from configuration file
	 */	
	public LexiconImpl(char[] characterOrdering) {
		this.characterOrdering = new CharacterValue[characterOrdering.length];

		for(int i = 0; i < characterOrdering.length; i++) {
			this.characterOrdering[i] = new CharacterValue(i, characterOrdering[i]);
		}

		java.util.Arrays.sort(this.characterOrdering, new CharacterValueSort());
	}
	/***
	 * Helper class, compares two CharacterValues
	 * @param first CharacterValue
	 * @param second CharacterValue
	 * @return negative if a<b, 0 if equal, postive if a>b
	 */
	class CharacterValueSort implements Comparator<CharacterValue>{
		public int compare(CharacterValue a, CharacterValue b) 
		{ 
			return Character.compare(a.character, b.character);
		} 
	}


	/***
	 * Compares two words based on the configuration
	 * @param a first word
	 * @param b second word
	 * @return negative if a<b, 0 if equal, postive if a>b
	 */
	@Override
	public int compare(String a, String b) {
		int min = Math.min(a.length(), b.length());	//Prevent out of bounds error
		int char1=0, char2=0;						//Temp ints for comparing char indicies

		for(int i = 0; i < min; i++) {
			char1 = getCharacterOrdering(a.charAt(i));
			char2 = getCharacterOrdering(b.charAt(i));

			//Efficiency is escaping me atm...
			if(char1 == char2)
				continue;
			else if(char1 > char2) {
				return 1;
			}
			else if(char1 < char2) {
				return -1;
			}
		}

		//Efficiency is escaping me atm...
		if(a.length() != b.length()) {
			if(min == a.length())		//Means String b is larger
				return -1;
			else 
				return 1;
		}
		return 0;
	}

	/**
	 * Uses binary search to find the order of key.
	 * @param key
	 * @return ordering value for key or -1 if key is an invalid character.
	 */
	public int getCharacterOrdering(char key) {

		int l = 0, r = characterOrdering.length - 1; 
		int m;
		while (l <= r) 
		{ 
			m = l + (r-l)/2; 

			// Check if x is present at mid 
			if (Character.compare(characterOrdering[m].character, key) == 0) 
				return characterOrdering[m].value; 

			// If x greater, ignore left half 
			if (Character.compare(characterOrdering[m].character, key) < 0) 
				l = m + 1; 

			// If x is smaller, ignore right half 
			else
				r = m - 1; 
		} 

		return -1; 

	}

	public static class CharacterValue {
		public int value;
		public char character;

		public CharacterValue(int value, char character) {
			this.value = value;
			this.character = character;
		}

		public boolean equals(Object o) {
			if (o == null || o.getClass() != this.getClass()) {
				return false;
			}
			CharacterValue other = (CharacterValue) o;
			return value == other.value && character == other.character;
		}
	}

	/**
	 * Returns whether or not word is valid according to the alphabet
	 * known to this lexicon. 
	 * 
	 * @param word word to be checked.
	 *
	 * @return true if valid. false otherwise
	 */
	public boolean isValid(String word) {

		if(word.length() < 1) {
			return false;
		}

		String alphabet = "";

		//Can't do a simple toString because CharacterValue doesn't have one
		//Need to grab each char value with a for loop
		for(int i = 0; i < characterOrdering.length; i++) {
			alphabet += characterOrdering[i].character;
		}

		for(int i = 0; i < word.length(); i++) {
			String wordChar = "" + word.charAt(i);
			if(!alphabet.contains(wordChar)) {
				return false;
			}
		}

		return true; 

	}

}
