/*
Problem: Pyramid Transition Matrix

You are given a string `bottom` representing the bottom row of blocks.
You are also given a list `allowed` where each string of length 3 represents
a valid triangular pattern.

The first two characters are the left and right bottom blocks,
and the third character is the block that can be placed on top.

The pyramid is built upward such that:
- Each upper row has one less block than the row below
- Every adjacent pair of blocks must form a valid pattern from `allowed`

Return true if the pyramid can be built all the way to the top, else false.

Example:
bottom = "BCD"
allowed = ["BCC","CDE","CEA","FFF"]
Output: true

Approach:
1. Store all allowed patterns in a HashMap where:
   key   = pair of bottom blocks (length 2 string)
   value = list of possible top blocks
2. Use DFS + Backtracking to try all valid combinations for each level.
3. If we reach a row of length 1, the pyramid is successfully built.
4. If any path works, return true.

This is a classic backtracking problem.
*/

import java.util.*;

class PyramidTransitionMatrix {

    // Map to store allowed transitions
    // Example: "AB" -> ['C', 'D']
    private Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        // Build the transition map
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        // Start DFS from the bottom row
        return dfs(bottom);
    }

    // Recursive DFS function
    private boolean dfs(String current) {

        // Base case: reached the top
        if (current.length() == 1) {
            return true;
        }

        // Generate all possible next rows
        List<String> nextRows = new ArrayList<>();
        buildNextRow(current, 0, new StringBuilder(), nextRows);

        // Try each possible next row
        for (String next : nextRows) {
            if (dfs(next)) {
                return true;
            }
        }

        return false;
    }

    // Helper function to build next level strings
    private void buildNextRow(String curr, int index,
                              StringBuilder path, List<String> result) {

        // If full row is built
        if (index == curr.length() - 1) {
            result.add(path.toString());
            return;
        }

        String key = curr.substring(index, index + 2);

        // If no valid transition exists
        if (!map.containsKey(key)) return;

        // Try all possible top blocks
        for (char c : map.get(key)) {
            path.append(c);
            buildNextRow(curr, index + 1, path, result);
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }
}

/*
Time Complexity:
Exponential in worst case because we try all possible valid combinations
for each level of the pyramid.
However, constraints are small, so this works efficiently.

Space Complexity:
O(N) for recursion stack, where N is the length of the bottom string.
Additional space is used for storing transitions.
*/
