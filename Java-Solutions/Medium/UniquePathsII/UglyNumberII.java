/**
 * 63. Unique Paths II
 * Medium
 * 
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * 
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * 
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * 
 * The testcases are generated so that the answer will be less than or equal to 2 * 10^9.
*/

// using MEMOIZATION
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row: dp)
            Arrays.fill(row, -1);
            
        return find(m - 1, n - 1, obstacleGrid, dp);
    }
    int find(int row, int col, int[][] mat, int[][] dp) {
        if (row < 0 || col < 0 || mat[row][col] == 1) return 0;
        if (row == 0 && col == 0) return 1;
        if (dp[row][col] != -1) return dp[row][col];

        int cnt = 0;
        cnt += find(row - 1, col, mat, dp);
        cnt += find(row, col - 1, mat, dp);

        return dp[row][col] = cnt;
    }
}



// using TABULATION
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (row == 0 && col == 0)
                    dp[0][0] = obstacleGrid[0][0] == 1? 0: 1;
                else if (obstacleGrid[row][col] == 1)
                    dp[row][col] = 0;
                else {
                    int cnt = 0;
                    if (row > 0) cnt += dp[row - 1][col];
                    if (col > 0) cnt += dp[row][col - 1];
                    dp[row][col] = cnt;
                }

            }
        }
            
        return dp[m - 1][n - 1];
    }
}



// Space Optimization
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] up = new int[n];
        up[0] = obstacleGrid[0][0] == 1? 0: 1;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                
                int cnt = up[col];
                if (col > 0) cnt += up[col - 1];
                if (obstacleGrid[row][col] == 1) cnt = 0;
                up[col] = cnt;

            }
        }
            
        return up[n - 1];
    }
}