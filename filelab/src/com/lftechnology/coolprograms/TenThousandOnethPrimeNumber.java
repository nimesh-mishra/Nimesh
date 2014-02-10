package com.lftechnology.coolprograms;

import java.util.logging.Logger;

/**
 * What is the 10 001st prime number?
 */
/**
 * This class finds the 10001st prime number
 * @author nimesh
 */
public class TenThousandOnethPrimeNumber {
	private static final Logger LOG=Logger.getLogger(SumSquareDifference.class.getName());
	/**
	 * Main class
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main function");
		int flag=0;
		int startNumber=0;
		while(flag!=10001){
			if(checkPrime(startNumber)){
				flag++;
			}
			if(flag==10001){
				break;
			}
			startNumber++;
		}
		LOG.info("The 10001st prime number is : "+(startNumber));
	}
	
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
		int maxDivisor=(int)Math.sqrt(number);
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
