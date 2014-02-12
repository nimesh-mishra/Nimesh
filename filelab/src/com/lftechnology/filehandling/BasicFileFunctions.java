package com.lftechnology.filehandling;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Write a program to rename the given file, 
 * after renaming the file delete the renamed file.
 *  (Accept the file name using command line arguments.)
 */
/**
 * This class uses the basic functions defined in {@link File} class such as
 * rename,delete. The user at first needs to enter the absolute file name. The
 * class then renames the file using a new {@link File} object. Finally the file
 * is deleted.
 * @author nimesh
 */
public class BasicFileFunctions {
	private static final Logger LOGGER=Logger.getLogger(BasicFileFunctions.class.getName());
	private File newFile;
	/**
	 * Parameterized constructor to create a new File object
	 * @param fileName
	 *            {@link String} Name of File
	 */
	public BasicFileFunctions(String fileName) {
		newFile = new File(fileName);
	}
	/**
	 * This method returns the file object
	 * @return {@link File}
	 */
	public File getNewFile() {
		return newFile;
	}
	/**
	 * This is the main method
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.info("Running class: "+BasicFileFunctions.class.getName());
		LOGGER.info("Taking user Input..");
		Scanner scan = new Scanner(System.in);
		LOGGER.info("Enter the file Name: ");
		String fileName = scan.next();
		LOGGER.log(Level.FINE,"The user Input is : "+fileName);
		File file = new File(fileName);
		LOGGER.info("Checking file for existence...");
		if (file.exists() && file.isFile()) {
			LOGGER.info("Enter the new name for the file");
			String newName = scan.next();
			LOGGER.info("The new Name of the File is :"+newName);
			String fullNewName = file.getAbsolutePath().replaceAll(
					file.getName(), newName);
			File renamedFile = new File(fullNewName);
			if (file.renameTo(renamedFile)) {
				LOGGER.info("File : "+fileName+" renamed to "+fullNewName);
				file.setWritable(true);
				BasicFileFunctions question = new BasicFileFunctions(
						fullNewName);
				file = question.getNewFile();
				if (file.exists() && file.isFile()) {
					if(file.delete()){
						LOGGER.info("File : "+ fullNewName+" deleted successfully");
					}
					else{
						LOGGER.info("Deletion of file : "+fullNewName+" Failed");
					}
				}
			}
			else{
				LOGGER.warning("File Renaming Failed !!");
			}
		} else {
			LOGGER.log(Level.SEVERE,"Sorry! The file you are searching for doesn't exist");
		}
	}
}
