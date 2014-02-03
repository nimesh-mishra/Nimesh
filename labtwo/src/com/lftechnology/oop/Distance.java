package com.lftechnology.oop;

/**
 * 2. Create a class called Distance that includes two private data members feet
 * (type int) and inches (type float). Use a method setData to set values to
 * instance variables. Provide a method display that displays the feet and
 * inches, a member function addDistance for adding two distances, and a member
 * function compareDistance for comparing two distances. Implement your program
 * in Java.
 */

/**
 * This class has two variables(distances) and functions that adds those
 * variables,compare them and displays them
 * 
 * @author nimesh
 * 
 */
public class Distance {

	private float feet;
	private float inches;

	/**
	 * This method sets the value of two private variables feet and inches
	 * 
	 * @author nimesh
	 * @param feet
	 *            {@link Integer} Distance in feet
	 * @param inch
	 *            {@link Float} Distance in inch
	 */
	public void setData(float feet, float inch) {
		this.feet = feet;
		this.inches = inch;
	}

	/**
	 * This method displays the distances
	 * 
	 * @author nimesh
	 */
	public void display() {
		System.out.println("The distance in feet is: \t" + feet);
		System.out.println("The distance in inches is: \t" + inches);
	}

	/**
	 * This function adds both the distances.
	 * 
	 * @author nimesh
	 * @return {@link Float} The sum of both distances
	 */
	public void addDistances(Distance d) {
		float tempfeet = feet + d.feet;
		float tempinch = inches + d.inches;
		if (tempinch > 12) {
			tempfeet += tempinch / 12;
			tempinch = tempinch % 12;
		}
		System.out.println("The Total length is: \t" + tempfeet + "feet"
				+ tempinch + "inches");
	}

	/**
	 * This function compares the distances
	 * 
	 * @author nimesh
	 * @return {@link Float} The difference of both distances
	 */
	public void compareDistances(Distance d) {
		float tempfeet = Math.abs(feet - d.feet);
		float tempinch = Math.abs(inches - d.inches);
		System.out.println("The Total length is: \t" + tempfeet + "feet"
				+ tempinch + "inches");
	}

	public static void main(String[] args) {

		Distance d1 = new Distance();
		Distance d2 = new Distance();
		d1.setData(12, 12);
		d1.display();
		d2.setData(10, 10);
		d2.display();
		d1.addDistances(d2);
		d1.compareDistances(d2);

	}

}
