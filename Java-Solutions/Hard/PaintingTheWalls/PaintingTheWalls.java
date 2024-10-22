/*
You are given two 0-indexed integer arrays, cost and time, of size n representing the costs and 
the time taken to paint n different walls respectively. There are two painters available:
A paid painter that paints the ith wall in time[i] units of time and takes cost[i] units of money.
A free painter that paints any wall in 1 unit of time at a cost of 0. But the free painter can only be used 
,if the paid painter is already occupied.
Return the minimum amount of money required to paint the n walls.

*/
public class PaintingTheWalls {
    public static int paintWalls(int[] cost, int[] time) {
        final int n = cost.length;
        dp = new int[n][n + 1];
        return paintWalls(cost, time, 0, time.length);
    }

    private static final int kMax = 500_000_000;
    private static int[][] dp;

    private static int paintWalls(int[] cost, int[] time, int i, int walls) {
        if (walls <= 0)
            return 0;
        if (i == cost.length)
            return kMax;
        if (dp[i][walls] > 0)
            return dp[i][walls];
        final int pick = cost[i] + paintWalls(cost, time, i + 1, walls - time[i] - 1);
        final int skip = paintWalls(cost, time, i + 1, walls);
        return dp[i][walls] = Math.min(pick, skip);
    }
    public static void main(String[] args) {
        int[] cost = {1,2,3,2};
        int[] time = {1,2,3,2};
        System.out.println("Painting the walls: "+paintWalls(cost, time, kMax, kMax));
    }
}
