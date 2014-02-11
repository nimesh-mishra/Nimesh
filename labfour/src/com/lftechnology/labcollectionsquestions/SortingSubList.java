package com.lftechnology.labcollectionsquestions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * 6. Create an array list with 49 Integer objects 
 * containing the numbers 1 through 49. 
 * It then randomly shuffles the list and selects the first 6 values from the shuffled list.
 *  Finally, it sorts the selected values and prints them out. 
 *  Hint: Use ArrayList, Collections.shuffle(), ArrayList.subList(), and Collection.sort().
 */
/**
 * This class shuffles a list of integer,selects the first six values and sorts
 * them.
 * @author nimesh
 */
public class SortingSubList {
	private static final Logger LOG = Logger.getLogger(SortingSubList.class
			.getName());

	/**
	 * Main Method
	 * 
	 * @author nimesh
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into Main method");
		List<Integer> listOfInteger = new ArrayList<Integer>();
		for (int i = 1; i <= 49; i++) {
			listOfInteger.add(i);
		}
		LOG.info("The list is : " + listOfInteger);
		Collections.shuffle(listOfInteger);
		LOG.info("The shuffled list is : " + listOfInteger);
		List<Integer> subList = listOfInteger.subList(0, 5);
		LOG.info("The sub list is : " + subList);
		Collections.sort(subList);
		LOG.info("The sorted sub list is : " + subList);

	}

}
