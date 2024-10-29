package Medium.MaximumNumberOfMovesInGrid;

/*
 * PROBLEM: 2684 : Maximum Number of moves in a grid.
 * 
 * You are given a 0-indexed m x n matrix grid consisting of positive integers.
 * 
 * You can start at any cell in the first column of the matrix, and traverse the
 * grid in the following way:
 * 
 * From a cell (row, col), you can move to any of the cells: (row - 1, col + 1),
 * (row, col + 1) and (row + 1, col + 1) such that the value of the cell you
 * move to, should be strictly bigger than the value of the current cell.
 * Return the maximum number of moves that you can perform.
 * 
 * Example 1:
 * Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * Output: 3
 * Explanation: We can start at the cell (0, 0) and make the following moves:
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 * It can be shown that it is the maximum number of moves that can be made.
 * 
 * Example 2:
 * Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
 * Output: 0
 * Explanation: Starting from any cell in the first column we cannot perform any
 * moves.
 */
class MaximumNumberOfMovesInGrid {
    public int maxMoves(int[][] grid) {
        // no.of rows.
        int m = grid.length;
        // no.of columns.
        int n = grid[0].length;

        int result = 0;
        // dp array stores max no.of moves possible to reach each cell in the current
        // col.
        int[] dp = new int[m];

        // Iterate through each col from left -> right
        for (int j = 1; j < n; j++) {
            int leftTop = 0;

            boolean found = false;

            for (int i = 0; i < m; i++) {
                int current = -1;
                int nextLeftTop = dp[i];

                // check move from top-left cell.
                if (i - 1 >= 0 && leftTop != -1 && grid[i][j] > grid[i - 1][j - 1]) {
                    current = Math.max(current, leftTop + 1);
                }
                // check move from direct left cell.
                if (dp[i] != -1 && grid[i][j] > grid[i][j - 1]) {
                    current = Math.max(current, dp[i] + 1);
                }
                // check move from bottom-left cell.
                if (i + 1 < m && dp[i + 1] != -1 && grid[i][j] > grid[i + 1][j - 1]) {
                    current = Math.max(current, dp[i + 1] + 1);
                }

                dp[i] = current;
                found = found || (dp[i] != -1);
                leftTop = nextLeftTop;
            }
            if (!found) {
                break;
            }
            result = j;
        }
        return result;
    }
}