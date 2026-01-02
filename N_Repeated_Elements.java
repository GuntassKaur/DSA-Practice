# LeetCode 961 – N-Repeated Element in Size 2N Array

## Problem
Given an integer array `nums` of size `2N`, exactly one element is repeated `N` times, while all other elements appear only once.  
Return the element that is repeated `N` times.

---

## Explanation
To find the repeated element, we keep track of the values we have already seen.

A `HashSet` is used because it does not allow duplicate values. While iterating through the array, each element is added to the set. If an element is already present, it means this value has appeared before and is the required answer.

---

## Approach
- Create an empty `HashSet`
- Traverse the array
- Add each element to the set
- If an element already exists in the set, return it immediately

---

## Java Solution

```java
import java.util.HashSet;

class N_Repeated_Elements {
    public int repeatedNTimes(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            if (!set.add(x)) {
                return x;
            }
        }

        return -1; // unreachable as per problem constraints
    }
}
