/* #17
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

 */

import java.util.*;

public class LetterCombo {
    //map letters to the numbers on the keypad
    //use 0 and 1 as placeholders to compensate for Java's zero-based arrays
    final static String LETTERS[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Please input the digits: ");
        String userInput = kb.nextLine();

        //convert the string array to an int array
        int[] intArray = Arrays.stream(userInput.split("")).mapToInt(Integer::parseInt).toArray();

        ArrayList<String> combinations = new ArrayList<>();         //arraylist will store all possible combinations
        Queue<String> queue = new LinkedList<>();                   //create a linked-list based queue
        queue.add("");                                              //add a fake value into queue so it won't be empty
        while(!queue.isEmpty()) {
            String s = queue.remove();                              //remove fake value
            if (s.length() == intArray.length)                      //if a combination is equal to the expected length
                combinations.add(s);                                //then add it to the arraylist
            else {
                String val = LETTERS[intArray[s.length()]];         //get letters from digit grouping; i.e. 2 = abc
                for (int i = 0; i < val.length(); i++)              //iterate through the queue
                {
                    queue.add(s + val.charAt(i));                   //append the letter
                }
            }
        }
        for (String combo:combinations) {                           //print out your combinations
            System.out.println(combo);
        }
    }
}
