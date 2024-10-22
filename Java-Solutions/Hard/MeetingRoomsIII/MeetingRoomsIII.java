/*
 * You are given an integer n. There are n rooms numbered from 0 to n - 1.
 * 
 * You are given a 2D integer array meetings where meetings[i] = [starti, endi]
 * means that a meeting will be held during the half-closed time interval
 * [starti, endi). All the values of starti are unique.
 * 
 * Meetings are allocated to rooms in the following manner:
 * 
 * Each meeting will take place in the unused room with the lowest number.
 * If there are no available rooms, the meeting will be delayed until a room
 * becomes free. The delayed meeting should have the same duration as the
 * original meeting.
 * When a room becomes unused, meetings that have an earlier original start time
 * should be given the room.
 * Return the number of the room that held the most meetings. If there are
 * multiple rooms, return the room with the lowest number.
 * 
 * A half-closed interval [a, b) is the interval between a and b including a and
 * not including b.
 *
 * Example 1:
 * Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
 * Output: 0
 * Explanation:
 * - At time 0, both rooms are not being used. The first meeting starts in room
 * 0.
 * - At time 1, only room 1 is not being used. The second meeting starts in room
 * 1.
 * - At time 2, both rooms are being used. The third meeting is delayed.
 * - At time 3, both rooms are being used. The fourth meeting is delayed.
 * - At time 5, the meeting in room 1 finishes. The third meeting starts in room
 * 1 for the time period [5,10).
 * - At time 10, the meetings in both rooms finish. The fourth meeting starts in
 * room 0 for the time period [10,11).
 * Both rooms 0 and 1 held 2 meetings, so we return 0.
 */
class MeetingRoomIII {
    public static int mostBooked(int n, int[][] meetings) {
        int[] ans = new int[n];
        long[] times = new long[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            boolean flag = false;
            int minIdx = -1;
            long val = Long.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (times[j] < val) {
                    val = times[j];
                    minIdx = j;
                }
                if (times[j] <= start) {
                    flag = true;
                    ans[j]++;
                    times[j] = end;
                    break;
                }
            }
            if (!flag) {
                ans[minIdx]++;
                times[minIdx] += (end - start);
            }
        }

        int maxIdx = -1, id = -1;
        for (int i = 0; i < n; i++) {
            if (ans[i] > maxIdx) {
                maxIdx = ans[i];
                id = i;
            }
        }
        return id;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = { { 0, 10 }, { 1, 5 }, { 2, 7 }, { 3, 4 } };
        System.out.println("Meeting Rooms III: " + mostBooked(n, meetings));
    }
}