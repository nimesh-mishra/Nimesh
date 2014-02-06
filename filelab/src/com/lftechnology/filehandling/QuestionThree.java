package com.lftechnology.filehandling;

import java.io.File;
import java.util.Scanner;

/**
 * Write a program to create a directory and check whether the directory is created.
 */

/**
 * This class creates a directory and checks whether it has been created or not.
 * @author nimesh
 *
 */
public class QuestionThree {

	/**
	 * This is the main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the name of the directory(absolute name) :");
		String directoryName=scan.next();
		
		File file=new File(directoryName);
		if(file.exists()){
			System.out.println("Sorry the directory already exist");
		}
		else{
			System.out.println("Creating directory...");
			if(file.mkdir()){
				if(file.exists()){
					System.out.println("Directory Created Successfully");
				}
				
			}
			else{
				System.err.println("Directory Creation Failed!");
			}
		}

	}

}
