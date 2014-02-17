package projecteuler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Using names.txt, a 46K text file containing over five-thousand first names, 
 *begin by sorting it into alphabetical order. 
 *Then working out the alphabetical value for each name, 
 *multiply this value by its alphabetical position in the list to obtain a name score.

 For example, when the list is sorted into alphabetical order, COLIN, 
 which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 So, COLIN would obtain a score of 938 × 53 = 49714.

 What is the total of all the name scores in the file? 
 */
/**
 * This class finds the total of all names scores in the file names.txt
 * 
 * @author nimesh
 * 
 */
public class QuestionTwentyTwo {
	private static final Logger LOG = Logger.getLogger(QuestionTwentyTwo.class
			.getName());

	/**
	 * This is main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Into main method");
		File file = new File("src/projecteuler/names.txt");
		int totalSum = 0;
		if (file.exists() && file.isFile()) {
			try {
				Scanner scan = new Scanner(file).useDelimiter("[\",]+");
				List<String> listOfNames = new ArrayList<String>();
				while (scan.hasNext()) {
					listOfNames.add(scan.next());
				}
				Collections.sort(listOfNames);
				for (int i = 0; i < listOfNames.size(); i++) {
					int nameSum = 0;
					String name = listOfNames.get(i);
					for (int j = 0; j < name.length(); j++) {
						int charValue = name.charAt(j);
						charValue -= 'A';
						nameSum += charValue + 1;
					}
					totalSum += (nameSum * (i + 1));
				}
				LOG.info("The total score is : " + totalSum);
			} catch (FileNotFoundException e) {
				LOG.log(Level.SEVERE,
						"Exception occurred @ main method while using scanner.");
				LOG.log(Level.SEVERE,
						"The error message is : " + e.getMessage());
			}

		}

	}

}
