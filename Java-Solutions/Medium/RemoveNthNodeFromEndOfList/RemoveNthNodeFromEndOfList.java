/*
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * 
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = findLength(head);
        int i = 0;
        int traverseTill = (length - n - 1);

        if (traverseTill == -1) {
            return head.next;
        }
        ListNode current = head;

        while (i < traverseTill) {
            current = current.next;
            i++;
        }
        current.next = current.next.next;

        return head;
    }

    public int findLength(ListNode head) {
        int count = 0;

        if (head == null) {
            return count;
        }
        ListNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}