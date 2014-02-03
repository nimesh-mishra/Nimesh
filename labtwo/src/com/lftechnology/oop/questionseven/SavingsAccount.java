package com.lftechnology.oop.questionseven;

/**
 * This class holds the bank account details of a person.
 * @author nimesh
 *
 */
public class SavingsAccount {
	private static float annualIntrestRate;
	private float savingsBalance;
	private float monthlyIntrest;
	
	/**
	 * This parameterized constructor is used to initialize the value of savingsBalance
	 * @author nimesh
	 * @param balance {@link Float} The saving amount
	 */
	public SavingsAccount(float balance){
		savingsBalance=balance;
	}
	
	/**
	 * This static method is used to set the annualInterestRate
	 * @author nimesh
	 * @param interestRate {@link Float} The annual Intrest rate.
	 */
	public static void modifyInterestRate(float interestRate){
		annualIntrestRate=interestRate/100; // to change the % to actual value..
	}
	
	/**
	 * This method calculates the monthly intrest on savings.
	 * @author nimesh
	 */
	public void calculateMonthlyInterest(){
		monthlyIntrest=savingsBalance*annualIntrestRate/12;
		System.out.println("The monthly intrest is: $"+monthlyIntrest);
	}
	
	/**
	 * This method adds the monthly intrest to the total savings.
	 * @author nimesh
	 */
	private void calculateSavings(){
		savingsBalance+=monthlyIntrest;
	}
	
	
	/**
	 * This method displays the total savingsBalance
	 * @author nimesh
	 */
	public void displaySavings(){
		calculateSavings();
		System.out.println("The total balance is : $ "+savingsBalance);
	}

}
