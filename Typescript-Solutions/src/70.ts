/*
PROBLEM: 70: Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/
function climbStairs(n: number): number {

    if(n === 1) {
        return 1;
    }

    if(n === 2) {
        return 2;
    }

    let oneStepBefore = 2;
    let twoStepsBefore = 1;
    let allWays = 0;

    // Iterate from the third step to the last step
    for (let i = 3; i <= n; i++) {
        // Current step ways.
        allWays = oneStepBefore + twoStepsBefore;
        // Move to next step.
        twoStepsBefore = oneStepBefore;
        // Move to next step.
        oneStepBefore = allWays;         
    }
    return allWays;
};