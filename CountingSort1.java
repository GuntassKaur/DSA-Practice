/*
 * HackerRank Problem: Counting Sort 1
 * Link: https://www.hackerrank.com/challenges/countingsort1
 *
 * Description:
 * Given a list of integers where each value lies between 0 and 99,
 * count the frequency of each number and return a frequency array of size 100.
 *
 * Language: Java 8
 */

import java.util.*;

public class CountingSort1 {

    // Function to perform counting sort frequency calculation
    public static int[] countingSort(List<Integer> arr) {

        // Step 1: Create a frequency array of size 100
        int[] freq = new int[100];

        // Step 2: Count frequency of each element
        for (int num : arr) {
            freq[num]++;
        }

        // Step 3: Return the frequency array
        return freq;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of elements
        int n = sc.nextInt();

        // Read elements into list
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // Call counting sort function
        int[] result = countingSort(arr);

        // Print the frequency array
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}
