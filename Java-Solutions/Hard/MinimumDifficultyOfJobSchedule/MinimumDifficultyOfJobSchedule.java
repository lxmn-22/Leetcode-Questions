/*
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To
 * work on the ith job,
 * you have to finish all the jobs j where 0 <= j < i).
 * You have to finish at least one task every day. The difficulty of a job
 * schedule is the sum of
 * difficulties of each day of the d days. The difficulty of a day is the
 * maximum difficulty of a
 * job done on that day.
 * You are given an integer array jobDifficulty and an integer d. The difficulty
 * of the ith job is
 * jobDifficulty[i].
 * Return the minimum difficulty of a job schedule. If you cannot find a
 * schedule for the jobs return -1.
 * 
 * Example 1:
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 */
class MinimumDifficultyOfJobSchedule {
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        Integer[][] dp = new Integer[n][d + 1];
        return minDifficulty(/* index= */0, d, jobDifficulty, dp);
    }

    private int minDifficulty(int index, int dLeft, int[] jobDifficulty, Integer[][] dp) {
        if (dp[index][dLeft] != null) {
            return dp[index][dLeft];
        }
        if (dLeft == 1) {
            int result = 0;
            for (int j = index; j < jobDifficulty.length; j++) {
                result = Math.max(result, jobDifficulty[j]);
            }
            return result;
        }
        int result = Integer.MAX_VALUE;
        int dailyMaxJobDiff = 0;
        for (int j = index; j < jobDifficulty.length - dLeft + 1; j++) {
            dailyMaxJobDiff = Math.max(dailyMaxJobDiff, jobDifficulty[j]);
            result = Math.min(result, dailyMaxJobDiff + minDifficulty(j + 1, dLeft - 1, jobDifficulty, dp));
        }
        return dp[index][dLeft] = result;
    }
}