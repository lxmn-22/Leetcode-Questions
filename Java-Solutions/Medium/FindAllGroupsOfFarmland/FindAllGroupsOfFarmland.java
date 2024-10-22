/*
 * You are given a 0-indexed m x n binary matrix land where a 0 represents a
 * hectare of forested land and a 1 represents a hectare of farmland.
 * 
 * To keep the land organized, there are designated rectangular areas of
 * hectares that consist entirely of farmland. These rectangular areas are
 * called groups. No two groups are adjacent, meaning farmland in one group is
 * not four-directionally adjacent to another farmland in a different group.
 * 
 * land can be represented by a coordinate system where the top left corner of
 * land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the
 * coordinates of the top left and bottom right corner of each group of
 * farmland. A group of farmland with a top left corner at (r1, c1) and a bottom
 * right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2,
 * c2].
 * 
 * Return a 2D array containing the 4-length arrays described above for each
 * group of farmland in land. If there are no groups of farmland, return an
 * empty array. You may return the answer in any order.
 * 
 * Example 1:
 * Input: land = [[1,0,0],[0,1,1],[0,1,1]]
 * Output: [[0,0,0,0],[1,1,2,2]]
 * Explanation:
 * The first group has a top left corner at land[0][0] and a bottom right corner
 * at land[0][0].
 * The second group has a top left corner at land[1][1] and a bottom right
 * corner at land[2][2].
 * 
 * Example 2:
 * Input: land = [[1,1],[1,1]]
 * Output: [[0,0,1,1]]
 * Explanation:
 * The first group has a top left corner at land[0][0] and a bottom right corner
 * at land[1][1].
 * 
 * Example 3:
 * Input: land = [[0]]
 * Output: []
 * Explanation:
 * There are no groups of farmland.
 *
 * Constraints:
 * m == land.length
 * n == land[i].length
 * 1 <= m, n <= 300
 * land consists of only 0's and 1's.
 * Groups of farmland are rectangular in shape.
 */
class FindAllGroupsOfFarmland {
    // Function to recursively explore and mark farmland.
    void solve(int r, int c, int[] maxCoordinates, int[][] land, boolean[][] vis) {
        // Getting the dimensions of the land.
        int m = land.length;
        int n = land[0].length;

        // Marking the current cell as visited.
        vis[r][c] = true;

        // Arrays to represent four possible directions: up, down, left, right.
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        // Iterating through each direction.
        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + r; // New row.
            int nc = dc[i] + c; // New column.

            // Checking if the new cell is within bounds, is unvisited, and is part of
            // farmland
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && land[nr][nc] == 1 && !vis[nr][nc]) {
                // Updating the maximum row and column encountered so far.
                maxCoordinates[0] = Math.max(maxCoordinates[0], nr);
                maxCoordinates[1] = Math.max(maxCoordinates[1], nc);

                // Recursively exploring the farmland.
                solve(nr, nc, maxCoordinates, land, vis);
            }
        }
    }

    // Main function to find all farmland.
    public int[][] findFarmland(int[][] land) {
        // Getting the dimensions of the land.
        int m = land.length;
        int n = land[0].length;

        // Creating a 2D array to mark visited cells.
        boolean[][] vis = new boolean[m][n];

        // List to store the coordinates of each farmland.
        List<int[]> ansList = new ArrayList<>();

        // Iterating through each cell in the land.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell is unvisited and is part of farmland.
                if (!vis[i][j] && land[i][j] == 1) {
                    int[] maxCoordinates = { i, j }; // Initialize maximum row and column.

                    // Recursive function to explore and mark the farmland.
                    solve(i, j, maxCoordinates, land, vis);

                    // Adding the coordinates of the farmland into the result list.
                    ansList.add(new int[] { i, j, maxCoordinates[0], maxCoordinates[1] });
                }
            }
        }

        // Converting the list of coordinates into a 2D array and returning.
        int[][] ans = new int[ansList.size()][4];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}