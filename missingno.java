/*
Problem: Missing Numbers
Platform: HackerRank
Link: https://www.hackerrank.com/challenges/missing-numbers/problem
*/

import java.util.*;

public class missingno {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {

        int min = Collections.min(brr);
        int[] freq = new int[101];

        for (int i = 0; i < brr.size(); i++) {
            freq[brr.get(i) - min]++;
        }

        for (int i = 0; i < arr.size(); i++) {
            freq[arr.get(i) - min]--;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result.add(i + min);
            }
        }

        return result;
    }

    // MAIN METHOD (needed for local / custom run)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Integer> brr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            brr.add(sc.nextInt());
        }

        List<Integer> ans = missingNumbers(arr, brr);

        for (int num : ans) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
