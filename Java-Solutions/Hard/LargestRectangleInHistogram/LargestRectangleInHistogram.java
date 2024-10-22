/*
Given an array of integers heights representing the histogram's bar height 
where the width of each bar is 1, 
return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
 */
package Hard.LargestRectangleInHistogram;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int currHeight = i == n ? 0 : heights[i];
            // check if currHeight becomes greater then height[top] element of stack. we do
            // a push because it's an increasing sequence
            // otherwise we do pop and find area, so for that we write a while loop
            while (!st.isEmpty() && currHeight < heights[st.peek()]) {
                int top = st.pop(); // current element on which we are working
                // now we need width & area
                int width = st.isEmpty() ? i : i - st.peek() - 1; // width differ, if stack is empty or not empty after
                                                                  // we pop the element
                int area = heights[top] * width; // current height * width
                maxArea = Math.max(area, maxArea);
            }
            // if it doesn't enter in while loop, it means it's an increasing sequence & we
            // need to push index
            st.push(i);
        }
        return maxArea;
    }
}
// Brute force solution.

/*
 * class Solution {
 * public int largestRectangleArea(int[] heights) {
 * int n = heights.length;
 * if(n == 0) return 0; // Base Condition
 * int maxArea = 0;
 * int left[] = new int[n]; //fill left boundary
 * int right[] = new int[n]; // fill right boundary
 * 
 * left[0] = -1;
 * right[n - 1] = n;
 * 
 * for(int i = 1; i < n; i++){
 * int prev = i - 1; // previous for comparing the heights
 * while(prev >= 0 && heights[prev] >= heights[i]){
 * prev = left[prev]; // we have done this to minimise the jumps we make to the
 * left
 * }
 * left[i] = prev;
 * }
 * // Similarly we do for right
 * for(int i = n - 2; i >= 0; i--){
 * int prev = i + 1;
 * while(prev < n && heights[prev] >= heights[i]){
 * prev = right[prev];
 * }
 * right[i] = prev;
 * }
 * // once we have these two arrays fill we need width & area
 * for(int i = 0; i < n; i++){
 * int width = right[i] - left[i] - 1;
 * maxArea = Math.max(maxArea, heights[i] * width);
 * }
 * return maxArea;
 * 
 * }
 * }
 */