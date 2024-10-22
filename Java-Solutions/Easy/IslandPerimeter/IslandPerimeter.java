/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there 
is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a 
square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:
Input: grid = [[1]]
Output: 4

Example 3:
Input: grid = [[1,0]]
Output: 4

Constraints:
row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.
 */
class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                // Check top row or row above for water.
                perimeter += (i == 0 || grid[i - 1][j] == 0) ? 1 : 0;
                // Check end row or row after for water.
                perimeter += (i == row - 1 || grid[i + 1][j] == 0) ? 1 : 0;
                // Check first column or column behind for water.
                perimeter += (j == 0 || grid[i][j - 1] == 0) ? 1 : 0;
                // Check last column or column after for water.
                perimeter += (j == column - 1 || grid[i][j + 1] == 0) ? 1 : 0;
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println("Island Perimeter: " + islandPerimeter(grid));
    }
}