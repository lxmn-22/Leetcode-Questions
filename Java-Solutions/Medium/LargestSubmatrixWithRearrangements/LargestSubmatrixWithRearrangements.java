package Medium.LargestSubmatrixWithRearrangements;

/*
 * You are given a binary matrix matrix of size m x n, and you are allowed to
 * rearrange
 * the columns of the matrix in any order.
 * 
 * Return the area of the largest submatrix within matrix where every element of
 * the submatrix
 * is 1 after reordering the columns optimally.
 * 
 * Example 1:
 * 
 * Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
 * Output: 4
 * Explanation: You can rearrange the columns as shown above.
 * The largest submatrix of 1s, in bold, has an area of 4.
 */
import java.util.*;

class LargestSubmatrixWithRearrangements {
    public static int largestSubmatrix(int[][] matrix) {
        final int n = matrix[0].length;
        int ans = 0;
        int[] hist = new int[n];

        for (int[] row : matrix) {
            // Accumulate the histogram if possible.
            for (int i = 0; i < n; ++i) {
                hist[i] = row[i] == 0 ? 0 : hist[i] + 1;
            }
            // Get sorted histogram.
            int[] sortedHist = hist.clone();
            Arrays.sort(sortedHist);

            // Greedily calculate the answer.
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, sortedHist[i] * (n - i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };
        System.out.println("Largest Submatrix: " + largestSubmatrix(matrix));
    }
}