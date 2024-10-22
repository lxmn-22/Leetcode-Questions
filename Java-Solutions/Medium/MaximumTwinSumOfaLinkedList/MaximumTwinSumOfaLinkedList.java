package Medium.MaximumTwinSumOfaLinkedList;

/*
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the
 * linked list
 * is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * 
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the
 * twin of node 2.
 * These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * 
 * Given the head of a linked list with even length, return the maximum twin sum
 * of the linked list.
 * 
 * Example 1:
 * Input: head = [5,4,2,1]
 * Output: 6
 * Explanation:
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum
 * = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 */
/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MaximumTwinSumOfaLinkedList {
    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        int maxSum = 0;
        for (; slow != null && fast != null; slow = slow.next, fast = fast.next) {
            maxSum = Math.max(maxSum, slow.val + fast.val);
        }
        return maxSum;
    }

    private static ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}