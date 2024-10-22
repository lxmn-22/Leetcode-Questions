/*
 * You are given two linked lists: list1 and list2 of sizes n and m
 * respectively.
 * 
 * Remove list1's nodes from the ath node to the bth node, and put list2 in
 * their place.
 * 
 * The blue edges and nodes in the following figure indicate the result:
 * Build the result list and return its head.
 *
 * Example 1:
 * Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 =
 * [1000000,1000001,1000002]
 * Output: [10,1,13,1000000,1000001,1000002,5]
 * Explanation: We remove the nodes 3 and 4 and put the entire list2 in their
 * place. The blue edges and nodes in the above figure indicate the result.
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

class MergeInBetweenLinkedList {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode currNode = list1;
        int index = 0;

        while (index < a - 1) {
            currNode = currNode.next;
            index++;
        }
        ListNode front = currNode;

        while (index < b + 1) {
            currNode = currNode.next;
            index++;
        }
        ListNode rear = currNode;
        ListNode secondListTail = list2, secondListHead = list2;

        while (secondListTail.next != null) {
            secondListTail = secondListTail.next;
        }
        front.next = secondListHead;
        secondListTail.next = rear;
        return list1;
    }
}