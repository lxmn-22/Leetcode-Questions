/*
You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] 
represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.

Example 1:
Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
 */
package Hard.CherryPickupII;

public class CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        return helper(grid, 0, 0, cols - 1);
    }

    public int helper(int[][] grid, int currRow, int robotACol, int robotBCol) {

        if (robotACol < 0 || robotBCol < 0 || robotACol >= grid[0].length || robotBCol >= grid[0].length)
            return 0;

        if (currRow == grid.length)
            return 0; // last row

        int result = 0;
        result += grid[currRow][robotACol];
        result += grid[currRow][robotBCol];

        int max = 0; // DFS for next row
        for (int x = robotACol - 1; x <= robotACol + 1; x++) {
            for (int y = robotBCol - 1; y <= robotBCol + 1; y++) {
                if (x < y) {
                    max = Math.max(max, helper(grid, currRow + 1, x, y));
                }
            }
        }
        result += max; // add maximum result
        return result;
    }
}