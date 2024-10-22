/*
 * Given the head of a linked list, we repeatedly delete consecutive sequences
 * of nodes that sum to 0 until there are no such sequences.
 * 
 * After doing so, return the head of the final linked list. You may return any
 * such answer.
 *
 * (Note that in the examples below, all sequences are serializations of
 * ListNode objects.)
 * 
 * Example 1:
 * Input: head = [1,2,-3,3,1]
 * Output: [3,1]
 * Note: The answer [1,2,1] would also be accepted.
 * 
 * Example 2:
 * Input: head = [1,2,3,-3,4]
 * Output: [1,2,4]
 * 
 * Example 3:
 * Input: head = [1,2,3,-3,-2]
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
class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public static ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        map.put(0, dummy);

        while (head != null) {
            prefixSum += head.val;
            if (map.containsKey(prefixSum)) {
                ListNode start = map.get(prefixSum);
                ListNode temp = start;
                int sum = prefixSum;

                while (temp != head) {
                    temp = temp.next;
                    sum += temp.val;
                    if (temp != head) {
                        map.remove(sum);
                    }
                }
                start.next = head.next;
            } else {
                map.put(prefixSum, head);
            }
            head = head.next;
        }
        return dummy.next;
    }
}