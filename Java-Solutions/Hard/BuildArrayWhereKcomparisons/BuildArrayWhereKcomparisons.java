/*
You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array
of positive integers:
You should build the array arr which has the following properties:
arr has exactly n integers.
1 <= arr[i] <= m where (0 <= i < n).
After applying the mentioned algorithm to arr, the value search_cost is equal to k.
Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large, the answer must be computed modulo 109 + 7.

Example 1:
Input: n = 2, m = 3, k = 1
Output: 6
Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]

Example 2:
Input: n = 5, m = 2, k = 3
Output: 0
Explanation: There are no possible arrays that satisify the mentioned conditions.

Example 3:
Input: n = 9, m = 1, k = 1
Output: 1
Explanation: The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
*/
import java.util.*;
public class BuildArrayWhereKcomparisons {
    public static int numOfArrays(int n, int m, int k) {
        Integer[][][] dp = new Integer[n+1][m+1][k+1];
        return dfs(n,m,k,0,0,0,dp);
    }
    private static int dfs(int n, int m, int k, int i, int currentMax, int currentCost, Integer[][][] dp){
        if(i == n){
            if(k == currentCost) 
                return 1;
            return 0;
        }
        if (dp[i][currentMax][currentCost] != null) 
            return dp[i][currentMax][currentCost];
        int ans = 0;
        for(int num = 1; num <=  m; num++){
            int newCost = currentCost;
            int newMax = currentMax;
            if(num > currentMax){
                newMax = num;
                newCost++;
            }
            if(newCost > k) 
                break;
            ans += dfs(n, m, k, i + 1, newMax, newCost, dp);
            ans %= 1_000_000_007;
        }
        return dp[i][currentMax][currentCost] = ans;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = input.nextInt();
        System.out.print("Enter the value of m: ");
        int m = input.nextInt();
        System.out.print("Enter the value of k: ");
        int k = input.nextInt();
        System.out.println("Number of arrays: "+numOfArrays(n, m, k));
    }
}