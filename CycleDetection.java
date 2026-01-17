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

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static boolean hasCycle(SinglyLinkedListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

   
}
