package com.lftechnology.labcollectionsquestions;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * 3. Write a program that uses Shuffle algorithm to print the words 
 * in its argument list in random order. Hint: Use List and Collection
 */
/**
 * This class uses Shuffle Algorithm of print the words in random order.
 * 
 * @author nimesh
 */
public class ShuffleAlgorithm {
	private static final Logger LOG = Logger.getLogger(ShuffleAlgorithm.class
			.getName());

	/**
	 * Main method
	 * 
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into Main method ");
		String[] words = { "apple", "ball", "cat", "dog", "elephant", "fish" };
		List<String> listOfWords = new ArrayList<String>();
		for (String word : words) {
			listOfWords.add(word);
		}
		LOG.info("Original list is : " + listOfWords);
		shuffleList(listOfWords);
		LOG.info("Shuffled list is : " + listOfWords);

	}

	/**
	 * This method generates a random number and uses it to change the position
	 * of a word in the original list of strings.
	 * 
	 * @author nimesh
	 * @param a
	 *            {@link List} of {@link String} The list containing all the
	 *            words.
	 */
	private static void shuffleList(List<String> a) {
		LOG.info("Into method shuffleList");
		int n = a.size();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int change = random.nextInt(n - 1);
			swap(a, i, change);
		}
	}

	/**
	 * This method swaps the current index of the word with the randomly
	 * generated number.
	 * 
	 * @author nimesh
	 * @param list
	 *            {@link List} of {@link String} The original list
	 * @param i
	 *            {@link Integer} The index to be swapped
	 * @param change
	 *            {@link Integer} The index to be swapped with.
	 */
	private static void swap(List<String> list, int i, int change) {
		LOG.info("Into method swap");
		String temp = list.get(i);
		list.set(i, list.get(change));
		list.set(change, temp);
	}
}
