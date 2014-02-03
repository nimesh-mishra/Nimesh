package com.lftechnology.oop;

import java.util.Scanner;

/**
 * This class calculates the percentage and GPA of a student.
 * 
 * @author nimesh
 * 
 */
public class CalculatePercentageAndGPA {

	final int totalSubjects = 5;
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
	public void setData(String name, int classno, int roll, float science,
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
	 * This function calculates the percentage of each student
	 * @author nimesh
	 */
	public void calculatePercentage() {
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
	 */
	public void display() {
		for (int i = 0; i < 5; i++) {
			System.out.println("The percentage of \t" + name[i] + "is: \t"
					+ percentage[i]);
		}
	}

	public static void main(String[] args) {
		CalculatePercentageAndGPA calculate = new CalculatePercentageAndGPA();
		String name;
		int classNumber;
		int roll;
		float science;
		float math;
		float social;
		float nepali;
		float health;
		for (int i = 0; i < 5; i++) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the name of student " + i + 1 + ": \t");
			name = scan.nextLine();
			System.out.println("Enter the class of student " + i + 1 + ": \t");
			classNumber = scan.nextInt();
			System.out.println("Enter the roll number of studnet " + i + 1
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
			calculate.setData(name, classNumber, roll, science, math, social,
					nepali, health, i);

		}
		calculate.calculatePercentage();

	}

}
