package com.lftechnology.practicequestions;
import java.util.logging.Logger;

/**
 * 2. Compare if two arrays have the same content (not in the same order)
 */
/**
 * This class compares two arrays without paying any attention to order
 * @author nimesh
 */
public class CompareArrays {
	private static final Logger LOG = Logger.getLogger(CompareArrays.class
			.getName());

	/**
	 * main class
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
			for (int j = 0; j < arrayTwo.length; j++) {
				if (arrayOne[i] == arrayTwo[j]) {
					flag++;
				}
			}
		}
		if (flag == arrayOne.length) {
			LOG.info("Arrays have same content ");
		} else {
			LOG.info("Arrays do not have same content");
		}
	}

}
