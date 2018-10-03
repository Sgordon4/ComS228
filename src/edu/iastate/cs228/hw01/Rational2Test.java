package edu.iastate.cs228.hw01;

import java.math.BigInteger;

public class Rational2Test {
	public static void main(String[] args) {
		Rational2 rational2_1 = new Rational2();
		Rational2 rational2_2 = new Rational2(new BigInteger("8"), new BigInteger("18"));
		
		System.out.println(rational2_1.getNumerator());
		System.out.println(rational2_2.getDenominator());
		
		System.out.println(rational2_1.add(rational2_2));
		System.out.println(rational2_1.subtract(rational2_2));
		System.out.println(rational2_2.multiply(rational2_2));
		System.out.println(rational2_2.divide(rational2_2));
		
		System.out.println(rational2_1.equals(rational2_2));
		System.out.println(rational2_2.equals(rational2_2));
		
		System.out.println(rational2_2.intValue());
		System.out.println(rational2_2.floatValue());
		System.out.println(rational2_2.doubleValue());
		System.out.println(rational2_2.longValue());
		
		System.out.println(rational2_1.compareTo(rational2_2));
	}
}
