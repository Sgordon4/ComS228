package edu.iastate.cs228.proj1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GenomicDNASequenceTest {

	@Test
	public void testGenomicDNASequenceNoException() {
		try {
			String probst = new String("AATGCCAGTCAGCATAGCGTAGACT");
			GenomicDNASequence seqobj = new GenomicDNASequence(probst.toCharArray()); 
		}catch(IllegalArgumentException anIllegalArgumentException) {
			fail("Should not have thrown an exception");
		}
		
		try {
			String probst2 = new String("$ATGCCAGTCAGCATAGCGTAGACT");
			GenomicDNASequence seqobj2 = new GenomicDNASequence(probst2.toCharArray());
			fail("Should have thrown an exception");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Invalid sequence letter for class " + GenomicDNASequence.class));
		}
	}

	@Test
	public void testMarkCoding() {
		String probst = new String("AATGCCAGTCAGCATAGCGTAGACT");
		GenomicDNASequence seqobj = new GenomicDNASequence(probst.toCharArray());
		
		try {
			seqobj.markCoding(5, 10);
		}catch(IllegalArgumentException anIllegalArgumentException) {
			fail("I dislike Junit");
		}
		
		
		try {
			seqobj.markCoding(5, 100);	//Should throw exception
			fail("Should have thrown IllegalArgumentException");
			fail("Print testing is the only true way");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Coding border is out of bound"));
		}
		
		try {
			seqobj.markCoding(15, 10);	//Should throw exception
			fail("Should have thrown IllegalArgumentException");
			fail("Deus vult");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Coding border is out of bound"));
		}
	}

	@Test
	public void testExtractExons() {
		String probst = new String("AATGCCAGTCAGCATAGCGTAGACT");
		GenomicDNASequence seqobj = new GenomicDNASequence(probst.toCharArray());
		
		try {
			seqobj.extractExons(null);
			fail("Should have thrown IllegalArgumentException");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Empty array or odd number of array elements"));
		}
		
		try {
			int[] arr = {-1,1};
			seqobj.extractExons(arr);
			fail("Should have thrown IllegalArgumentException");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Exon position is out of bound"));
		}
		
		try {
			int[] arr = {10,0};
			seqobj.extractExons(arr);
			fail("Should have thrown IllegalArgumentException");
		}catch(IllegalArgumentException anIllegalArgumentException) {
			assertThat(anIllegalArgumentException.getMessage(), is("Exon positions are not in order"));
		}
		
		try {
			int[] arr = {5,6};
			seqobj.extractExons(arr);
			fail("Should have thrown IllegalArgumentException");
		}catch(IllegalStateException anIllegalStateException) {
			assertThat(anIllegalStateException.getMessage(), is("Noncoding position is found"));
		}
		
		try {
			seqobj.markCoding(0, 10);
			int[] arr = {5,8};
			seqobj.extractExons(arr);
		}catch(IllegalArgumentException anIllegalArgumentException) {
			fail("Should NOT have thrown IllegalArgumentException");
		}
	}
}
