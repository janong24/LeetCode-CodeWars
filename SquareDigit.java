/*
Welcome. In this kata, you are asked to square every digit of a number and concatenate them.
For example, if we run 9119 through the function, 811181 will come out, because 9^2 is 81 and 1^2 is 1.
Note: The function accepts an integer and returns an integer
*/

public class SquareDigit {

  public int squareDigits(int n) {
      String str = String.valueOf(n);
      int m;
      String output = ""; 
      for (int x = 0; x < str.length(); x++) {
          m = Integer.parseInt(Character.toString(str.charAt(x)));
          output = output + String.valueOf(m*m);
      }
      return Integer.parseInt(output);
  }

}
