package com.lftechnology.oop;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 3. Write a program that calculates percentage and GPA of 5 students. 
 * 		Each of the students has following attributes: 
 * 		name, class, rollnum, and marks obtained in 5 subjects.
 */

/**
 * This class calculates the percentage and GPA of a student.
 * @author nimesh
 * 
 */
public class CalculatePercentageAndGPA {

	final private int totalSubjects = 5;
	private String[] name = new String[5];
	private int[] classno = new int[5];
	private int[] roll = new int[5];
	private float[] science = new float[5];
	private float[] math = new float[5];
	private float[] social = new float[5];
	private float[] nepali = new float[5];
	private float[] health = new float[5];
	private float[] percentage = new float[5];

	/**
	 * This function sets the value of variables name,classno,roll,and all five
	 * subjects
	 * 
	 * @author nimesh
	 * @param name
	 *            {@link String} The name of the student
	 * @param classno
	 *            {@link Integer} The class of the studnet
	 * @param roll
	 *            {@link Integer} The Roll no of the studnet
	 * @param marks
	 *            StringArray The marks of the five subjects
	 * @param number
	 *            {@link Integer} The number of the student. Used to identify
	 *            any student among five
	 */
	private void setData(String name, int classno, int roll, float science,
			float math, float social, float nepali, float health, int number) {

		this.name[number] = name;
		this.classno[number] = classno;
		this.roll[number] = roll;
		this.science[number] = science;
		this.math[number] = math;
		this.social[number] = social;
		this.nepali[number] = nepali;
		this.health[number] = health;
	}
	
	/**
	 * This method prompts user for input
	 * @author nimesh
	 */
	private void prompt(){
		String name="";
		int classNumber=0;
		int roll=0;
		float science=0;
		float math=0;
		float social=0;
		float nepali=0;
		float health=0;
		for (int i = 0; i < 5; i++) {
			Scanner scan = new Scanner(System.in);
			try{
			System.out.println("Enter the name of student " + (i+1) + ": \t");
			name = scan.nextLine();
			System.out.println("Enter the class of student " + (i+1) + ": \t");
			classNumber = scan.nextInt();
			System.out.println("Enter the roll number of studnet " + (i+1) + 1
					+ ": \t");
			roll = scan.nextInt();
			System.out.println("Enter the marks in science: \t");
			science = scan.nextFloat();
			System.out.println("Enter the marks in math: \t");
			math = scan.nextFloat();
			System.out.println("Enter the marks in social: \t");
			social = scan.nextFloat();
			System.out.println("Enter the marks in nepali: \t");
			nepali = scan.nextFloat();
			System.out.println("Enter the marks in health: \t");
			health = scan.nextFloat();
			
			}catch(InputMismatchException e){
				e.printStackTrace();
				System.out.println("Please Enter valid data");
				prompt();
				
			}
			setData(name, classNumber, roll, science, math, social,
					nepali, health, i);

		}
	}

	/**
	 * This function calculates the percentage of each student
	 * @author nimesh
	 */
	private void calculatePercentage() {
		float total = 0;
		for (int number = 0; number < 5; number++) {
			total = science[number] + math[number] + social[number]
					+ nepali[number] + health[number];
			percentage[number] = total / totalSubjects;
		}
		display();

	}

	/**
	 * This function displays the percentage of each student.
	 * @author nimesh
	 */
	private void display() {
		for (int i = 0; i < 5; i++) {
			System.out.println("The percentage of \t" + name[i] + "is: \t"
					+ percentage[i]);
		}
	}

	public static void main(String[] args) {
		CalculatePercentageAndGPA calculate = new CalculatePercentageAndGPA();
		calculate.calculatePercentage();

	}

}
