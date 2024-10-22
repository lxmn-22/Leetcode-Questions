/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, 
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */
class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int i;
        int j;
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[2][n];
        int inf = 88000;

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i % 2][j] = grid[i][j];
                } else {
                    dp[i & 1][j] = grid[i][j]
                            + Math.min(i == 0 ? inf : dp[(i - 1) & 1][j], j == 0 ? inf : dp[i & 1][j - 1]);
                }
            }
        }
        return dp[(i - 1) & 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println("Minimum Path Sum: " + minPathSum(grid));
    }
}