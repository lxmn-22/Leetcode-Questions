/*
Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
We make a binary tree using these integers, and each number may be used for any number of times. 
Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. 
The answer may be too large so return the answer modulo 109 + 7.

Example 1:
Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]

Example 2:
Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 */
import java.util.*;
class BinaryTreesWithFactors {
    private static final int MOD = 1_000_000_007;
    
    public static int numFactoredBinaryTrees(int[] arr) {
      int n = arr.length;
      Arrays.sort(arr);
      long[] dp = new long[n];
      Arrays.fill(dp, 1);
      Map<Integer, Integer> indexMap = new HashMap<>();
      for (int i = 0; i < n; i++) {
        indexMap.put(arr[i], i);
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          if (arr[i] % arr[j] == 0) {
            int right = arr[i] / arr[j];
            if (indexMap.containsKey(right)) {
              dp[i] = (dp[i] + dp[j] * dp[indexMap.get(right)]) % MOD;
            }
          }
        }
      }
      long result = 0;
      for (long count : dp) {
        result += count;
      }
      return (int) (result % MOD);
    }
    public static void main(String[] args) {
        int[] arr = {2,4};
        System.out.println("Binary Trees with factors: "+numFactoredBinaryTrees(arr));
    }
}