/*
    HackerRank Question: Reverse a Singly Linked List

    Problem:
    Given the head of a singly linked list, reverse the list and
    return the head of the reversed list.

    Input:
    A singly linked list of integers.

    Output:
    The reversed linked list.

    Approach:
    - Traverse the list once
    - Reverse the links by changing next pointers
    - Keep track of previous, current, and next nodes
    - Return the new head at the end

    Time Complexity: O(n)
    Space Complexity: O(1)
*/

import java.io.*;
import java.util.*;

public class Reverselinkedlist {

    // Node definition
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse function (HackerRank accepted)
    static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = llist;
        SinglyLinkedListNode next = null;

        // Iterate through the list and reverse links
        while (curr != null) {
            next = curr.next;    // store next node
            curr.next = prev;    // reverse current link
            prev = curr;         // move prev forward
            curr = next;         // move current forward
        }

        // prev becomes new head
        return prev;
    }

    // Helper function to print list
    static void printList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        //sample test case
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);

        SinglyLinkedListNode reversedHead = reverse(head);
        printList(reversedHead);
    }
}
