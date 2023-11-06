//author: Erblin Berisha

/*created for a friend who needed to know which ingredients in
 * a cookbook come up the most.*/

import java.util.*;
import java.io.*;

public class WordCounter3000 {
    public static void main(String[] args) {
        //specify the file path
        String filePath = "c:/Users/Erblin/Desktop/tester.txt";

        //create a hashmap to store word frequencies
        Map<String, Integer> wordFrequency = new HashMap<>();

        //wrap filereader in bufferedreader for efficient reading
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            //read lines from the file until there are no more lines
            while ((line = br.readLine()) != null) {
                //split the line into words using spaces as separators
                String[] words = line.split("\\s+");

                //update word frequencies in the hashmap
                for (String word : words) {
                    word = word.toLowerCase(); //convert to lowercase to ensure case-insensitive comparison
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            //print all words and their frequencies
            System.out.println("Word frequencies:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        } catch (IOException e) {
            //handle errors
            e.printStackTrace();
        }
    }
}

