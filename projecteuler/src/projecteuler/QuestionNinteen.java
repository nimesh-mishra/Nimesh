package projecteuler;

import java.util.logging.Logger;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 1 Jan 1900 was a Monday.
 Thirty days has September,
 April, June and November.
 All the rest have thirty-one,
 Saving February alone,
 Which has twenty-eight, rain or shine.
 And on leap years, twenty-nine.
 A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
/**
 * This class finds the number of sundays in the month of january from 1st jan
 * 1901 to 31 dec 2000
 * 
 * @author nimesh
 * 
 */
public class QuestionNinteen {

	private static final Logger LOG = Logger.getLogger(QuestionNinteen.class
			.getName());
	private static final int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31,
		30, 31, 30, 31 };
	private static int noOfDays = 0;
	private static int startDay = 2;

	/**
	 * This is main class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main class");
		int totalSundayCount = 0;
		boolean leap = false;

		for (int year = 1901; year <= 2000; year++) {
			leap = ((year % 4 == 0));
			for (int month = 0; month <= 11; month++) {
				noOfDays = daysInMonth[month];
				if (month == 1 && leap == true) {
					noOfDays += 1;
				}
				for (int day = 1; day < noOfDays; day++) {
					if (startDay == 8) {
						startDay = 1;
					}
					if (day == 1 && startDay == 1) {
						totalSundayCount++;
					}
					startDay++;
				}
			}
		}
		LOG.info("The total no of sunday is : " + totalSundayCount);
	}

}
