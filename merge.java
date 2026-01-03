/*
LeetCode 88: Merge Sorted Array

PROBLEM:
You are given two sorted integer arrays nums1 and nums2.
nums1 has a size of m + n, where the first m elements are valid.
nums2 has n elements.

Merge nums2 into nums1 as one sorted array.
The final sorted array should be stored inside nums1 itself.

------------------------------------------------------------

APPROACH (Two Pointer – Backward Merge):

We merge the arrays from the end to avoid overwriting
the existing elements in nums1.

Pointers:
i -> last valid element of nums1 (m - 1)
j -> last element of nums2 (n - 1)
k -> last index of nums1 (m + n - 1)

Steps:
1. Compare nums1[i] and nums2[j]
2. Place the larger element at nums1[k]
3. Move pointers accordingly
4. If nums2 still has elements left, copy them into nums1

------------------------------------------------------------

WHY BACKWARD MERGE?
Because nums1 already has extra space at the end.
Merging from the front may overwrite useful data.

------------------------------------------------------------

TIME COMPLEXITY:  O(m + n)
SPACE COMPLEXITY: O(1)

------------------------------------------------------------
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;          // pointer for nums1 valid part
        int j = n - 1;          // pointer for nums2
        int k = m + n - 1;      // pointer for final position

        // merge while both arrays have elements
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // copy remaining elements of nums2 (if any)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
