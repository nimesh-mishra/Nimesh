package com.lftechnology.labcollectionsquestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
/**
 * 1. Takes the words in its argument list and prints out any duplicate words,
 *  the number of distinct words, and a list of the words with duplicates eliminated. 
 *  Hint: Try with HashSet and List implementation.
 */
/**
 * This class prints the duplicate,distinct and list of words with duplicate
 * eliminated.
 * @author nimesh
 */
public class HashSetAndListImplementation {
	private static final Logger LOG = Logger
			.getLogger(HashSetAndListImplementation.class.getName());
	/**
	 * Main function
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main function");
		List<String> listOfWords = new ArrayList<String>();
		listOfWords.add("one");
		listOfWords.add("two");
		listOfWords.add("one");
		listOfWords.add("two");
		listOfWords.add("three");
		Iterator iterator;
		List<String> distinctList = new ArrayList<String>(new HashSet<String>(
				listOfWords));
		List<String> duplicateWords = new ArrayList<String>();
		for (String str : listOfWords) {
			if ((Collections.frequency(listOfWords, str)>1)&& (!duplicateWords.contains(str))){
				duplicateWords.add(str);
			}
		}
		LOG.info("showing duplicate words:");
		iterator = duplicateWords.iterator();
		while (iterator.hasNext()) {
			LOG.info("" + iterator.next());
		}
		LOG.info("Showing distinct words : ");
		iterator = distinctList.iterator();
		while (iterator.hasNext()) {
			LOG.info("" + iterator.next());
		}
	}

}
