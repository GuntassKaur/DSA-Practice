# LeetCode 17 – Letter Combinations of a Phone Number

## Problem Description
You are given a string `digits` containing numbers from `2` to `9`.  
Each digit maps to a set of letters just like a phone keypad.

Your task is to return **all possible letter combinations** that the number could represent.

If the input string is empty, return an empty list.

---

## Explanation (Simple & Clear)
Each digit has some letters linked to it:
- 2 → abc
- 3 → def
- 4 → ghi
- 5 → jkl
- 6 → mno
- 7 → pqrs
- 8 → tuv
- 9 → wxyz

We generate combinations by:
- Picking one letter from the current digit
- Moving to the next digit
- Repeating this until all digits are used

When all digits are covered, the formed string is a valid combination.

This is done using **recursion (backtracking)**.

---

## Approach
1. Store digit-to-letter mapping in an array.
2. Start from index `0` with an empty string.
3. For the current digit, try all its letters.
4. Add one letter and move to the next digit.
5. When all digits are processed, store the combination.

---

## Java Code (LeetCode)

```java
import java.util.*;

class Keypad {

    String[] map = {
        "", "",        // 0 and 1
        "abc", "def",  // 2, 3
        "ghi", "jkl",  // 4, 5
        "mno", "pqrs", // 6, 7
        "tuv", "wxyz"  // 8, 9
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0)
            return result;

        solve(digits, 0, "", result);
        return result;
    }

    void solve(String digits, int index, String current, List<String> result) {

        if (index == digits.length()) {
            result.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            solve(digits, index + 1, current + letters.charAt(i), result);
        }
    }
}
