package com.lftechnology.filehandling;

import java.io.File;
import java.io.IOException;

/**
 *Write a program to create a text file in the path c:\java\abc.txt 
 *and check whether that file is exists. 
 *Using the command exists(), isDirectory(), isFile(), getName() and getAbsolutePath().
 */
/**
 * This class exploits some of the functionality provided by {@link File} class.
 * @author nimesh
 *
 */
public class QuestionOne {
	
	/**
	 * This is the main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		String fileName="/home/nimesh/abc.txt";
		File file=new File(fileName);
		
		//To check if file already exist
		 if(file.exists()){
			 System.out.println("The file already exists...");
			 System.exit(0);
		 }
		try {
			if(file.createNewFile()){
				System.out.println("File  "+file.getName()+" Created Successfully...");
			}
			else{
				System.err.println("Sorry! File creation Failed");
				System.exit(0);
				}
		} catch (IOException e) {
			System.err.println("Error occurred... \n The error is :");
			e.printStackTrace();
		}
		//To check the file after its creation
		if(file.exists()){
			if(file.isDirectory()){
				System.out.println("The entity is a directory");
			}
			else if(file.isFile()){
				System.out.println("The entity is a File");
			}
			System.out.println("The name of the Entity is : "+file.getName());
			System.out.println("The absolute path  is "+file.getAbsolutePath());
					
		}
		else{
		System.err.println("Sorry! file doesn't exist..");
		}
		

	}

}
