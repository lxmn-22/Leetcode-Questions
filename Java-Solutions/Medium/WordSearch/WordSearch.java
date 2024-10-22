/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are 
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
 */
package Medium.WordSearch;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean a = solve(board, word, i, j, board[0].length, board.length, 0);
                    if (a) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean solve(char[][] board, String word, int row, int col, int m, int n, int idx) {
        // base case.
        if (idx == word.length()) {
            return true;
        }
        // negetive base case.
        if (row < 0 || col < 0 || row >= n || col >= m || board[row][col] != word.charAt(idx)) {
            return false;
        }
        // changes make for not going back on same place again.
        board[row][col] = '#';

        int[] r = { 0, 0, -1, 1 };
        int[] c = { 1, -1, 0, 0 };

        // four recursion calls for up,down,left and right.
        for (int i = 0; i < c.length; i++) {
            boolean ans = solve(board, word, row + r[i], col + c[i], m, n, idx + 1);
            if (ans) {
                return true;
            }
        }
        // backtrack.
        board[row][col] = word.charAt(idx);
        return false;
    }
}