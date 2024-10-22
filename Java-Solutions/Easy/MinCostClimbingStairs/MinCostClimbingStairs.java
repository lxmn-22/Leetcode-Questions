/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.

Constraints:
2 <= cost.length <= 1000
0 <= cost[i] <= 999
*/
public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        return Math.min(first, second);
    }
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println("Minimum Cost Climbing Stairs: "+minCostClimbingStairs(cost));
    }
}