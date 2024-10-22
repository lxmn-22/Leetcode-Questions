/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
 */
package Medium.SetMatrixZeroes;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Pair<Integer, Integer>> V = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0)
                    V.add(new Pair<>(i, j));
            }
        }

        for (Pair<Integer, Integer> p : V) {
            int row = p.getKey();
            int col = p.getValue();

            for (int i = 0; i < m; i++) {
                matrix[row][i] = 0;
            }

            for (int i = 0; i < n; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}