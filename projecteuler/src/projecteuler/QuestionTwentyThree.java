package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 *A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

 A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

 As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

 Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers. 
 */
/**
 * This class finds the sum of all positive integers that can't be written as
 * the sum of two abundant numbers.
 * 
 * @author nimesh
 * 
 */
public class QuestionTwentyThree {
	private static final Logger LOG = Logger
			.getLogger(QuestionTwentyThree.class.getName());
	private static final int LIMIT = 28123;
	private static  boolean[] isAbundant = new boolean[LIMIT + 1];
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
	 * This method checks whether or not a number is a abundant number.
	 * 
	 * @param number
	 *            {@link Integer} The number to be checked.
	 * @return {@link Boolean} True if abundant, else false.
	 * @author nimesh
	 */
	private static boolean checkAbundance(int number) {
		boolean isAbundant = false;
		isAbundant = sumOfFactors(factorsOf(number)) > number ? true : false;
		return isAbundant;
	}

	/**
	 * This method checks if a number is sum of two abundant numbers.
	 * 
	 * @param n
	 *            {@link Integer} The number to be Checked.
	 * @return {@link Boolean} True if sum of two abundant numbers, else false.
	 */
	private static boolean isSumOf2Abundants(int n) {
		for (int i = 0; i <= n; i++) {
			if (isAbundant[i] && isAbundant[n - i])
				return true;
		}
		return false;
	}

	/**
	 * This is main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main method");
		
		for (int i = 1; i < isAbundant.length; i++){
			   isAbundant[i] = checkAbundance(i);
		}   
		int totalSum = 0;
		for (int i = 1; i <=LIMIT; i++) {
			if (!(isSumOf2Abundants(i))) {
				totalSum += i;
			}
		}
		LOG.info("The score is :" + totalSum);
	}

}
