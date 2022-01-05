/*
Complete the solution so that the function will break up camel casing, using a space between words.
Example

"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""
*/

class Solution {
  public static String camelCase(String input) {
    String[] inputArr = input.split("(?=\\p{Upper})");  //split input at capital letters
    String output = inputArr[0];                        //append first word to output
    for (int i = 1; i < inputArr.length; i++) {
      output += " " + inputArr[i];                      //add spaces between words
    }
    return output;
  }
}
