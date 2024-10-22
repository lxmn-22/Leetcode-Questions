/*
 * You are given an array of non-overlapping intervals intervals where
 * intervals[i] = [starti, endi] represent the start and the end of the ith
 * interval and intervals is sorted in ascending order by starti. You are also
 * given an interval newInterval = [start, end] that represents the start and
 * end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by starti and intervals still does not have any overlapping
 * intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * Note that you don't need to modify intervals in-place. You can make a new
 * array and return it.
 * 
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;

        for (int[] inv : intervals) {
            int cstart = inv[0];
            int cend = inv[1];

            if (cend < start || inserted) {
                ans.add(new int[] { cstart, cend });
                continue;
            }

            start = Math.min(start, cstart);
            if (end < cstart) {
                ans.add(new int[] { start, end });
                ans.add(new int[] { cstart, cend });
                inserted = true;
                continue;
            }

            if (end <= cend) {
                ans.add(new int[] { start, cend });
                inserted = true;
            }
        }

        if (!inserted) {
            ans.add(new int[] { start, end });
        }
        return ans.toArray(new int[ans.size()][]);
    }
}