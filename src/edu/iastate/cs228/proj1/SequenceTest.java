package edu.iastate.cs228.proj1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SequenceTest {	//I'm sorry these tests look like garbage and are not compartmentalized

	@Test
	public void testSequence() {
		
		
		try {
			String probst = new String("TAG");
			Sequence seqobj = new Sequence(probst.toCharArray()); //Should work
		}catch(IllegalArgumentException anIllegalArgumentException) {
			fail("Should not have thrown an exception");
		}
		
		try {
			String probst2 = new String("T$G");
			Sequence seqobj2 = new Sequence(probst2.toCharArray()); //Should not work
			fail("Should have thrown an exception");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Invalid sequence letter for class " + Sequence.class));
		}
	}

	@Test
	public void testSeqLength() {
		String probst = new String("TCGAGT");
		Sequence seqobj = new Sequence(probst.toCharArray()); 
		assertEquals(seqobj.seqLength(), 6);
		
		String probst2 = new String("GCTAGTCGA");
		Sequence seqobj2 = new Sequence(probst2.toCharArray()); 
		assertEquals(seqobj2.seqLength(), 9);
	}

	@Test
	public void testGetSeq() {
		String probst = new String("TCGAGT");
		Sequence seqobj = new Sequence(probst.toCharArray()); 
		
		assertArrayEquals(probst.toCharArray(), seqobj.getSeq());
	}

	@Test
	public void testToString() {
		String probst = new String("TCGAGT");
		Sequence seqobj = new Sequence(probst.toCharArray());
		
		assertEquals(probst, seqobj.toString());
	}

	@Test
	public void testEqualsObject() {
		String probst = new String("TCGAGT");
		Sequence seqobj = new Sequence(probst.toCharArray());
		
		String probst2 = new String("TCGAGT");
		Sequence seqobj2 = new Sequence(probst2.toCharArray());
		
		assertTrue(seqobj.equals(seqobj2));
	}

	@Test
	public void testIsValidLetter() {
		String probst = new String("TCGAGT");
		Sequence seqobj = new Sequence(probst.toCharArray());
		
		assertTrue(seqobj.isValidLetter('a'));
		
		try{//Wont work
			seqobj.isValidLetter('$');
		}
		catch(IllegalArgumentException anIllegalArgumentException){
			assertThat(anIllegalArgumentException.getMessage(), is("Invalid sequence letter for class " + seqobj.getClass()));
		}
	}
}
