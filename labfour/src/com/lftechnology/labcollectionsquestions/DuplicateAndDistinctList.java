package com.lftechnology.labcollectionsquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 2. Suppose you want to know which words in the argument list occur only once
 *  and which occur more than once, but you do not want any duplicates printed out repeatedly. 
 *  This effect can be achieved by generating two sets one containing every word 
 *  in the argument list and the other containing only the duplicates. 
 *  The words that occur only once are the set difference of these two sets
 */
/**
 * This class creates two list: one containing all words and one containing
 * repeated words.
 * @author nimesh
 */
public class DuplicateAndDistinctList {
	private static final Logger LOG = Logger
			.getLogger(DuplicateAndDistinctList.class.getName());
	/**
	 * Main Method
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into Main Class");
		String[] setOfWord = { "abc", "bca", "abc", "dog", "elephant", "dog" };
		List<String> listOfAllWords = new ArrayList<String>();
		List<String> singleWords = new ArrayList<String>();
		for (String str : setOfWord) {
			listOfAllWords.add(str);
		}
		for (String word : listOfAllWords) {
			if (Collections.frequency(listOfAllWords, word) == 1) {
				singleWords.add(word);
			}
		}
		LOG.info("The list of all words are : " + listOfAllWords);
		LOG.info("Words with single occurance are : " + singleWords);
	}
}
