/*
    Problem: Detect a cycle in a singly linked list.

    Approach:
    - Use two pointers (slow and fast)
    - slow moves one step at a time
    - fast moves two steps at a time
    - If there is a cycle, both pointers will meet at some point
    - If fast reaches null, then no cycle exists


*/

import java.io.*;
import java.util.*;
public class CycleDetection {

    // Node structure for singly linked list
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to detect cycle in linked list
    static boolean hasCycle(SinglyLinkedListNode head) {

        // Empty list or single node cannot have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        // Two pointers approach
        SinglyLinkedListNode slow = head; // moves one step
        SinglyLinkedListNode fast = head; // moves two steps

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached null, so no cycle
        return false;
    }
}
