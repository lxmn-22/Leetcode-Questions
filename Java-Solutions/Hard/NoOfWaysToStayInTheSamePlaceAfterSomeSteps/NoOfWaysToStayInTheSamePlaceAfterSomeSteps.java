/*
You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 
1 position to the right in the array, or stay in the same place 
(The pointer should not be placed outside the array at any time).

Given two integers steps and arrLen, return the number of ways such that your pointer is still at index 0 after
exactly steps steps. Since the answer may be too large, return it modulo 109 + 7.
 */
public class NoOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static int numWays(int steps, int arrLen) {
        final int kMod = 1_000_000_007;
        final int n = Math.min(arrLen, steps / 2 + 1);
        // dp[i] := # of ways to stay on index i
        long[] dp = new long[n];
        dp[0] = 1;

        while (steps-- > 0) {
            long[] newDp = new long[n];
            for (int i = 0; i < n; ++i) {
                newDp[i] = dp[i];
                if (i - 1 >= 0)
                    newDp[i] += dp[i - 1];
                if (i + 1 < n)
                    newDp[i] += dp[i + 1];
                    newDp[i] %= kMod;
            }
            dp = newDp;
        }
        return (int) dp[0];
    }
    public static void main(String[] args) {
        int steps = 3;
        int arrLen = 2;
        System.out.println("Number of ways to stay in the same place after some steps: "+numWays(steps,arrLen));
    }
}