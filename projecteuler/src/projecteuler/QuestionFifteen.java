package projecteuler;

import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 *  there are exactly 6 routes to the bottom right corner.
	How many such routes are there through a 20×20 grid?
 */
/**
 * This class finds the numer of ways to reach the bottom right moving only in right-down direction.
 * @author nimesh
 */
public class QuestionFifteen {
	private static final Logger LOG=Logger.getLogger(QuestionFifteen.class.getName());
	private static int[][]grid=new int[20][20];
	/**
	 * Main method
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("into main method");
		int totalSteps=40;
		int rightSteps=20;
		BigInteger totalPath;
		totalPath=factorial(totalSteps).divide((factorial(rightSteps).multiply(factorial(totalSteps-rightSteps))));
		LOG.info("Total number of path is : " +totalPath);
	}
	private static BigInteger factorial(int number){
		BigInteger value=BigInteger.ONE;
		for(int i=1;i<=number;i++){
			value=value.multiply(BigInteger.valueOf(i));
		}
		return value;
	}
}
