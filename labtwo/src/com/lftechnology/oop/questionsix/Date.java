package com.lftechnology.oop.questionsix;


/**
 * This class holds the information about date.
 * It has setter and getter methods to set and get the instance variables.
 * @author nimesh
 *
 */
public class Date {
	private int day;
	private int month;
	private int year;
	
	/**
	 * This parameterized constructor is used to set the values of instance variables 
	 * @author nimesh
	 * @param day {@link Integer} The day
	 * @param month {@link Integer} The month
	 * @param year {@link Integer} The year
	 */
	public Date(int day, int month, int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	/**
	 * This method is used to display the date, separated by /
	 * @author nimesh
	 */
	public void displayDate(){
		System.out.println("The current date is: \t"+year+"/"+month+"/0"+day);
	}

	/**
	 * This method is used to get the value of variable day
	 * @return {@link Integer} Day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * This method is used to set the value of variable day
	 * @param day {@link Integer} The day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * This method is used to get the value of variable month
	 * @return {@link Integer} The month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * This method is used to set the value of variable month
	 * @param month {@link Integer} The month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * This method is used to get the value of variable year
	 * @return {@link Integer} The year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * This method is used to set the value of variable year 
	 * @param year {@link Integer} The year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	

}
