/*
 * Problem: Valid Parentheses
 * Platform: LeetCode
 * Approach: Stack (LIFO)
 *
 * Logic:
 * - Push opening brackets into stack
 * - On closing bracket:
 *   - Stack must not be empty
 *   - Top of stack must be matching opening bracket
 * - At end, stack should be empty
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;

class parenthesis_check{
    public boolean isValid(String s) {

        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse each character of the string
        for (char ch : s.toCharArray()) {

            // If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If closing bracket
            else {

                // If stack is empty, no opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                // Remove last opening bracket
                char top = stack.pop();

                // Check if brackets match
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }

        // If stack is empty, all brackets are matched correctly
        return stack.isEmpty();
    }
}
