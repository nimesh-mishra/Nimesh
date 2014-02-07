package com.lftechnology.filehandling;

import java.io.File;
import java.util.Scanner;

/**
 * Write a program to create a directory and check whether the directory is created.
 */
/**
 * This class creates a directory.
 * 
 * @author nimesh
 */
public class CreateDirectory {
	/**
	 * This is the main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the directory(absolute name) :");
		String directoryName = scan.next();
		File file = new File(directoryName);
		if (file.exists() || (file.isFile())) {
			System.out
					.println("Sorry the directory already exist or file is not a directory");
		} else {
			System.out.println("Creating directory...");
			if (file.mkdirs()) {
				System.out.println("Directory created Successfully");
			} else {
				System.err.println("Directory Creation Failed!");
			}
		}

	}

}
