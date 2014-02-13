package projecteuler;

import java.util.List;
import java.util.logging.Logger;

/**
 * What is the value of the first triangle number to have over five hundred divisors?
 */
/**
 * This class finds the first triangle number to have over five hundred divisors.
 * @author nimesh
 *
 */
public class QuestionTwelve {
	private static final Logger LOG=Logger.getLogger(QuestionTwelve.class.getName());
	/**
	 * Main method
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("into main method");
		int count=0;
		int triangleNumber=0;
		boolean finish=false;
		long startTime=System.currentTimeMillis();
		while(!finish){
			count++;
			triangleNumber+=count;
			if(countFactors(triangleNumber)>500){
				long finishTime=System.currentTimeMillis();
				LOG.info("The triangle number is : "+triangleNumber+" in :"+(finishTime-startTime)/1000);
				finish=true;
			}
			}
		}
		
	private static int countFactors(int numberToBeFactorized){
		int count=1;
//		int numToFactor=numberToBeFactorized;
//		int currentUpperLimit=numberToBeFactorized;
		for(int i=2;i<(int)Math.sqrt(numberToBeFactorized)+1;i++){
			if(numberToBeFactorized%i==0){
				count++;
			}
		}
		return 2*count;
	}

}
