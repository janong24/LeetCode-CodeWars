/*
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
Examples

pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !
*/

public class PigLatin {
    public static String pigIt(String str) {
        String temp = "";
        String newString = "";
        char firstLetter = ' ';
        String[] words = str.split("\\s+"); //convert String to words
        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();  //convert word to array
            firstLetter = ch[0];            //store first letter
            temp = words[i].substring(1);   //move letters one position up
            if (Character.isLetter(firstLetter)) {
              temp += firstLetter + "ay";     //append firstLetter and "ay"
            }
            else {
              temp += firstLetter;            //append firstLetter only if non-letter
            }
            words[i] = temp;                //append to newString
        }
        newString += words[0];              //add spaces to words
        for (int i = 1; i < words.length; i++) {
          newString += " " + words[i];
        }
        return newString;
    }
}
