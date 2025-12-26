/*
  Problem Name: Two Sum
Platform: LeetCode (Problem #1)
Topic: Arrays, HashMap
Language: Java
Difficulty: Easy
========================================

Problem Statement:
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

Conditions:
- Each input has exactly one solution
- Same element cannot be used twice
- Answer can be in any order

Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Approach Used:
- HashMap (Complement Technique)
- Store each number with its index
- For every element, check if (target - currentElement) exists

Time Complexity:
O(n)

Space Complexity:
O(n)
*/
  import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        // HashMap to store number and its index
        HashMap<Integer, Integer> h = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Find the required complement
            int comp = target - nums[i];

            // If complement already exists, return indices
            if (h.containsKey(comp)) {
                return new int[] { h.get(comp), i };
            }

            // Store current number with its index
            h.put(nums[i], i);
        }

        // Dummy return (problem guarantees one solution)
        return new int[] {};
    }
}
