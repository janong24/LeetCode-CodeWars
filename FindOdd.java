/*
Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.
Examples

[7] should return 7, because it occurs 1 time (which is odd).
[0] should return 0, because it occurs 1 time (which is odd).
[1,1,2] should return 2, because it occurs 1 time (which is odd).
[0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindOdd {
    public static int findIt(int[] a) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if(!list.contains(a[i])) {
                stack.push(a[i]);
            }
            for (int j = i+1; j < a.length; j++) {
                if (stack.isEmpty()) {
                    break;
                }
                else if(stack.peek() == a[j]) {
                    stack.push(a[j]);
                }
            }
            if (stack.size() % 2 == 1) {
                return stack.pop();
            }
            else {
                stack.clear();
                list.add(a[i]);
            }
        }
        return 0;
    }
}
