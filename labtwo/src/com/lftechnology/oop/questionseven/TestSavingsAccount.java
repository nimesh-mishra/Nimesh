package com.lftechnology.oop.questionseven;

/**
 * This class is used to test the SavingsAccount class 
 * @author nimesh
 *
 */
public class TestSavingsAccount {

	public static void main(String[] args) {
		SavingsAccount saver1=new SavingsAccount(2000);
		SavingsAccount saver2=new SavingsAccount(4000);
		SavingsAccount.modifyInterestRate(4);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		saver1.displaySavings();
		saver2.displaySavings();
		SavingsAccount.modifyInterestRate(5);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		saver1.displaySavings();
		saver2.displaySavings();
		
		

	}

}
