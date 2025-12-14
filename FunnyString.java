/*
Problem Name: Funny String
Problem Link: https://www.hackerrank.com/challenges/funny-string/problem

This program checks whether a given string is Funny or Not Funny
by comparing absolute differences of adjacent characters
in the original and reversed string.
*/

import java.util.Scanner;

public class FunnyString {

    /*
     * Function to determine whether the string is Funny or Not Funny
     */
    public static String funnyString(String s) {

        int n = s.length();

        // Compare absolute differences for original and reversed string
        for (int i = 0; i < n - 1; i++) {

            int diffOriginal = Math.abs(s.charAt(i) - s.charAt(i + 1));
            int diffReverse = Math.abs(s.charAt(n - 1 - i) - s.charAt(n - 2 - i));

            // If any difference does not match, it's Not Funny
            if (diffOriginal != diffReverse) {
                return "Not Funny";
            }
        }

        return "Funny";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt(); // number of queries
        sc.nextLine(); // consume newline

        // Process each test case
        for (int i = 0; i < q; i++) {
            String s = sc.nextLine();
            System.out.println(funnyString(s));
        }

        sc.close();
    }
}
