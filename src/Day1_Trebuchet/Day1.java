package Day1_Trebuchet;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        File file = new File("res/Day1.txt");
        try {
            Scanner scanna = new Scanner(file);

            // Holds the current sum of the numbers
            int sum = 0;

            // Iterate over each line in the input file
            while (scanna.hasNextLine()) {
                String line = scanna.nextLine();

                // Create a list to hold the parsed digits
                ArrayList<Integer> digitsList = new ArrayList<>();

                // Split the line into an array of characters
                String[] lineCharacters = line.split("");

                // Iterate over each character in the line
                for (String s : lineCharacters) {
                    // Attempt to parse an int from the character
                    int currentDigit;
                    try {
                        currentDigit = Integer.parseInt(s);
                    }
                    // If a NumberFormatException occurs continue to the next character
                    catch (NumberFormatException e) {
                        continue;
                    }

                    digitsList.add(currentDigit);
                }

                // Get the first and last digits in the line
                int firstDigit = digitsList.get(0);
                int lastDigit = digitsList.get(digitsList.size() - 1);

                // Create the final number using the first and last digits in the line
                String finalNumberString = firstDigit + "" + lastDigit;
                int finalNumber = Integer.parseInt(finalNumberString);

                // Add to the running sum
                sum += finalNumber;
            }

            // Print the final sum
            System.out.println("Sum of All Numbers: " + sum);
            // CORRECT: 55002
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}