package com.lftechnology.practicequestions;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 1. Search for a specific value in an array.
 */
/**
 * This class finds the specific value in array. 
 * It does this by comparing the value with every element in the array.
 * 
 * @author nimesh
 */
public class SearchValue {
	private static final Logger LOG = Logger.getLogger(SearchValue.class
			.getName());

	/**
	 * Main method
	 * 
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into Main method");
		Scanner scan = new Scanner(System.in);
		int[] arrayOfValue = new int[100];
		boolean found = false;
		for (int i = 0; i < arrayOfValue.length; i++) {
			arrayOfValue[i] = (i + 1);
		}
		LOG.info("Enter the value to be searched [1-100]: ");
		int choice = scan.nextInt();
		for (int i = 0; i < arrayOfValue.length; i++) {
			if (arrayOfValue[i] == choice) {
				found = true;
				LOG.info("Value found at index : " + i);
				break;
			}
		}
		if (!found) {
			LOG.info("Value not found");
		}

	}

}
