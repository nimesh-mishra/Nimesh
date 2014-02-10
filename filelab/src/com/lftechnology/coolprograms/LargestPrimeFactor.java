/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
	What is the largest prime factor of the number 600851475143 ?
 */
package com.lftechnology.coolprograms;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * This class finds the largest prime factor of number given above
 * @author nimesh
 */
public class LargestPrimeFactor {
	public boolean running=false; 
	private static final Logger LOG=Logger.getLogger(LargestPrimeFactor.class.getName());
	final private static long  number=600851475143L;
	final private static long halfNumber=3004252325071L;
	public LargestPrimeFactor(){
		Thread thread=new Thread();
		thread.start();
	}
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args)throws InterruptedException,ExecutionException {
		LOG.info("Into main method");
		
		 String obj1, obj2;

		    final ExecutorService executorService = Executors.newFixedThreadPool(16);
		    final Future<String> res1 = executorService.submit(new Callable<String>() {
		        @Override
		        public String call() throws Exception {
		            return expensiveMethod(halfNumber);
		        }
		    });
		    final Future<String> res2 = executorService.submit(new Callable<String>() {
		        @Override
		        public String call() throws Exception {
		            return expensiveMethod(number-halfNumber);
		        }
		    });

		    obj1 = res1.get();
		    obj2 = res2.get();
		    long finalValue=Integer.valueOf(obj1);
		if(Integer.valueOf(obj1)<=Integer.valueOf(obj2)){
			LOG.info("The largest Prime of : "+number+" is : "+Integer.valueOf(obj2));
		}
		else{
			LOG.info("The largest Prime of : "+number+" is : "+Integer.valueOf(obj1));
		}
		
	}
	public static String expensiveMethod(long range){
		long largestPrime=0;
		for(long i=2;i<range;i++){
			if(number%i==0){
				int count=0;
				for(long j=2;j<=i/2;j++){
					if(i%j==0){
						count++;
					}
				}
				if(count==1){
					largestPrime=i;
				}
			}
		}
		return String.valueOf(largestPrime);
		
	}

}
