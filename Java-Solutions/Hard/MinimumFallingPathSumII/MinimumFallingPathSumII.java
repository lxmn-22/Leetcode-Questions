/*
 * Given an n x n integer matrix grid, return the minimum sum of a falling path
 * with non-zero shifts.
 * 
 * A falling path with non-zero shifts is a choice of exactly one element from
 * each row of grid such that no two elements chosen in adjacent rows are in the
 * same column.
 * 
 * Example 1:
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 13
 * Explanation:
 * The possible falling paths are:
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * The falling path with the smallest sum is [1,5,7], so the answer is 13.
 * 
 * Example 2:
 * Input: grid = [[7]]
 * Output: 7
 * 
 * Constraints:
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 */
class MinimumFallingPathSumII {
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        for (int j = 0; j < m; ++j) {
            dp[0][j] = grid[0][j];
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int temp = Integer.MAX_VALUE;

                for (int k = 0; k < m; ++k) {
                    if (j != k) {
                        temp = Math.min(temp, grid[i][j] + dp[i - 1][k]);
                    }
                    dp[i][j] = temp;
                }
            }
        }
        for (int j = 0; j < m; ++j) {
            result = Math.min(result, dp[n - 1][j]);
        }
        return result;
    }
}