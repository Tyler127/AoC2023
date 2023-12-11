package Day1_Trebuchet;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1_part2 {
    public static void main(String[] args) {
        File file = new File("res/Day1.txt");
        try {
            Scanner scanna = new Scanner(file);

            // Holds the current sum of the numbers
            int sum = 0;

            // Iterate over each line in the input file
            while (scanna.hasNextLine()) {
                String line = scanna.nextLine();

                // Create a list to hold the parsed numbers
                ArrayList<Integer> digitsList = new ArrayList<>();

                // Create a mapping from words to digits
                HashMap<String, Integer> digitMap = new HashMap<>();
                digitMap.put("one", 1);
                digitMap.put("two", 2);
                digitMap.put("three", 3);
                digitMap.put("four", 4);
                digitMap.put("five", 5);
                digitMap.put("six", 6);
                digitMap.put("seven", 7);
                digitMap.put("eight", 8);
                digitMap.put("nine", 9);

                // Create a mapping from combined words to a list of digits
                HashMap<String,Integer[]> combinedDigitsMap = new HashMap<>();
                combinedDigitsMap.put("oneight", new Integer[]{1, 8});
                combinedDigitsMap.put("twone", new Integer[]{2, 1});
                combinedDigitsMap.put("threeight", new Integer[]{3, 8});
                combinedDigitsMap.put("fiveight", new Integer[]{5, 8});
                combinedDigitsMap.put("sevenine", new Integer[]{7, 9});
                combinedDigitsMap.put("eightwo", new Integer[]{8, 2});
                combinedDigitsMap.put("eighthree", new Integer[]{8, 3});
                combinedDigitsMap.put("nineight", new Integer[]{9, 8});

                // Use a regular expression to match digits
                Pattern pattern = Pattern.compile("\\d|" +
                        "oneight|twone|threeight|fiveight|sevenine|eightwo|eighthree|nineight|" +
                        "one|two|three|four|five|six|seven|eight|nine");
                Matcher matcher = pattern.matcher(line);

                // Find and add each digit to the digits list
                while (matcher.find()) {
                    // Find the next regex match in the string
                    String match = matcher.group();
                    int digit;

                    // If matches two combined digits, adds both of them
                    if (combinedDigitsMap.containsKey(match)){
                        Integer[] intsList = combinedDigitsMap.get(match);
                        digitsList.add(intsList[0]);
                        digitsList.add(intsList[1]);
                    }
                    // Check if that match is in the digit map
                    else if (digitMap.containsKey(match)) {
                        digit = digitMap.get(match);
                        digitsList.add(digit);
                    }
                    // If not, it's a digit so parse the int
                    else {
                        digit = Integer.parseInt(match);
                        digitsList.add(digit);
                    }
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
            // GUESS 1: 55061 (too low)
            // CORRECT: 55093
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}