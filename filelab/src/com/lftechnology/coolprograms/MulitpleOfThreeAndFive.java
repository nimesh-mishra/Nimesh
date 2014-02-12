package com.lftechnology.coolprograms;

import java.util.logging.Logger;

public class MulitpleOfThreeAndFive {
	private static final Logger LOG=Logger.getLogger(MulitpleOfThreeAndFive.class.getName());
	public static void main(String[] args){
		LOG.info("Running main method");
		int divisibleByFive=0;
		int divisibleByThree=0;
		for(int i=0;i<1000;i++){
			if(i%3==0){
				divisibleByThree+=i;
			}
			else if(i%5==0){
				divisibleByFive+=i;
			}
		}
		LOG.info("The sum is : "+(divisibleByFive+divisibleByThree));
	}

}
