package com.lftechnology.labcollectionsquestions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 a. Create a linked list named one and two. 
 b. Add some elements to both one (one, two, three, four, five) and two (six, seven, eight, nine, and ten). 
 c. Merge the words from two into one.
 d. Remove every second word from two.
 e. Remove all words in two from one.
 f. Print the value after each operation.
 */
/**
 * This class performs the above mentioned operations.
 * 
 * @author nimesh
 */
public class ListOperations {
	private static final Logger LOG = Logger.getLogger(ListOperations.class
			.getName());

	/**
	 * Main method
	 * 
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("into main method");
		String[] first = { "one", "two", "three", "four", "five" };
		String[] second = { "six", "seven", "eight", "nine", "ten" };
		List<String> one = new LinkedList();
		List<String> two = new LinkedList();
		for (String firstlist : first) {
			one.add(firstlist);
		}
		for (String secondlist : second) {
			two.add(secondlist);
		}
		LOG.info("merging list one to list two");
		one.addAll(two);
		LOG.info("The words in list one are : " + one);
		LOG.info("Removing every second word from two");
		Iterator iter = two.iterator();
		int i = 1;
		while (iter.hasNext()) {
			iter.next();
			i++;
			if (i % 2 == 0) {
				iter.remove();
			}
		}
		LOG.info("The words in list two are : " + two);
		LOG.info("Removing all the words in two from one ");
		one.removeAll(two);
		LOG.info("The words in list one after removal are : " + one);
	}

}
