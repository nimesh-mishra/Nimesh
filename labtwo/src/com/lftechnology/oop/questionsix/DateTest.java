package com.lftechnology.oop.questionsix;

public class DateTest {

	public static void main(String[] args) {
		Date date=new Date(12,10,2013);
		date.displayDate();
		date.setDay(25);
		date.setMonth(1);
		date.setYear(2014);
		date.displayDate();
	}

}
