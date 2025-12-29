/*
LeetCode 1351: Count Negative Numbers in a Sorted Matrix

Problem:
Given an m x n matrix `grid` which is sorted in non-increasing order
both row-wise and column-wise, return the number of negative numbers
in the matrix.

Example 1:
Input:  grid = [[4,3,2,-1],
                [3,2,1,-1],
                [1,1,-1,-2],
                [-1,-1,-2,-3]]
Output: 8

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0

Approach (O(m + n)):
- Start from the top-right corner of the matrix.
- If the current element is negative:
    → All elements below it in the same column are also negative.
    → Count them and move left.
- If the current element is non-negative:
    → Move down.
- Each step moves either left or down, so total steps ≤ m + n.

This approach avoids scanning every element.
*/

class CountNegativeNumbersInASortedMatrix {

    public int countNegatives(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int row = 0;
        int col = n - 1;
        int count = 0;

        while (row < m && col >= 0) {

            if (grid[row][col] < 0) {
                // All elements below this are negative
                count += (m - row);
                col--;
            } else {
                // Move down to find negatives
                row++;
            }
        }

        return count;
    }
}

/*
Time Complexity:
O(m + n)
Each step moves either one row down or one column left.

Space Complexity:
O(1)
No extra space is used.
*/
