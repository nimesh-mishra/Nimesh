package com.lftechnology.coolprograms;

import java.util.logging.Logger;

/**
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
/**
 * This class finds the difference between the sum of square of first one hundred natural numbers 
 * and the squrae of sum of first hundred natural numbers.
 * @author nimesh
 */
public class SumSquareDifference {
	private static final Logger LOG=Logger.getLogger(SumSquareDifference.class.getName());
	/**
	 * This is main class
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main class");
		int sumOfSquares=0;
		int squareOfSum=0;
		int sumOfNaturalNumers=0;
		for(int i=0;i<=100;i++){
			sumOfSquares+=i*i;
			sumOfNaturalNumers+=i;
		}
		LOG.info("The difference is : "+ (int)(Math.pow(sumOfNaturalNumers, 2)-sumOfSquares));
	}

}
