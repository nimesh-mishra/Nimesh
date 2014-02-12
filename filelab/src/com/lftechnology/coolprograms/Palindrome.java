package com.lftechnology.coolprograms;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
 */
/**
 * This class finds the largest palindrome of product of  three digit number
 * @author nimesh
 */
public class Palindrome {
	private static final Logger LOG=Logger.getLogger(Palindrome.class.getName());
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Entered Main function");	
		 int value = 0;
	        for(int i = 100;i <=999;i++)
	        {
	            for(int j = i;j <=999;j++)
	            {
	                int value1 = i * j;
	                StringBuilder sb1 = new StringBuilder(""+value1);
	                String sb2 = ""+value1;
	                sb1.reverse();
	                if(sb2.equals(sb1.toString()) && value<value1) {
	                    value = value1;

	                }

	            }
	        }

	        System.out.println(value);
	}

}
