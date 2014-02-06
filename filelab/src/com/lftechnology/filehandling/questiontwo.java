package com.lftechnology.filehandling;

import java.io.File;
import java.util.Scanner;

/**
 * Write a program to rename the given file, 
 * after renaming the file delete the renamed file.
 *  (Accept the file name using command line arguments.)
 */

/**
 * This class uses the basic functions defined in {@link File} class such as rename,delete.
 * The user at first needs to enter the absolute file name.
 * The class splits the string to get the path.
 * The class then appends the new name(just name not absolute name) to the path..
 * The class then renames the file using a new {@link File} object.
 * Finally the file is deleted.
 * @author nimesh
 *
 */
public class questiontwo {

	/**
	 * This is the main method
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the absolute file name :");
		String fileName=scan.next();
		
		File file=new File(fileName);
		if(file.exists()){
			String[] splittedFileName=fileName.split("/"); // To extract the path from the absolute file name
			System.out.println("Enter the new name for the file.");
			String newName=scan.next();
			splittedFileName[splittedFileName.length-1]=newName; // To get the absolute file name with new file name.
			String fullNewName="";
			for(int i=0;i<splittedFileName.length;i++){
				fullNewName=fullNewName.concat(splittedFileName[i].concat("/"));
				if(i==splittedFileName.length-1){
					fullNewName=fullNewName.concat(splittedFileName[i]);
				}
			}
		File renamedFile=new File(fullNewName);
			file.renameTo(renamedFile);
			System.out.println("File Renamed to :\t "+fullNewName);
			System.out.println("Deleting file...");
			file.delete();
			System.out.println("File Deleted");
		}
		else{
			System.err.println("Sorry! The file you are searching for doesn't exist");
		}
		
	}

}
