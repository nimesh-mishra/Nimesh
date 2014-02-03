package com.lftechnology.oop;

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
		if(second>=60){
			minute+=second/60;
			second=second%60;
		}
		if(minute>=60){
			hour+=minute/60;
			minute=minute%60;
		}
		if(hour>=24){
			hour=hour%24;
		}
		this.hours = hour;
		this.minutes = minute;
		this.seconds = second;
	}
	
	/**
	 * This function displays the time in hh:mm:ss format
	 * @author nimesh
	 */
	public void display(){
		System.out.println("The current time is \t"+hours+":"+minutes+":"+seconds);
	}
	
	/**
	 * This function adds time of two different objects.
	 * The conversion of seconds to minute and minutes to hour is also implemented.
	 * @author nimesh
	 * @param time {@link Time} The time to be added to current time.
	 */
	public void addTime(Time time){
		 int addhour=0;
		 int addmin=0;
		 int addsec=0;
		 display();
		 System.out.println("The Time to be added is \t"+time.hours+":"+time.minutes+":"+time.seconds);
		 addhour=this.hours+time.hours;
		 addmin=this.minutes+time.minutes;
		 addsec=this.seconds+time.seconds;
		 if(addsec>=60){
			 addmin=addsec/60;
			 addsec=addsec%60;
		 }
		 if(addmin>=60){
			 addhour=addmin/60;
			 addmin=addmin%60;
		 }
		 if(addhour>=24){
			 addhour=addhour%24;
		 }
		 System.out.println("The total time is \t "+addhour+":"+addmin+":"+addsec);
		
	}
	public static void main(String[] args) {

		Time t1=new Time(10,20,30);
		t1.display();
		Time t2=new Time(12,40,30);
		t2.display();
		t2.addTime(t1);
	}

}
