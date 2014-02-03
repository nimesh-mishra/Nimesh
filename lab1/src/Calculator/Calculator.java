package Calculator;

import java.util.Scanner;

/**
 * 
 * @author nimesh
 * 
 */
public class Calculator {

	public Calculator() {
	}

	private int firstnum = 0;
	private int secondnum = 0;
	private int result = 0;
	private int choice = 0;

	/**
	 * This function is used to prompt user to enter the variables on which the
	 * operations have to be performed This function also asks the user for the
	 * type of operation
	 * 
	 * @author nimesh
	 * 
	 */
	public void prompt() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first number:");
		firstnum = scan.nextInt();
		System.out.println("Enter the second number:");
		secondnum = scan.nextInt();
		
		System.out.println("Enter the choice:");
		System.out.println("1 for +");
		System.out.println("2 for -");
		System.out.println("3 for *");
		System.out.println("4 for /");
		System.out.println("5 for %");
		System.out.println("6 to Exit");
		choice = scan.nextInt();
		if (choice == 6) {
			System.out.println("Exiting System...");
			System.exit(0);
		}
		operate(firstnum, secondnum, choice);

	}

	/**
	 * @author nimesh
	 * 
	 * @param first
	 * @param second
	 * @param choice
	 */
	private void operate(int first, int second, int choice) {

		switch (choice) {
		case 1:
			result = first + second;
			break;
			
		case 2:
			result = first - second;
			break;
			
		case 3:
			result = first * second;
			
		case 4:
			result = first / second;
			break;
		case 5:
			result = first % second;
			break;
			
		default:
			System.out.println("Please enter valid choice");
			prompt();
			break;

		}
		displayResult(result);
		prompt();
	}

	/**
	 * This function displays the result
	 * 
	 * @author nimesh
	 */
	private void displayResult(int result) {

		System.out.println("The result of the operation is : " + result);
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.prompt();
	}

}
