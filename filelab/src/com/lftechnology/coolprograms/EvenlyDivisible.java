package com.lftechnology.coolprograms;

import java.util.logging.Logger;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
/**
 * This class finds the smallest number that is divisible by all numbers from 1-20.
 * @author nimesh
 * 
 */
public class EvenlyDivisible {
	private static final Logger LOG=Logger.getLogger(EvenlyDivisible.class.getName());
	public static void main(String[] args) {
		LOG.info("Into main class");
		int startingNumber=2520;
		int flag=0;
		while(flag!=20){
			LOG.info(""+startingNumber);
			for(int i=1;i<20;i++){
				if(startingNumber%i==0){
					flag++;
				}
			}
			if(flag!=20){
				flag=0;
				startingNumber+=1;
			}
		}
		LOG.info("The smallest number is : "+startingNumber);
	}

}
