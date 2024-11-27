import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max heap to store characters based on their remaining counts
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        // Add characters to the heap if their count is greater than 0
        if (a > 0) maxHeap.offer(new int[]{a, 'a'});
        if (b > 0) maxHeap.offer(new int[]{b, 'b'});
        if (c > 0) maxHeap.offer(new int[]{c, 'c'});

        StringBuilder result = new StringBuilder();

        // Build the result string
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll(); // Get the character with the highest count
            int count = current[0];
            char ch = (char) current[1];

            // Check for the last two characters to prevent three consecutive same characters
            if (result.length() >= 2 && result.charAt(result.length() - 1) == ch && result.charAt(result.length() - 2) == ch) {
                if (maxHeap.isEmpty()) break; // Exit if no other characters are available
                int[] next = maxHeap.poll(); // Get the next character
                result.append((char) next[1]); // Append the next character
                next[0]--; // Decrease its count
                if (next[0] > 0) maxHeap.offer(next); // Reinsert if there are remaining characters
            } else {
                result.append(ch); // Append the current character
                count--; // Decrease its count
            }
            if (count > 0) maxHeap.offer(new int[]{count, ch}); // Reinsert current character if needed
        }

        return result.toString(); // Return the resulting string
    }
}
