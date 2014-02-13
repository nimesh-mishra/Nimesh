package projecteuler;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 n → n/2 (n is even)
 n → 3n + 1 (n is odd)

 Using the rule above and starting with 13, we generate the following sequence:

 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
 Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

 Which starting number, under one million, produces the longest chain?
 NOTE: Once the chain starts the terms are allowed to go above one million.
 */
/**
 * This class finds the number below one million that has longest chain.
 * @author nimesh
 *
 */
public class QuestionFourteen {
	private static final Logger LOG=Logger.getLogger(QuestionFourteen.class.getName());
	/**
	 * Main method
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("into main method");
		long maxChainCount=0;
		long numberWithMaxChain=0;
		List<Long>numbers=new LinkedList<Long>();
		for(int i=10;i<1000000;i++){
			long j=i;
			while(j!=1){
				if(j%2==0){
					j=j/2;
					numbers.add(j);
				}
				else{
					j=(3*j)+1;
					numbers.add(j);
				}
			}
			if(numbers.size()>maxChainCount){
				maxChainCount=numbers.size();
				numberWithMaxChain=i;
			}
			numbers.clear();
		}
		LOG.info("The number with max chain lenght is : "+numberWithMaxChain);
	}

}
