package com.lftechnology.practicequestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 5. Write a program called FileInput to read an int, a double, and a String form a text file called "in.txt", and produce the following output:  (Hint use Scanner to read from file)
 a. The integer read is 12 
 b. The floating point number read is 33.44 
 c. The String read is "Peter"
 d. Hi! Peter, the sum of 12 and 33.44 is 45.44

 */
/**
 * This class reads the content of file and prints it in required format.
 * 
 * @author nimesh
 * 
 */
public class FileInput {
	private static final Logger LOG = Logger.getLogger(FileInput.class
			.getName());

	/**
	 * main class
	 * 
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into Main method");
		String[] fileValues = new String[3];
		int i = 0;
		File file = new File("/home/nimesh/abc.txt");
		if (file.exists() && file.isFile()) {
			try {
				Scanner scan = new Scanner(file);
				while (scan.hasNextLine()) {
					fileValues[i] = scan.nextLine().toString();
					i++;
				}
				String valueOne=fileValues[0];
				String valueTwo=fileValues[1];
				String valueThree=fileValues[2];
				LOG.info("The integer read is: "
						+ Integer.valueOf(valueOne));
				LOG.info("he floating point number read is :"
						+ Float.valueOf(valueTwo));
				LOG.info("The String read is :" + valueThree);
				LOG.info("Hi "
						+ valueThree
								+ "!, the sum of "
								+ Integer.valueOf(valueOne)
								+ "and "
								+ Float.valueOf(valueTwo)
								+ " is "
								+ (Integer.valueOf(valueOne) + Float
										.valueOf(valueTwo)));
			} catch (FileNotFoundException e) {
				LOG.log(Level.SEVERE, "Exception occured. The Exception is : "
						+ e.getMessage());
			}
		}
		else{
			LOG.log(Level.SEVERE,"Sorry!! File not found...");
		}
	}

}
