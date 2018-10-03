package edu.iastate.cs228.proj1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class DNASequenceTest {

	@Test
	public void testIsValidLetter() {
		String probst = new String("TAG");
		DNASequence seqobj = new DNASequence(probst.toCharArray()); 
		
		assertTrue(seqobj.isValidLetter('A'));
		assertFalse(seqobj.isValidLetter('$'));
	}
	
	@Test
	public void testGenomicDNASequenceNoException() {
		try {
			String probst = new String("TAG");
			DNASequence seqobj = new DNASequence(probst.toCharArray()); 
		}catch(IllegalArgumentException anIllegalArgumentException) {
			fail("Should not have thrown an exception");
		}
		
		try {
			String probst2 = new String("T$G");
			DNASequence seqobj2 = new DNASequence(probst2.toCharArray());
			fail("Should have thrown an exception");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Invalid sequence letter for class " + DNASequence.class));
		}
	}
}
