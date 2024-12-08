package Medium.TwoBestNonOverlappingEvents;

import java.util.*;

/*
 * PROBLEM:2054: Two Best Non-Overlapping Events
 * 
 * You are given a 0-indexed 2D integer array of events where events[i] =
 * [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends
 * at endTimei, and if you attend this event, you will receive a value of
 * valuei. You can choose at most two non-overlapping events to attend such that
 * the sum of their values is maximized.
 * 
 * Return this maximum sum.
 * 
 * Note that the start time and end time is inclusive: that is, you cannot
 * attend two events where one of them starts and the other ends at the same
 * time. More specifically, if you attend an event with end time t, the next
 * event must start at or after t + 1.
 * 
 * Example 1:
 * Input: events = [[1,3,2],[4,5,2],[2,4,3]]
 * Output: 4
 * Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
 * 
 * Example 2:
 * Example 1 Diagram
 * Input: events = [[1,3,2],[4,5,2],[1,5,5]]
 * Output: 5
 * Explanation: Choose event 2 for a sum of 5.
 *
 * Example 3:
 * Input: events = [[1,5,3],[1,5,1],[6,6,5]]
 * Output: 8
 * Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.
 */
class TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // sort the events by their start time.
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // creating the suffix array for the maximum event value from each event
        // onboard.
        int[] suffixMax = new int[n];

        // Initialize the last event's value.
        suffixMax[n - 1] = events[n - 1][2];

        // populate the suffixMax array.
        for (int i = n - 2; i >= 0; --i) {
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
        }

        // for each event, find the next event that starts after it ends.
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            int nextEventIndex = -1;

            // performing binary seach to find the next non-overlapping event.
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > events[i][1]) {
                    nextEventIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // If a valid next event is found, update the max sum.
            if (nextEventIndex != -1) {
                maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextEventIndex]);
            }

            // Also, consider the case where we take only the current event.
            maxSum = Math.max(maxSum, events[i][2]);
        }
        return maxSum;
    }
}