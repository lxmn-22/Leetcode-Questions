/*
 * For an integer array nums, an inverse pair is a pair of integers [i, j] where
 * 0 <= i < j < nums.length and nums[i] > nums[j].
 * 
 * Given two integers n and k, return the number of different arrays consist of
 * numbers from 1 to n such that there are exactly k inverse pairs. Since the
 * answer can be huge, return it modulo 109 + 7.
 * 
 * Example 1:
 * Input: n = 3, k = 0
 * Output: 1
 * Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has
 * exactly 0 inverse pairs.
 * 
 * Example 2:
 * Input: n = 3, k = 1
 * Output: 2
 * Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
 */
class kInversePairsAway {
    public static int kInversePairs(int n, int k) {
        int[][] dp = new int[1001][1001];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int x = 0; x <= Math.min(j, i - 1); x++) {
                    if (j - x >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % 1000000007;
                    }
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 0;
        System.out.println("K Inverse Pairs Away: " + kInversePairs(n, k));
    }
}