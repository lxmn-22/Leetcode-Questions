package Hard.NQueens;

import java.util.*;

/*
 * PROBLEM: 51: N-Queens
 * 
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]
 */

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n == 1) {
            List<String> solution = new ArrayList<>();
            solution.add("Q");
            results.add(solution);
            return results;
        }
        if (n == 2 || n == 3) {
            return results;
        }

        int[] solution = new int[n];
        for (int i = 0; i < n; i++) {
            solution[i] = -1;
        }

        solveNQueensRec(n, solution, 0, results);
        return results;
    }

    // Recursive worker function
    private void solveNQueensRec(int n, int[] solution, int row, List<List<String>> results) {
        if (row == n) {
            List<String> solutionStr = constructSolutionString(solution);
            results.add(solutionStr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValidMove(row, i, solution)) {
                solution[row] = i;
                solveNQueensRec(n, solution, row + 1, results);
                solution[row] = -1; // Backtrack
            }
        }
    }

    // This method determines if a queen can be placed at
    // proposedRow, proposedCol with the current solution
    private boolean isValidMove(int proposedRow, int proposedCol, int[] solution) {
        for (int i = 0; i < proposedRow; i++) {
            int oldRow = i;
            int oldCol = solution[i];
            int diagonalOffset = proposedRow - oldRow;

            if (oldCol == proposedCol || oldCol == proposedCol - diagonalOffset
                    || oldCol == proposedCol + diagonalOffset) {
                return false;
            }
        }
        return true;
    }

    // Constructs the board solution as a list of strings
    private List<String> constructSolutionString(int[] solution) {
        List<String> returnArr = new ArrayList<>();
        for (int i = 0; i < solution.length; i++) {
            char[] row = new char[solution.length];
            for (int j = 0; j < solution.length; j++) {
                row[j] = '.';
            }
            row[solution[i]] = 'Q';
            returnArr.add(new String(row));
        }
        return returnArr;
    }
}