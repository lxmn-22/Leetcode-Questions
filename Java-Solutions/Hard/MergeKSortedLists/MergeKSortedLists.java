package Hard.MergeKSortedLists;

import java.util.*;

/*
 * PROBLEM: 23: Merge k Sorted Lists
 * 
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int step = 1;
        while (step < lists.length) {
            for (int i = 0; i < lists.length - step; i += step * 2) {
                lists[i] = merge2Lists(lists[i], lists[i + step]);
            }
            step *= 2;
        }
        // Return the merged list head.
        return lists[0];
    }

    private ListNode merge2Lists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode previous = dummy;

        // Traverse over the lists until both or one of them becomes null
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                // Add l1 node to the list
                previous.next = head1;
                head1 = head1.next;
            } else {
                // Add l2 node to the list
                previous.next = head2;
                head2 = head2.next;
            }
            // Move the prev pointer forward
            previous = previous.next;
        }

        // If either list still has nodes left, append them
        if (head1 != null) {
            previous.next = head1;
        } else {
            previous.next = head2;
        }
        // Return the merged list
        return dummy.next;
    }
}