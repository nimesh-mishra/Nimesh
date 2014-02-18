package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 Evaluate the sum of all the amicable numbers under 10000.
 */
/**
 * This class generates the sum of all the amicable numbers under 10000;
 * 
 * @author nimesh
 * 
 */
public class QuestionTwentyOne {
	private static final Logger LOG = Logger.getLogger(QuestionTwentyOne.class
			.getName());
	private static int amicablePair = 0;
	private static List<Integer> foundPairs = new LinkedList<Integer>();

	/**
	 * This method finds the factor of a given number
	 * 
	 * @param val
	 *            {@link Integer} The value to be factorized.
	 * @return {@link ArrayList}{@link Integer} The array containing all the
	 *         factors.
	 * @author nimesh
	 */
	private static List<Integer> factorsOf(int number) {
		// LOG.info("Into method 'factorsOf'");
		long root = Math.round(Math.sqrt(number)) + 1;

		ArrayList<Integer> listOfFactors = new ArrayList<Integer>();
		listOfFactors.add(1);

		for (int i = 2; i <= root; i++) {
			if (number % i == 0) {
				listOfFactors.add(i); // Add the divisor & its complement
				listOfFactors.add(number / i);
			}
		}
		return listOfFactors;
	}

	/**
	 * This method checks whether a number is amicable or not. If number is
	 * amicable, its pair is pushed into a list so that is not checked again.
	 * 
	 * @param number
	 *            {@link Integer} The number to be checked.
	 * @return {@link Boolean} True if number is amicable. Else false.
	 * @author nimesh
	 */
	private static boolean checkAmicable(int number) {
		// LOG.info("Into method 'checkAmicable'");
		boolean isAmicable = false;
		int tempSumOne = 0;
		int tempSumTwo = 0;
		List<Integer> listOfFactors = new ArrayList<Integer>();
		listOfFactors = factorsOf(number);
		tempSumOne = sumOfFactors(listOfFactors);
		listOfFactors = factorsOf(tempSumOne);
		tempSumTwo = sumOfFactors(listOfFactors);
		if (number == tempSumTwo && (tempSumOne != tempSumTwo)) {
			amicablePair = tempSumOne;
			foundPairs.add(amicablePair);
			LOG.info("" + number + "  ," + tempSumOne);
			isAmicable = true;
		} else {
			isAmicable = false;
		}
		return isAmicable;
	}

	/**
	 * This method returs the sum of factors contained in an array.
	 * 
	 * @param listOfFactors
	 *            {@link Arrays} of {@link Integer} The list containing factors
	 * @return {@link Integer} The sum of factors.
	 * @author nimesh
	 */
	private static int sumOfFactors(List<Integer> listOfFactors) {
		// LOG.info("Into method 'sumOfFactors'");
		int sum = 0;
		for (Iterator<Integer> iter = listOfFactors.iterator(); iter.hasNext();) {
			sum += iter.next();
		}
		return sum;
	}

	/**
	 * Main method
	 * 
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("into main method");
		int sumOfAmicable = 0;

		for (int i = 1; i <= 10000; i++) {
			if (!foundPairs.contains(i)) {
				if (checkAmicable(i)) {
					sumOfAmicable += (i + amicablePair);
				}
			}
		}
		LOG.info("The sum is : " + sumOfAmicable);
	}

}
