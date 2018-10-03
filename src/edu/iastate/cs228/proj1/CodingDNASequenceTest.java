package edu.iastate.cs228.proj1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CodingDNASequenceTest {

	@Test
	public void testCodingDNASequence() {
		try {
			String probst = new String("AATGCCAGTCAGCATAGCGTAGACT");
			CodingDNASequence seqobj = new CodingDNASequence(probst.toCharArray()); 
		}catch(IllegalArgumentException anIllegalArgumentException) {
			fail("Should not have thrown an exception");
		}
		
		try {
			String probst = new String("A$TGCCAGTCAGCATAGCGTAGACT");
			CodingDNASequence seqobj = new CodingDNASequence(probst.toCharArray());
			fail("Should have thrown an exception");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Invalid sequence letter for class " + CodingDNASequence.class));
		}
	}

	@Test
	public void testCheckStartCodon() {
		String probst = new String("ATG");
		CodingDNASequence seqobj = new CodingDNASequence(probst.toCharArray());
		assertTrue(seqobj.checkStartCodon());
		
		String probst2 = new String("AAA");
		CodingDNASequence seqobj2 = new CodingDNASequence(probst2.toCharArray());
		assertFalse(seqobj2.checkStartCodon());
	}

	@Test
	public void testTranslate() {
	    String probst = new String("ATGCCGCCACCGCTGCACGTCGTCTACGAAACTCAGA");
		CodingDNASequence seqobj = new CodingDNASequence(probst.toCharArray());
		
		assertArrayEquals("MPPPLHVVYET".toCharArray(), seqobj.translate());
	}
}
