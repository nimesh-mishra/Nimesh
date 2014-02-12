package com.lftechnology.practicequestions;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
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
		/*int[] arrayOne = new int[100];
		int[] arrayTwo = new int[100];
		Random rand=new Random();
		for (int i = 0; i < arrayOne.length; i++) {
			arrayOne[i] = rand.nextInt(100);
		}
		for (int i = 0; i < arrayTwo.length; i++) {
			arrayTwo[i] =rand.nextInt(100);
		}*/
		int[]arrayOne={2, 6, 6, 6, 2, 2};
		int[]arrayTwo={ 2, 2, 2, 6, 2, 6 };
		int flag = 0;
		List<Integer>indexToSkip=new LinkedList<Integer>();
		if(arrayOne.length==arrayTwo.length){
			for (int i = 0; i < arrayOne.length; i++) {
				for (int j = 0; j < arrayTwo.length; j++) {
					if (arrayOne[i] == arrayTwo[j] && (!indexToSkip.contains(j))) {
						flag++;
						indexToSkip.add(j);
						break;
					}
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
