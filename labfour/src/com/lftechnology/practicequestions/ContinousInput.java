package com.lftechnology.practicequestions;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 4. Try to do a program that constantly prompts the user to enter something 
 * (using the Scanner class) until the user enters a specific word (such as quit for example)
 */
/**
 * This class prompts the user for input until the user enters 'quit'
 * 
 * @author nimesh
 */
public class ContinousInput {
	private static final Logger LOG = Logger.getLogger(ContinousInput.class
			.getName());

	/**
	 * main class
	 * 
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into Main method");
		Scanner scan = new Scanner(System.in);
		final String TOEND = "quit";
		String input = "";
		boolean quit = false;
		while (!quit) {
			LOG.info("Enter the string");
			input = scan.next();
			if (input.equalsIgnoreCase(TOEND)) {
				quit = true;
			}
		}
	}

}
