/*
--------------------------------------------------
LeetCode 7: Reverse Integer
--------------------------------------------------
Problem:
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit
integer range [-2^31, 2^31 - 1], then return 0.

Examples:
Input: 123
Output: 321

Input: -120
Output: -21

--------------------------------------------------
Best Approach (Mathematical Method):
1. Extract last digit using x % 10.
2. Reduce number using x / 10.
3. Build reverse number using rev = rev * 10 + digit.
4. Before updating rev, check for overflow.
--------------------------------------------------
Time Complexity: O(n)  (n = number of digits)
Space Complexity: O(1) (constant extra space)
--------------------------------------------------
*/

class Reverse{

    public int reverse(int x) {

        int rev = 0;

        while (x != 0) {

            int digit = x % 10;
            x = x / 10;

            // Overflow check
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }
}
