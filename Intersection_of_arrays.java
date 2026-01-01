/*
Problem: Intersection of Two Arrays (LeetCode 349)

About:
This program finds the common elements between two integer arrays.
Each element in the result appears only once, even if it occurs multiple
times in the input arrays.

How it works:
I used a HashSet because it automatically handles duplicates and allows
fast searching. First, all elements of the first array are stored in a set.
Then the second array is checked element by element. If an element is
already present in the first set, it is added to the result set.
Finally, the result set is converted into an array and returned.

Why this approach:
HashSet makes the solution simple and efficient, avoiding nested loops
and unnecessary comparisons.

Time Complexity:
O(n + m), where n and m are the sizes of the two arrays.

Space Complexity:
O(n), due to the extra HashSet used for storage.
*/

import java.util.HashSet;

class Intersection_of_arrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        // Store elements of the first array
        for (int num : nums1) {
            set1.add(num);
        }

        // Find common elements
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert result set to array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }
}
