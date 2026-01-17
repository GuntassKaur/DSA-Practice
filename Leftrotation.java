/*
    HackerRank: Left Rotation of an Array

    Problem:
    Given an array of integers and a number 'd', perform 'd' left rotations.
    A left rotation moves each element one position to the left, and the
    elements falling off the left end appear at the right end.

    Example:
    arr = [1, 2, 3, 4, 5], d = 2
    After 2 left rotations: [3, 4, 5, 1, 2]

    Approach:
    - Calculate the new index for each element after d rotations
    - Use modulo operation to wrap-around elements
    - Store the result in a new list and return it
*/

import java.util.*;

class Leftrotation {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER d (number of left rotations)
     */
    public static List<Integer> rotLeft(List<Integer> arr, int d) {

        int n = arr.size();
        List<Integer> rotated = new ArrayList<>(Collections.nCopies(n, 0));

        // Shift each element by d positions to the left
        for (int i = 0; i < n; i++) {
            int newIndex = (i - d + n) % n; // wrap-around using modulo
            rotated.set(newIndex, arr.get(i));
        }

        return rotated;
    }
}
