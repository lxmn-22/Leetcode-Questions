/*
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). 
You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of 
the cell you are initially standing at.
In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot 
step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell 
that is at the border of the maze. The entrance does not count as an exit.
Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Example 1:
Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.
 */
package Medium.NearestExitFromEntranceInMaze;

public class NearestExitFromEntranceInMaze {
    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int entranceRow = entrance[0];
        int entranceCol = entrance[1];
        queue.add(new int[] { entranceRow, entranceCol });
        visited[entranceRow][entranceCol] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] removed = queue.remove();
                int row = removed[0];
                int col = removed[1];
                if (!(row == entranceRow && col == entranceCol) && isExit(row, col, rows, cols)) {
                    return steps;
                }
                for (int[] dir : DIRS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && !visited[newRow][newCol]
                            && maze[newRow][newCol] != '+') {
                        queue.add(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private static boolean isExit(int row, int col, int rows, int cols) {
        return (row + 1 == rows) || (row - 1 == -1) || (col + 1 == cols) || (col - 1 == -1);
    }
}