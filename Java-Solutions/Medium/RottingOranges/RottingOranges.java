/*
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 * 
 * Example 1:
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */
class RottingOranges {
    private final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int nonRottenCount = 0;
        int numRows = grid.length;
        int numCols = grid[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    nonRottenCount++;
                }
            }
        }
        int totalTime = 0;
        while (!queue.isEmpty() && nonRottenCount > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] removed = queue.remove();
                for (int[] dir : DIRS) {
                    int newX = removed[0] + dir[0];
                    int newY = removed[1] + dir[1];
                    if (newX >= 0 && newY >= 0 && newX < numRows && newY < numCols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        nonRottenCount--;
                        queue.add(new int[] { newX, newY });
                    }
                }
            }
            totalTime++;
        }
        return nonRottenCount == 0 ? totalTime : -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println("Rotting Oranges: " + orangesRotting(grid));
    }
}