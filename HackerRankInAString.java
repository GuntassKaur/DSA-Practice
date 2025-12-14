/*
Problem Name: HackerRank in a String!
Problem Link: https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem

This program checks whether the string "hackerrank"
exists as a subsequence in the given input string.
*/

import java.util.Scanner;

public class HackerRankInAString {

    /*
     * Function to check if "hackerrank" is a subsequence of string s
     * Returns "YES" if found, otherwise "NO"
     */
    public static String hackerrankInString(String s) {

        String target = "hackerrank";
        int j = 0; // pointer for target string

        // Traverse through input string
        for (int i = 0; i < s.length() && j < target.length(); i++) {
            // If characters match, move target pointer
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
        }

        // If all characters of target are found in order
        if (j == target.length()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt(); // number of queries
        sc.nextLine(); // consume leftover newline

        // Process each query
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            System.out.println(hackerrankInString(s));
        }

        sc.close();
    }
}
