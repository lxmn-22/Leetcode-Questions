package Medium.SortList;

import java.util.*;

/*
 * PROBLEM: 148: Sort List
 * 
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
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
class SortList {
    public ListNode sortList(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode r = temp;
        ListNode t = head;
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        int res[] = new int[l];
        int p = 0;
        head = t;

        while (head != null) {
            res[p] = head.val;
            head = head.next;
            p++;
        }
        Arrays.sort(res);
        for (int i = 0; i < l; i++) {
            r.next = new ListNode(res[i]);
            r = r.next;
        }
        return temp.next;
    }
}