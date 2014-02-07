package com.lftechnology.filehandling;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Write a program to create a text file in the path c:\java\abc.txt 
 *and check whether that file is exists. 
 *Using the command exists(), isDirectory(), isFile(), getName() and getAbsolutePath().
 */
/**
 * This class exploits some of the functionality provided by {@link File} class.
 * @author nimesh
 */
public class CreateFile {
	private static final Logger LOGGER=Logger.getLogger(CreateFile.class.getName());
	/**
	 * This is the main method
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.info("Running Class: "+CreateFile.class.getName());
		String fileName = "/home/nimesh/abc/abc.txt";
		File file = new File(fileName);
		// To check if file already exist
		LOGGER.info("Checking the existence of file...");
		if (file.exists() && file.isFile()) {
			LOGGER.log(Level.SEVERE, "The file : "+fileName+" already exists..");
			LOGGER.info("Exiting System...");
			System.exit(0);
		}
		try {
			LOGGER.info("Creating File: "+fileName);
			file.getParentFile().mkdirs();
			if (file.createNewFile()) {
				LOGGER.info("File :"+ file.getName()+" created Successfully");
			} else {
				LOGGER.log(Level.SEVERE,"Sorry! File creation Failed");
				LOGGER.info("Exiting System...");
				System.exit(0);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE,"Error occurred. The Error is :"+e.getMessage());
		}
		// To check the file after its creation
		LOGGER.info("Checking the file for directory/file...");
		if (file.exists() && file.isDirectory()) {
			LOGGER.info("The entity is a directory");
		} else if (file.exists() && file.isFile()) {
			LOGGER.info("The entity is a file");
		}
		LOGGER.info("The name of the Entity is : " + file.getName());
		LOGGER.info("The absolute path  is " + file.getAbsolutePath());
	}

}
