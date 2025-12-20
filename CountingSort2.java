/*
 * HackerRank Problem: Counting Sort 2
 * Link: https://www.hackerrank.com/challenges/countingsort2
 *
 * Task:
 * Given an unsorted array of integers (0 to 99),
 * sort the array using counting sort and print the sorted result.
 *
 * Language: Java 8
 */

import java.util.*;

public class CountingSort2 {

    // Function to return sorted array using counting sort
    public static List<Integer> countingSort(List<Integer> arr) {

        // Frequency array of size 100
        int[] freq = new int[100];

        // Count frequency of each element
        for (int num : arr) {
            freq[num]++;
        }

        // List to store sorted elements
        List<Integer> sortedList = new ArrayList<>();

        // Generate sorted array using frequency count
        for (int i = 0; i < 100; i++) {
            while (freq[i] > 0) {
                sortedList.add(i);
                freq[i]--;
            }
        }

        return sortedList;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of elements
        int n = sc.nextInt();

        // Read input elements
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // Call counting sort function
        List<Integer> result = countingSort(arr);

        // Print sorted result
        for (int val : result) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
