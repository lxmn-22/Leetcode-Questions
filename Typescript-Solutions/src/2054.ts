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
function maxTwoEvents(events: number[][]): number {
    // sort by start.
    events.sort((a, b) => a[0] - b[0])
    events.push([Infinity, Infinity, 0])
    let best = -Infinity
    
    for (let i = events.length - 2; i >= 0; i--) {
        const [start, end, value] = events[i]
        
        // set max possible value from this startTime forward.
        if (value < events[i + 1][2]) {
            events[i][2] = events[i + 1][2]
        }
        
        // search forward for the first startTime > end.
        let left = i + 1
        let right = events.length - 1
        
        while (left < right) {
            const mid = left + Math.floor((right - left) / 2)
            
            const midStart = events[mid][0]
            if (midStart >= end + 1) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        best = Math.max(best, value + events[left][2])
    }
    return best
};