/*
Contiguous Subarrays
You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfills the following conditions:
The value at index i must be the maximum element in the contiguous subarrays, and
These contiguous subarrays must either start from or end on index i.
Signature
int[] countSubarrays(int[] arr)
Input
Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
Size N is between 1 and 1,000,000
Output
An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
Example:
arr = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]
Explanation:
For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 - [1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]
 */

import java.util.Arrays;
import java.util.Stack;

public class ContiguousSubarr {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 6, 2};            //expected = [1, 3, 1, 5, 1]
        //int[] arr = {2, 4, 7, 1, 5, 3};       //expected = [1, 2, 6, 1, 3, 1]
        //print out your subArray counter
        System.out.println(Arrays.toString(countSubarrays(arr)));
    }

    public static int[] countSubarrays(int[] arr) {
        int[] subArr = new int[arr.length];         //stores max # of contiguous subarrays
        Stack<Integer> stack = new Stack<>();       //create a stack

        for(int i = 0; i < arr.length; i++) {
            if(i == 0 || i == arr.length-1 || arr[i] == 1)  {       //if at the edges or 1
                subArr[i] = 1;                      //count the stack
                stack.clear();                      //empty the stack
            }
            else{
                for(int x = i; x >= 0; x--) {        //traverse to the left
                    if (arr[x] <= arr[i]) {         //if smaller
                        stack.push(arr[x]);         //push to stack
                    }
                    else {
                        break;                      //if bigger, break loop
                    }
                }
                for(int x = i+1; x < arr.length; x++) {   //traverse to the right
                    if (arr[x] <= arr[i]) {             //if smaller
                        stack.push(arr[x]);             //push to the stack
                    }
                    else {
                        break;                          //if bigger, break loop
                    }
                }
                subArr[i] = stack.size();               //count the stack
                stack.clear();                          //empty the stack
            }
        }
        return subArr;
    }
}
