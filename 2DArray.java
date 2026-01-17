/*
    HackerRank: 2D Array – Hourglass Sum

    Problem:
    You are given a 6x6 2D array.
    An hourglass in the array has the following shape:

        a b c
          d
        e f g

    The hourglass sum is the sum of these 7 elements.
    Find the maximum hourglass sum present in the array.

    Approach:
    - Traverse only valid hourglass starting points (0 to 3)
    - Calculate sum for each hourglass
    - Keep track of the maximum sum

    Time Complexity: O(1)
    Space Complexity: O(1)
*/

import java.util.*;

class 2DArray {

    // Returns the maximum hourglass sum
    public static int hourglassSum(List<List<Integer>> arr) {

        // Handles negative values in the array
        int maxSum = Integer.MIN_VALUE;

        // Loop through all possible hourglasses
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {

                int currentSum =
                        arr.get(i).get(j)     + arr.get(i).get(j + 1)     + arr.get(i).get(j + 2)
                                              + arr.get(i + 1).get(j + 1)
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                // Update maximum sum
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }
}



