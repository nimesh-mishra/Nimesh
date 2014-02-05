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
 * This class has two variables(distances) and functions that 
 * adds,compares two objects and displays the result.
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
	private void setData(float feet, float inch) {
		this.feet = feet;
		this.inches = inch;
	}

	/**
	 * This method displays the distances
	 * 
	 * @author nimesh
	 */
	private void display() {
		System.out.println("The distance in feet is: \t" + this.feet);
		System.out.println("The distance in inches is: \t" + this.inches);
	}

	/**
	 * This function adds both the distances.
	 * 
	 * @author nimesh
	 * @return {@link Float} The sum of both distances
	 */
	private void addDistances(Distance distance) {
		float tempFeet = this.feet + distance.feet;
		float tempInch = this.inches + distance.inches;
		if (tempInch >= 12) {
			tempFeet += tempInch / 12;
			tempInch = tempInch % 12;
		}
		System.out.println("The Total length is: \t" +(int)tempFeet + "feet \t"
				+ tempInch + "inches");
	}

	/**
	 * This function compares the distances
	 * 
	 * @author nimesh
	 * @param {@link Distance} The distance object to be compared
	 */
	private void compareDistances(Distance distance) {
		
		float totalInchesOne=this.feet*12+this.inches;
		float totalInchesTwo=distance.feet*12+distance.inches;
		float difference=Math.abs(totalInchesOne-totalInchesTwo);
		float tempFeet = difference/12;
		float tempInch = difference%12;
		
		System.out.println("The Total length is: \t" + (int)tempFeet + "feet \t"
				+ tempInch + "inches");
	}

	public static void main(String[] args) {

		Distance d1 = new Distance();
		Distance d2 = new Distance();
		d1.setData(5,3);
		d1.display();
		d2.setData(2,11);
		d2.display();
		d1.addDistances(d2);
		d1.compareDistances(d2);

	}

}
