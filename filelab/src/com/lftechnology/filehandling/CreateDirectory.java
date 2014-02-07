package com.lftechnology.filehandling;
import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program to create a directory and check whether the directory is created.
 */
/**
 * This class creates a directory.
 * @author nimesh
 */
public class CreateDirectory {
	private static final Logger LOGGER=Logger.getLogger(CreateDirectory.class.getName());
	/**
	 * This is the main method
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LOGGER.info("Enter the name of the directory(absolute name) :");
		String directoryName = scan.next();
		LOGGER.log(Level.FINE,"The name of the file is : "+directoryName);
		File file = new File(directoryName);
		LOGGER.info("Checking for the existence of file");
		if (file.exists() || (file.isFile())) {
			LOGGER.log(Level.SEVERE,"Sorry the directory already exist or file is not a directory");
		} else {
			if (file.mkdirs()) {
				LOGGER.info("Directory created Successfully");
			} else {
				LOGGER.log(Level.SEVERE,"Directory Creation Failed!");
			}
		}

	}

}
