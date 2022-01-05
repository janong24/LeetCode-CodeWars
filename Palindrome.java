/* #9
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
    For example, 121 is a palindrome while 123 is not.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int ctr = str.length()-1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(ctr)) return false;
            ctr--;
        }
        return true;
    }
