package Hard.SlidingPuzzle;

/*
 * PROBLEM: 773: Sliding Puzzle
 * 
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty
 * square represented by 0. A move consists of choosing 0 and a 4-directionally
 * adjacent number and swapping it.
 * 
 * The state of the board is solved if and only if the board is
 * [[1,2,3],[4,5,0]].
 * 
 * Given the puzzle board board, return the least number of moves required so
 * that the state of the board is solved. If it is impossible for the state of
 * the board to be solved, return -1.
 * 
 * Example 1:
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * 
 * Example 2:
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * 
 * Example 3:
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 */
import java.util.*;

class SlidingPuzzle {
    int[][] finalMatrix = { { 1, 2, 3 }, { 4, 5, 0 } };
    Set<String> set = new HashSet<>();

    public String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int val : row) {
                sb.append(val);
            }
        }
        return sb.toString();
    }

    public int[] findZero(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public int[][] swap(int[][] m, int a, int b, int c, int d) {
        int[][] newMatrix = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            newMatrix[i] = m[i].clone();
        }
        int temp = newMatrix[a][b];
        newMatrix[a][b] = newMatrix[c][d];
        newMatrix[c][d] = temp;
        return newMatrix;
    }

    public int solve(Queue<int[][]> queue, Queue<Integer> levels) {
        int[][] delrow = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[][] curr = queue.poll();
            int level = levels.poll();
            if (Arrays.deepEquals(curr, finalMatrix)) {
                return level;
            }

            int[] indexOfZero = findZero(curr);
            for (int[] entry : delrow) {
                int newRow = indexOfZero[0] + entry[0];
                int newCol = indexOfZero[1] + entry[1];

                if (newRow >= 0 && newRow < curr.length && newCol >= 0 && newCol < curr[0].length) {
                    int[][] nextState = swap(curr, indexOfZero[0], indexOfZero[1], newRow, newCol);

                    String nextStateStr = matrixToString(nextState);
                    if (!set.contains(nextStateStr)) {
                        set.add(nextStateStr);
                        queue.add(nextState);
                        levels.add(level + 1);
                    }
                }
            }
        }

        return -1;
    }

    public int slidingPuzzle(int[][] board) {
        Queue<int[][]> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(board);
        levels.add(0);
        set.add(matrixToString(board));
        return solve(queue, levels);
    }
}