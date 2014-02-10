package com.lftechnology.coolprograms;

import java.util.logging.Logger;
/**
 * Find the sum of all the primes below two million.
 */
/**
 * This class finds the sum of all prime numbers between two million
 * @author nimesh
 *
 */
public class SumOfPrime {
	private static final Logger LOG = Logger
			.getLogger(ProductOfFiveDigits.class.getName());
	/**
	 * Main class
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main");
		long sumOfPrime=0;
		long number=2000000L;
		for(int i=2;i<number;i++){
				if(checkPrime(i)){
					sumOfPrime+=i;
				}
		}
		LOG.info("The sum is : "+sumOfPrime);
	}
	/**
	 * This function checks whether or not the number is prime
	 * @param number {@link Integer} The number to be checked
	 * @return True if number is prime otherwise false
	 */
	private static boolean checkPrime(int number){
		LOG.info("Into checkPrime function");
		if(number<2){
			return false;
		}
		if(number==2){
			return true;
		}
		else if (number==3){
			return true;
		}
		if(number%2==0){
			return false;
		}
		else if(number%3==0){
			return false;
		}
		int maxDivisor=(int)Math.round(Math.sqrt(number));
		int divisor=5;
		while(divisor<=maxDivisor){
			if(number%divisor==0 || number%(divisor+2)==0){
				return false;
			}
			divisor+=6;
		}
		return true;
	}
}
