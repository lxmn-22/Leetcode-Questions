/*
 * You are given a 0-indexed integer array nums, and you are allowed to traverse
 * between its indices. You can traverse between index i and index j, i != j, if
 * and only if gcd(nums[i], nums[j]) > 1, where gcd is the greatest common
 * divisor.
 * 
 * Your task is to determine if for every pair of indices i and j in nums, where
 * i < j, there exists a sequence of traversals that can take us from i to j.
 * 
 * Return true if it is possible to traverse between all such pairs of indices,
 * or false otherwise.
 * 
 * Example 1:
 * Input: nums = [2,3,6]
 * Output: true
 * Explanation: In this example, there are 3 possible pairs of indices: (0, 1),
 * (0, 2), and (1, 2).
 * To go from index 0 to index 1, we can use the sequence of traversals 0 -> 2
 * -> 1, where we move from index 0 to index 2 because gcd(nums[0], nums[2]) =
 * gcd(2, 6) = 2 > 1, and then move from index 2 to index 1 because gcd(nums[2],
 * nums[1]) = gcd(6, 3) = 3 > 1.
 * To go from index 0 to index 2, we can just go directly because gcd(nums[0],
 * nums[2]) = gcd(2, 6) = 2 > 1. Likewise, to go from index 1 to index 2, we can
 * just go directly because gcd(nums[1], nums[2]) = gcd(3, 6) = 3 > 1.
 */
class GreatestCommanDivisorTraversal {
    public static boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int n = nums.length;
        int maxElement = Arrays.stream(nums).max().getAsInt();

        if (Arrays.stream(nums).min().getAsInt() == 1) {
            return false;
        }
        int[] factorArray = factorsCalculator(maxElement);

        int[] parent = new int[maxElement + 1];
        int[] rank = new int[maxElement + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int num : nums) {
            int x = num;
            while (x > 1) {
                int p = factorArray[x];
                union(parent, rank, p, num);

                while (x % p == 0) {
                    x = x / p;
                }
            }
        }

        int p = find(parent, nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (find(parent, nums[i]) != p) {
                return false;
            }
        }
        return true;
    }

    public static int[] factorsCalculator(int n) {
        int[] dp = new int[n + 2];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (dp[i] == i) {
                for (int j = i * 2; j <= n; j += i) {
                    if (dp[j] == j)
                        dp[j] = i;
                }
            }
        }
        return dp;
    }

    private int find(int[] parent, int a) {
        return parent[a] = parent[a] == a ? a : find(parent, parent[a]);
    }

    private void union(int[] parent, int[] rank, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a == b) {
            return;
        }
        if (rank[a] < rank[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        parent[b] = a;
        rank[a] += rank[b];
    }
}