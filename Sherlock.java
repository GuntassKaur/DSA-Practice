/*
Problem: Sherlock and Array (Balanced Sums)
Platform: HackerRank
Link: https://www.hackerrank.com/challenges/sherlock-and-array/problem
*/

import java.util.*;

public class Sherlock {

    // Function to check if balanced index exists
    public static String balancedSums(List<Integer> arr) {

        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        long leftSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            long rightSum = totalSum - leftSum - arr.get(i);

            if (leftSum == rightSum) {
                return "YES";
            }

            leftSum += arr.get(i);
        }

        return "NO";
    }

    // Main method for input/output handling
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            System.out.println(balancedSums(arr));
        }

        sc.close();
    }
}
