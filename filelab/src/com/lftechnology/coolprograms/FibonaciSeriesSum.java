/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
 * By starting with 1 and 2, the first 10 terms will be:
1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
package com.lftechnology.coolprograms;

import java.util.logging.Logger;

/**
 * This class adds the even numbered terms of fibonacci series
 * @author nimesh
 */
public class FibonaciSeriesSum {
	private static final Logger LOG=Logger.getLogger(FibonaciSeriesSum.class.getName());
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Running main method");
		int a=1;
		int b=2;
		int c=0;
		int sum=2;
		LOG.info(""+a);
		LOG.info(""+b);
		do{
			c=a+b;
			a=b;
			b=c;
			LOG.info(""+c);
			if(c%2==0){
				sum+=c;
			}
		}while(c<=4000000);
		LOG.info("The sum is :"+sum);
	}

}