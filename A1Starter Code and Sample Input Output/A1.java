import java.util.ArrayList;
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
	private ArrayList<Avenger> avengersArrayList = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		A1 a1 = new A1();
		a1.run();
	}

	public void run() throws FileNotFoundException {
		readInput();
		printResults();
		
	}

	/**
	 * read the input stream and keep track  
	 * how many times avengers are mentioned by alias or last name.
	 * @throws FileNotFoundException 
	 */
	ArrayList<Avenger> listOfAvengers = new ArrayList<>();
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
		File file = new File("./A1Starter Code and Sample Input Output\\input2.txt");
        Scanner sc = new Scanner(file);
        String cleanedString = "";
        
        //Add all the Avengers to the ArrayList listOfAvengers 
		/*
		 * for (int i = 0; i < avengerRoster.length; i++) { listOfAvengers.add(new
		 * Avenger(avengerRoster[i][0], avengerRoster[i][1], 0)); }
		 */
        while (sc.hasNext()) {
            String word = sc.next();
            
            //remove apostrophe
            int index = word.indexOf("'"); 
            if (index > 0) 
            	word = word.substring(0,index);
			
            
            // Remove special characters and convert to lowercase
            word = word.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            cleanedString = word;
            System.out.print(cleanedString + " ");
            /*
            for (int i = 0; i < avengerRoster.length; i++) {
                for (int j = 0; j < avengerRoster[i].length; j++) {
                    if (word.equals(avengerRoster[i][j])) {
                    	for (int k = 0; k < listOfAvengers.size(); k++) {
                    		if (!listOfAvengers.contains(new Avenger(avengerRoster[i][0], avengerRoster[i][1], 0))) {
                    			listOfAvengers.add(new Avenger(avengerRoster[i][0], avengerRoster[i][1], 0));
                    		}
                    		else {
                    			
                    			listOfAvengers.get(k).setFrequency(listOfAvengers.get(k).getFrequency() + 1); //increase the frequency by 1
                    		}
                    	}
                    }
                }
            }
            */
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
        
        //temporary print to make sure everything works DELETE THIS******
        System.out.println(cleanedString);
        System.out.println(listOfAvengers);

        
	}
	

	/**
	 * print the results
	 */
	private void printResults() {
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + avengersArrayList.size());
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream: \n");
		for (int i = 0; i < listOfAvengers.size(); i++) {
			System.out.println(listOfAvengers.get(i).toString());
		}
		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers: \n");
		// Todo: Print the most popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		System.out.println();

		System.out.println("Top " + topN + " least popular avengers: \n");
		// Todo: Print the least popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output		
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order: \n");
		// Todo: Print the list of avengers in alphabetical order
		// Make sure you follow the formatting example in the sample output
		System.out.println();
	}
}
