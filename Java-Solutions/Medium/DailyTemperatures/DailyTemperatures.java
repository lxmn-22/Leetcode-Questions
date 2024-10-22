/*
Given an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have to wait after 
the ith day to get a warmer temperature. If there is no future day for which this is possible, 
keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
*/
package Medium.DailyTemperatures;

import java.util.*;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] T = {};
        System.out.println("Daily Temperatures: " + dailyTemperatures(T));
    }
}