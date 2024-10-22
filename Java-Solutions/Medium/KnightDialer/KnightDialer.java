package Medium.KnightDialer;

/*
 * The chess knight has a unique movement, it may move two squares vertically
 * and
 * one square horizontally, or two squares horizontally and one square
 * vertically
 * (with both forming the shape of an L). The possible movements of chess knight
 * are
 * shown in this diagaram:
 * 
 * A chess knight can move as indicated in the chess diagram below:
 * 
 * 
 * We have a chess knight and a phone pad as shown below, the knight can only
 * stand on a numeric cell (i.e. blue cell).
 * 
 * Given an integer n, return how many distinct phone numbers of length n we can
 * dial.
 * 
 * You are allowed to place the knight on any numeric cell initially and then
 * you should
 * perform n - 1 jumps to dial a number of length n. All jumps should be valid
 * knight jumps.
 * 
 * As the answer may be very large, return the answer modulo 109 + 7.
 * 
 * Example 1:
 * Input: n = 1
 * Output: 10
 * Explanation: We need to dial a number of length 1, so placing the knight over
 * any numeric cell of the 10 cells is sufficient.
 */
class KnightDialer {
    public static final int max = (int) Math.pow(10, 9) + 7;

    public static int knightDialer(int n) {
        // A 3D array to store the solutions to the subproblems
        long M[][][] = new long[n + 1][4][3];
        long s = 0;
        // do n hops from every i, j index (the very requirement of the problem)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                s = (s + paths(M, i, j, n)) % max;
            }
        }
        return (int) s;
    }

    private static long paths(long[][][] M, int i, int j, int n) {
        // if the knight hops outside of the matrix or to * return 0
        // as there are no unique paths from here
        if (i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // if the subproblem's solution is already computed, then return it
        if (M[n][i][j] > 0) {
            return M[n][i][j];
        }
        // else compute the subproblem's solution and save it in memory
        M[n][i][j] = paths(M, i - 1, j - 2, n - 1) % max + // jump to a
                paths(M, i - 2, j - 1, n - 1) % max + // jump to b
                paths(M, i - 2, j + 1, n - 1) % max + // jump to c
                paths(M, i - 1, j + 2, n - 1) % max + // jump to d
                paths(M, i + 1, j + 2, n - 1) % max + // jump to e
                paths(M, i + 2, j + 1, n - 1) % max + // jump to f
                paths(M, i + 2, j - 1, n - 1) % max + // jump to g
                paths(M, i + 1, j - 2, n - 1) % max; // jump to h
        return M[n][i][j];
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println("Knight Dialer: " + knightDialer(n));
    }
}