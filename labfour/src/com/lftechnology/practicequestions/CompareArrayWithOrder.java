package com.lftechnology.practicequestions;

import java.util.logging.Logger;

/**
 * 2. Compare if two arrays have the same content ( in the same order)
 */
/**
 * This class compares two arrays, in same order
 * 
 * @author nimesh
 */
public class CompareArrayWithOrder {
	private static final Logger LOG = Logger
			.getLogger(CompareArrayWithOrder.class.getName());

	/**
	 * main class
	 * 
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into Main method");
		int[] arrayOne = new int[100];
		int[] arrayTwo = new int[100];
		int flag = 0;
		for (int i = 0; i < arrayOne.length; i++) {
			arrayOne[i] = (i + 1);
		}
		for (int i = 0; i < arrayTwo.length; i++) {
			arrayTwo[i] = (i + 1);
		}
		for (int i = 0; i < arrayOne.length; i++) {
			if (arrayOne[i] == arrayTwo[i]) {
				flag++;
			}
		}
		if (flag == arrayOne.length) {
			LOG.info("Arrays have same content in same order");
		} else {
			LOG.info("Arrays do not have same content in same order");
		}
	}

}
