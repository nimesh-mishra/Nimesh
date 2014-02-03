package com.lftechnology.oop;

/**
 * 4. Create a class called Time with three attributes hours, minutes, and seconds.
 *  	Use appropriate constructor(s) to initialize instance variables. 
 *  	Also, use a display method to display the time in hh:mm:ss format.
 *   	Modify the class to add two time objects that correctly results in addition of times.
 */
/**
 * This class adds and displays the time
 * 
 * @author nimesh
 * 
 */
public class Time {

	private int hours;
	private int minutes;
	private int seconds;

	/**
	 * This parameterized constructor is used to set values of the variables
	 * 
	 * @author nimesh
	 * @param hour
	 *            {@link Integer}
	 * @param minute
	 *            {@link Integer}
	 * @param second
	 *            {@link Integer}
	 */
	public Time(int hour, int minute, int second) {
		if (second >= 60) {
			minute += second / 60;
			second = second % 60;
		}
		if (minute >= 60) {
			hour += minute / 60;
			minute = minute % 60;
		}
		if (hour >= 24) {
			hour = hour % 24;
		}
		this.hours = hour;
		this.minutes = minute;
		this.seconds = second;
	}

	/**
	 * This function displays the time in hh:mm:ss format
	 * 
	 * @author nimesh
	 */
	private void display() {
		System.out.println("The current time is \t" + hours + ":" + minutes
				+ ":" + seconds);
	}

	/**
	 * This function adds time of two different objects. The conversion of
	 * seconds to minute and minutes to hour is also implemented.
	 * 
	 * @author nimesh
	 * @param time
	 *            {@link Time} The time to be added to current time.
	 */
	private void addTime(Time time) {
		int addHour = 0;
		int addMin = 0;
		int addSec = 0;
		display();
		System.out.println("The Time to be added is \t" + time.hours + ":"
				+ time.minutes + ":" + time.seconds);
		addHour = this.hours + time.hours;
		addMin = this.minutes + time.minutes;
		addSec = this.seconds + time.seconds;
		Time newTime=new Time(addHour,addMin,addSec);
		System.out.println("The total time is \t " + newTime.hours + ":" + newTime.minutes
				+ ":" + newTime.seconds);

	}

	public static void main(String[] args) {

		Time t1 = new Time(10, 20, 30);
		t1.display();
		Time t2 = new Time(12, 40, 30);
		t2.display();
		t2.addTime(t1);
	}

}
