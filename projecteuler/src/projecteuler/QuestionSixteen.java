package projecteuler;

import java.math.BigInteger;
import java.util.logging.Logger;

/**
 *215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
What is the sum of the digits of the number 2^1000? 
 */
/**
 * This class finds the sum of digits of 2^1000.
 * @author nimesh
 *
 */
public class QuestionSixteen {
	private static final Logger LOG=Logger.getLogger(QuestionSixteen.class.getName());
	/**
	 * Main method
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("into main method");
		BigInteger value=BigInteger.valueOf(2);
		BigInteger modulas=BigInteger.valueOf(10);
		value=value.pow(1000);
		LOG.info("The value is : "+value);
		LOG.info("the sum is : "+sumOfDigits(value.toString())); 
	}
	private static int sumOfDigits(String s){
		int sum=0;
		for(int i=0;i<s.length();i++){
			Character c=new Character(s.charAt(i));
			String digit=c.toString();
			int digitInteger=Integer.valueOf(digit);
			sum+=digitInteger;
		}
		return sum;
	}
}
