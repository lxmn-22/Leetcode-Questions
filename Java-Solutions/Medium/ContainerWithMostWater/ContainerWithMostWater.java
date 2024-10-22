/*
You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
Example1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maximumArea = 0;
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        while (leftIdx < rightIdx) {
            int maxHeight = Math.min(height[leftIdx], height[rightIdx]);
            int currArea = maxHeight * (rightIdx - leftIdx);
            maximumArea = Math.max(currArea, maximumArea);
            if (maxHeight == height[leftIdx]) {
                leftIdx++;
            } 
            else {
                rightIdx--;
            }
        }
        return maximumArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Container can contain: "+maxArea(height));
    }
}