package com.lftechnology.coolprograms;

import java.util.logging.Logger;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

 a^2 + b^2 = c^2
 For example, 32 + 42 = 9 + 16 = 25 = 52.

 There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 Find the product abc.
 */
/**
 * This class finds the value of abc.
 * 
 * @author nimesh
 * 
 */
public class PythagoreanTriplets {
	private static final Logger LOG = Logger
			.getLogger(ProductOfFiveDigits.class.getName());

	/**
	 * Main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main");
		int a = 0;
		int b = 0;
		int c = 0;
		int sum=1000;
		boolean solved=false;
		for(a=1;a<500 && !solved;a++){
			for(b=1;b<500 && !solved;b++){
				c=sum-a-b;
				if((a*a)+(b*b)==c*c){
					solved=true;
					LOG.info("The numbers are "+a+" "+b+" "+c+" "+"and the product is : "+(a*b*c));
				}
			}
		}
		
		}
	}

