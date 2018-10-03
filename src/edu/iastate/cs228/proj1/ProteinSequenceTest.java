package edu.iastate.cs228.proj1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProteinSequenceTest {

	@Test
	public void testIsValidLetter() {
		String probst = new String("AATGCCAGTCAGCATAGCGTAGACT");
		ProteinSequence seqobj = new ProteinSequence(probst.toCharArray());
		
		assertTrue(seqobj.isValidLetter('a'));
		assertFalse(seqobj.isValidLetter('b'));
	}

	@Test
	public void testProteinSequence() {
		try {
			String probst = new String("AATGCCAGTCAGCATAGCGTAGACT");
			ProteinSequence seqobj = new ProteinSequence(probst.toCharArray()); 
		}catch(IllegalArgumentException anIllegalArgumentException) {
			fail("Should not have thrown an exception");
		}
		
		try {
			String probst = new String("A$TGCCAGTCAGCATAGCGTAGACT");
			ProteinSequence seqobj = new ProteinSequence(probst.toCharArray());
			fail("Should have thrown an exception");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Invalid sequence letter for class " + ProteinSequence.class));
		}
	}
}
