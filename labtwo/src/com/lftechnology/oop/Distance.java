package com.lftechnology.oop;

/**
 * This class has two variables(distances) and functions that adds those variables,compare them and displays them 
 * @author nimesh
 *
 */
public class Distance {

	private int feet;
	private float inches;
	
	/**
	 * This method sets the value of two private variables feet and inches
	 * @author nimesh
	 * @param feet {@link Integer} Distance in feet
	 * @param inch {@link Float} Distance in inch
	 */
	public void setData(int feet, float inch){
		this.feet=feet;
		this.inches=inch;
	}
	
	/**
	 *This method displays the distances
	 *@author nimesh
	 */
	public void display(){
		System.out.println("The distance in feet is: \t"+feet);
		System.out.println("The distance in inches is: \t"+inches);
	}
	
	/**
	 * This function adds both the distances.
	 * @author nimesh
	 * @return {@link Float} The sum of both distances
	 */
	public float addDistances(){
		return (feet+inches/12);
	}
	
	/**
	 * This function compares the distances 
	 * @author nimesh
	 * @return {@link Float} The difference of both distances
	 */
	public float compareDistances(){
		return (feet-inches/12);
	}
	public static void main(String[] args) {
		
		Distance d=new Distance();
		d.setData(12, 12);
		d.display();
		System.out.println("The sum of both distances is: \t"+d.addDistances());
		System.out.println("The difference of both distances is: \t"+d.compareDistances());
	}

}
