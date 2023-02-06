import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** 
 * COMP 2503 Winter 2023 Assignment 1 
 * 
 * This program must read a input stream and keeps track of the 
 * frequency at which an avenger is mentioned either by name or alias.
 *
 * @author Maryam Elahi
 * @date Winter 2023
*/


public class A1 {

	public String[][] avengerRoster = { { "captainamerica", "rogers" }, { "ironman", "stark" },
			{ "blackwidow", "romanoff" }, { "hulk", "banner" }, { "blackpanther", "tchalla" }, { "thor", "odinson" },
			{ "hawkeye", "barton" }, { "warmachine", "rhodes" }, { "spiderman", "parker" },
			{ "wintersoldier", "barnes" } };

	private int topN = 4;
	private int totalwordcount = 0;
	private ArrayList<Avenger> listOfAvengers = new ArrayList<>();
	

	public static void main(String[] args) throws FileNotFoundException {
		A1 a1 = new A1();
		a1.run();
	}

	public void run() throws FileNotFoundException {
		readInput();
		printResults();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	}
		
	}

	/**
	 * read the input stream and keep track  
	 * how many times avengers are mentioned by alias or last name.
	 * @throws FileNotFoundException 
	 */
	
	private void readInput() throws FileNotFoundException {
		/*
		In a loop, while the scanner object has not reached end of stream,
		 	- read a word. ****Done****
		 	- clean up the word  ****Done****
		    - if the word is not empty, add the word count. 
		    - Check if the word is either an avenger alias or last name then
				- Create a new avenger object with the corresponding alias and last name.
				- if this avenger has already been mentioned, increase the frequency count for the object already in the list.
				- if this avenger has not been mentioned before, add the newly created avenger to the list, remember to set the frequency.
		*/ 
		
		//Get the file
		File file = new File("./A1Starter Code and Sample Input Output\\input4.txt");
        Scanner sc = new Scanner(file);
        String cleanedString = "";
        
        while (sc.hasNext()) {
            String word = sc.next();
            if (word != null) { // check to make sure word is not null, in case of error
                word = word.trim(); // trim off blank spaces
	            if (!word.equals("")) { // check for blank word 
	            
		            //remove apostrophe
		            int index = word.indexOf("'"); 
		            if (index > 0) 
		            	word = word.substring(0,index);
		
		            // Remove special characters and convert to lower case
		            word = word.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		            cleanedString = word;
		            
		            for (int i = 0; i < avengerRoster.length; i++) {
		                for (int j = 0; j < avengerRoster[i].length; j++) {
		                    if (word.equals(avengerRoster[i][j])) {
		                        Avenger currentAvenger = new Avenger(avengerRoster[i][0], avengerRoster[i][1], 1);
		                        int index1 = listOfAvengers.indexOf(currentAvenger);
		                        if (index1 == -1) {
		                            listOfAvengers.add(currentAvenger);
		                        } else {
		                            listOfAvengers.get(index1).setFrequency(listOfAvengers.get(index1).getFrequency() + 1);
		                        }
		                    }
		                }
		                
		            }
	            	totalwordcount++;
	            }
            }
        }
	}
	
	/**
	 * print the results
	 */
	
	private void printResults() {
		
		if (listOfAvengers.size() < 4) {
			topN = listOfAvengers.size();
		}
		
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " +  listOfAvengers.size());
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		for (int i = 0; i < listOfAvengers.size(); i++) {
			System.out.println(listOfAvengers.get(i).toString());
		}
		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers:");
		Avenger.sortByFrequency = true;
		Collections.sort(listOfAvengers, Collections.reverseOrder()); // sort the list in descending order, which is most to least popular
		for (int i = 0; i < topN; i++) {
			System.out.println(listOfAvengers.get(i).toString());
		}
		System.out.println();

		System.out.println("Top " + topN + " least popular avengers:");
		Avenger.sortByFrequency = true;
		Collections.sort(listOfAvengers); //sort the list in ascending order, which is least to most popular
		for (int i = 0; i < topN; i++) {
			System.out.println(listOfAvengers.get(i).toString());
		}
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order:");
		Avenger.sortByFrequency = false;
		Collections.sort(listOfAvengers); //sort by alphabetical order of the alias 
		for (int i = 0; i < listOfAvengers.size(); i++) {
			System.out.println(listOfAvengers.get(i).toString());
		}
		System.out.println();
	}
}
