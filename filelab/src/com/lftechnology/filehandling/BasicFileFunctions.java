package com.lftechnology.filehandling;

import java.io.File;
import java.util.Scanner;

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
 * 
 * @author nimesh
 * 
 */
public class BasicFileFunctions {

	private File newFile;

	/**
	 * Parameterized constructor to create a new File object
	 * 
	 * @param fileName
	 *            {@link String} Name of File
	 */
	public BasicFileFunctions(String fileName) {
		newFile = new File(fileName);
	}

	/**
	 * This method returns the file object
	 * 
	 * @return {@link File}
	 */
	public File getNewFile() {
		return newFile;
	}

	/**
	 * This is the main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the absolute file name :");
		String fileName = scan.next();

		File file = new File(fileName);
		if (file.exists() && file.isFile()) {
			System.out.println("Enter the new name for the file.");
			String newName = scan.next();
			String fullNewName = file.getAbsolutePath().replaceAll(
					file.getName(), newName);
			File renamedFile = new File(fullNewName);
			if (file.renameTo(renamedFile)) {
				System.out.println("File Renamed to :\t " + fullNewName);
				file.setWritable(true);
				BasicFileFunctions question = new BasicFileFunctions(
						fullNewName);
				file = question.getNewFile();
				if (file.exists() && file.isFile()) {
					System.out.println("File Deleted? \t" + file.delete());
					System.out.println("File deleted successfully...(Y)");
				}
			}
			else{
				System.err.println("File Renaming Failed !!");
			}
		} else {
			System.err
					.println("Sorry! The file you are searching for doesn't exist");
		}
	}
}
