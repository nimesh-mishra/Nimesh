package com.lftechnology.oop.question5;

/**
 * This class holds the information about an employee
 *  It has setter and getter methods to set the values and retrieve the values of the instance variables
 * @author nimesh
 *
 */
public class Employees {
	
	private String firstName;
	private String lastName;
	private double salary=0;
	
	/**
	 * The default constructor
	 * @author nimesh
	 */
	public Employees(){}
	
	/**
	 * This parametrized constructor is used to set the values of instance variables
	 * @author nimesh
	 * @param first {@link String} The first name 
	 * @param last {@link String} The last name
	 * @param salary {@link Double} The monthly salary
	 */
	public Employees(String first,String last,double salary){
		this.firstName=first;
		this.lastName=last;
		this.salary=salary;
	}

	/**
	 * This function is used to get the first name
	 * @author nimesh
	 * @return {@link String} The first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This function sets the first name
	 * @author nimesh
	 * @param firstName {@link String} The first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method is used to get the last name
	 * @author nimesh
	 * @return {@link String} The last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method sets the last name
	 * @author nimesh
	 * @param lastName {@link String} 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** 
	 * This method is used to get the monthly salary
	 * @author nimesh
	 * @return {@link Double} The monthly salary
	 */
	public double getSalary() {
		return salary;
	}

	/**This method sets the monthly salary
	 * @author nimesh
	 * @param salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
