/*
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 *
 * Example 1:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position Max
 * --------------- -----
 * [1 3 -1] -3 5 3 6 7 3
 * 1 [3 -1 -3] 5 3 6 7 3
 * 1 3 [-1 -3 5] 3 6 7 5
 * 1 3 -1 [-3 5 3] 6 7 5
 * 1 3 -1 -3 [5 3 6] 7 6
 * 1 3 -1 -3 5 [3 6 7] 7
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */

import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> q = new ArrayDeque<>();
        int j = 0;
        int ans[] = new int[nums.length - k + 1];
        int i = 0;
        for (i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        for (int index = i; index < nums.length; index++) {
            ans[j++] = nums[q.peek()];
            while (!q.isEmpty() && q.peek() <= index - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && nums[index] >= nums[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(index);
        }
        ans[j] = nums[q.peek()];
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println("" + maxSlidingWindow(nums, k));
    }
}