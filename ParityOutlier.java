/*
You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
Examples

[2, 4, 0, 100, 4, 11, 2602, 36]
Should return: 11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21]
Should return: 160 (the only even number)
*/

public class FindOutlier{
  static int find(int[] integers){
    int oddCount, evenCount, temp;
    oddCount = evenCount = temp = 0;
    int[] marker = new int[integers.length];
    for (int i = 0; i < integers.length; i++) {
      if (integers[i] % 2 == 0) {     //find out how many even numbers
        marker[i] = 1;                //and mark outlier in separate array
        evenCount++;
      }
      else {
        marker[i] = 0;                //find out how many odd numbers
        oddCount++;                   //and mark outlier in separate array
      }
    }

    if (evenCount == 1) {
      for (int i = 0; i < integers.length; i++) {
        if (marker[i] == 1) {         //find the even outlier
          return integers[i];
        }
      }
    }
    else {
      for (int i = 0; i < integers.length; i++) {
        if (marker[i] == 0) {         //find the odd outlier
          return integers[i];
        }
      }
    }
    return 0;
  }
}
