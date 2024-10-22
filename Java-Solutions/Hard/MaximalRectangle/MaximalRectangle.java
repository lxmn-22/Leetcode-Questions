/*
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 * 
 * Example 1:
 * Input: matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0",
 * "0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * 
 * Example 2:
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * Example 3:
 * Input: matrix = [["1"]]
 * Output: 1
 * 
 * Constraints:
 * rows == matrix.length
 * cols == matrix[i].length
 * 1 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 */
class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix[0].length;
        int[] currentRow = new int[n];
        // Initialize the maximum answer.
        int maxAns = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    currentRow[j] += 1;
                } else {
                    currentRow[j] = 0;
                }
            }
            // Calculate the largest area in histogram for the current row.
            int currentAns = largestAreaHistogram(currentRow);

            // Update maxAns with the maximum of maxAns and curAns.
            maxAns = Math.max(maxAns, currentAns);
        }
        return maxAns;
    }

    private static int largestAreaHistogram(int a[]) {
        int n = a.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        // Calculate leftSmalls.
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            leftSmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }
        // Clear the stack.
        st.clear();

        // Calculate rightSmalls
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            rightSmall[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }

        // Calculate the maximum area.
        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, a[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }
}