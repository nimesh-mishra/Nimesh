package Palindrome;

import java.util.Scanner;

/**
 * 
 * @author nimesh
 * 
 */
public class PalindromeCheck {
	private int num = 0;

	/**
	 * @author nimesh
	 * 
	 *         Asks the user for input
	 */
	private void prompt() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the five digit number: Or 0 to Exit");
		num = scan.nextInt();
		
		if (num == 0) {
			System.exit(0);
		}
		
		boolean returned = checkPalindrome(num);
		displayResult(returned);
	}

	/**
	 * @author nimesh
	 * 
	 *         Checks whether the number entered by user is palindrome or not..
	 * @param i
	 * @return boolean
	 */
	private boolean checkPalindrome(int i) {
		int temp = 0;
		int number = i;
		if (number < 10000 || number > 99999) {
			System.out.println("Enter valid five digit number:");
			prompt();
		} else {
			while (number != 0) {
				int remainder = number % 10;
				temp = temp * 10 + remainder;
				number = number / 10;
			}
		}
		if (i == temp) {
			return true;
		}
		return false;
	}

	/**
	 * @author nimesh
	 * 
	 *         Displays the result
	 * @param result
	 */
	private void displayResult(boolean result) {

		if (result == true) {
			System.out.println("The number is Palindrome...");
		} else {
			System.out.println("The number is not Palindrome...");
		}
		prompt();
	}

	/**
	 * @author nimesh
	 * 
	 *         Main function
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromeCheck p = new PalindromeCheck();
		p.prompt();

	}

}
