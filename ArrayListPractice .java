import java.util.*;

/*
 * Program: ArrayList User Input
 * Author: Guntass Kaur
 * Description:
 * This program takes names from the user using Scanner
 * and stores them in an ArrayList until an empty input is entered.
 * 
 * Concepts Used:
 * - ArrayList
 * - Scanner
 * - while loop
 * - break statement
 */

public class ArrayListPractice {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();

        // Taking user input
        while (true) {
            System.out.println("Enter a name (press Enter to stop):");
            String s = scan.nextLine();

            if (s.equals("")) {
                break;
            }

            al.add(s);
        }

        // Output
        System.out.println("Names entered: " + al);
        System.out.println("Total names: " + al.size());
    }
}
