package com.lftechnology.oop;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 1. Write a Guessing a number game application:
 *  User will select the guessing value from the keyboard
 *   and application will generate a random no between 1 and 100. 
 *   Check if the guess value matched with random no. or not,
 *    if matched show the guessing value, random value and the no. of attempts.
 */

/**
 * This class is a number guessing game. The user will provide a number between
 * [1-100] The system will generate a random number in the same range. If the
 * numbers match, the number, retry count and the random number..
 * 
 * @author nimesh
 * 
 */
public class NumberGuessingGame {

	private int randomNumber;
	private int count = 0;
	private int number = 0;
	Scanner scan;
	public NumberGuessingGame() {
		Random random = new Random();
		randomNumber =random.nextInt(100) + 1;
		scan=new Scanner(System.in);
	}

	/**
	 * This funtion prompts the user to enter the guessed number and stores it
	 * in the number variable.
	 * 
	 * @author nimesh
	 */
	private void prompt() {
		
		System.out
		.println("==============================================================");
		System.out
		.println("Please enter the number in the range [1-100] or 0 to exit");
		try {
			number = scan.nextInt();
		} catch (InputMismatchException i) {
			System.err.println("Please Enter Integers ");
			prompt();
		}
		if (number == 0) {
			System.exit(0);
		}
		count++;
		display();
	}

	/**
	 * This function checks whether the number entered by the user is in the
	 * range and whether it is equal to the random number.
	 * 
	 * @author nimesh
	 * @return {@link Boolean} Returns <b>true</b> if both numbers match,
	 *         otherwise <b>false</b>.
	 */
	private boolean checkNumber() {

		if (number >= 1 && number <= 100) {
			if (number == randomNumber) {
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("Please enter the number in the range [1-100]");
			prompt();
		}
		return false;
	}

	/**
	 * This function is used to display the result
	 * 
	 * @author nimesh
	 */
	private void display() {
		boolean result = checkNumber();
		if (result) {
			System.out.println("Congratulation!! Your guess was right.");
			System.out.println("The number you guessed was : \t" + number);
			System.out.println("The random number was : \t " + randomNumber);
			System.out.println("It took you " + count
					+ "turns to guess the correct number");

		} else {
			System.out
			.println("Sorry the number you guessed is not correct . Please try again.");
		}
		prompt();
	}

	public static void main(String[] args) {
		NumberGuessingGame guess = new NumberGuessingGame();
		guess.prompt();
	}

}
