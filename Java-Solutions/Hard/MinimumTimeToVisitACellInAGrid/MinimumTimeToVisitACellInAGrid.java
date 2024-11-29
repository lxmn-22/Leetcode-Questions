package Hard.MinimumTimeToVisitACellInAGrid;

import java.util.*;

/*
 * PROBLEM: 2577: Minimum Time to Visit a Cell in a Grid
 * 
 * You are given a m x n matrix grid consisting of non-negative integers where
 * grid[row][col] represents the minimum time required to be able to visit the
 * cell (row, col), which means you can visit the cell (row, col) only when the
 * time you visit it is greater than or equal to grid[row][col].
 * 
 * You are standing in the top-left cell of the matrix in the 0th second, and
 * you must move to any adjacent cell in the four directions: up, down, left,
 * and right. Each move you make takes 1 second.
 * 
 * Return the minimum time required in which you can visit the bottom-right cell
 * of the matrix. If you cannot visit the bottom-right cell, then return -1.
 * 
 * Example 1:
 * Input: grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
 * Output: 7
 * Explanation: One of the paths that we can take is the following:
 * - at t = 0, we are on the cell (0,0).
 * - at t = 1, we move to the cell (0,1). It is possible because grid[0][1] <=
 * 1.
 * - at t = 2, we move to the cell (1,1). It is possible because grid[1][1] <=
 * 2.
 * - at t = 3, we move to the cell (1,2). It is possible because grid[1][2] <=
 * 3.
 * - at t = 4, we move to the cell (1,1). It is possible because grid[1][1] <=
 * 4.
 * - at t = 5, we move to the cell (1,2). It is possible because grid[1][2] <=
 * 5.
 * - at t = 6, we move to the cell (1,3). It is possible because grid[1][3] <=
 * 6.
 * - at t = 7, we move to the cell (2,3). It is possible because grid[2][3] <=
 * 7.
 * The final time is 7. It can be shown that it is the minimum time possible.
 * 
 * Example 2:
 * Input: grid = [[0,2,4],[3,2,1],[1,0,4]]
 * Output: -1
 * Explanation: There is no path from the top left to the bottom-right cell.
 */
class MinimumTimeToVisitACellInAGrid {
    private static final int[][] MOVES = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int minimumTime(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] seen = new boolean[rows][cols];

        pq.offer(new int[] { 0, 0, 0 });
        seen[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            for (int[] dir : MOVES) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || seen[newRow][newCol]) {
                    continue;
                }

                int newTime = time + 1;
                if (grid[newRow][newCol] > newTime) {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;
                    newTime += wait;
                }

                if (newRow == rows - 1 && newCol == cols - 1) {
                    return newTime;
                }

                seen[newRow][newCol] = true;
                pq.offer(new int[] { newTime, newRow, newCol });
            }
        }
        return -1;
    }
}