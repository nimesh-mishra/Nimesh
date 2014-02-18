package projecteuler;

import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1

 For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

 Find the sum of the digits in the number 100!
 */
/**
 * This class finds the sum of digits of factorial of 100.
 * 
 * @author nimesh
 * 
 */
public class QuestionTwenty {
	private static final Logger LOG = Logger.getLogger(QuestionTwenty.class
			.getName());

	/**
	 * This method finds the factorial of a given number.
	 * 
	 * @param number
	 *            {@link Integer} The number of which factorial is to be found.
	 * @return {@link Long} The result of factorial on the number.
	 */
	private static BigInteger findFactorial(int number) {
		BigInteger result = BigInteger.ONE;
		for (int i = number; i > 0; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

	/**
	 * This is main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main method");
		int sum = 0;
		String resultOfFactorial = findFactorial(100).toString();
		for (int i = 0; i < resultOfFactorial.length(); i++) {
			Character c = new Character(resultOfFactorial.charAt(i));
			String digit = c.toString();
			int digitInInt = Integer.valueOf(digit);
			sum += digitInInt;
		}
		LOG.info("The sum is :" + sum);
	}

}
