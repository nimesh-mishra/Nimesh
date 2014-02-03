package com.lftechnology.oop.questionseven;

/**
 * 7. Create class SavingsAccount. 
 * Use a static variable annualInterestRate to store the annual interest rate for all account holders. 
 * Each object of the class contains a private instance variable savingsBalance 
 * indicating the amount the saver currently has on deposit.
 *  Provide method calculateMonthlyInterest to calculate the monthly interest 
 *  by multiplying the savingsBalance by annualInterestRate divided by 12. 
 *  This interest should be added to savingsBalance. 
 *  Provide a static method modifyInterestRate that sets the annualInterestRate to a new value.
 *   Write a program to test class SavingsAccount. 
 *   Instantiate two savingsAccount objects, saver1 and saver2, with balances of $2000.00 and $3000.00,respectively.
 *    Set annualInterestRate to 4%, then calculate the monthly interest 
 *    and print the new balances for both savers. 
 *    Then set the annualInterestRate to 5%, calculate the next month's interest 
 *    and print the new balances for both savers.
 */

/**
 * This class holds the bank account details of a person.
 * 
 * @author nimesh
 * 
 */
public class SavingsAccount {
	private static float annualIntrestRate;
	private float savingsBalance;
	private float monthlyIntrest;

	/**
	 * This parameterized constructor is used to initialize the value of
	 * savingsBalance
	 * 
	 * @author nimesh
	 * @param balance
	 *            {@link Float} The saving amount
	 */
	public SavingsAccount(float balance) {
		this.savingsBalance = balance;
	}

	/**
	 * This static method is used to set the annualInterestRate
	 * 
	 * @author nimesh
	 * @param interestRate
	 *            {@link Float} The annual Intrest rate.
	 */
	public static void modifyInterestRate(float interestRate) {
		annualIntrestRate = interestRate / 100; // to change the % to actual
		// value..
	}

	/**
	 * This method calculates the monthly intrest on savings.
	 * 
	 * @author nimesh
	 */
	public void calculateMonthlyInterest() {
		monthlyIntrest = savingsBalance * annualIntrestRate / 12;
		System.out.println("The monthly intrest is: $" + monthlyIntrest);
	}

	/**
	 * This method adds the monthly intrest to the total savings.
	 * 
	 * @author nimesh
	 */
	private void calculateSavings() {
		savingsBalance += monthlyIntrest;
	}

	/**
	 * This method displays the total savingsBalance
	 * 
	 * @author nimesh
	 */
	public void displaySavings() {
		calculateSavings();
		System.out.println("The total balance is : $ " + savingsBalance);
	}

}
