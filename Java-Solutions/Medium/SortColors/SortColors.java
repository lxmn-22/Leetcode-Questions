/* 
Given an array nums with n objects colored red, white, or blue, 
sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
*/
public class SortColors {
    public static void sortColors(int[] nums) {
        int zeroIdx = 0;
        int twoIdx = nums.length - 1;
        for (int i = 0; i <= twoIdx; ) {
            if (nums[i] == 0 && i != zeroIdx) {
                int temp = nums[zeroIdx];
                nums[zeroIdx++] = nums[i];
                nums[i] = temp;
            } 
            else if (nums[i] == 2 && i != twoIdx) {
                int temp = nums[twoIdx];
                nums[twoIdx--] = nums[i];
                nums[i] = temp;
            } 
            else {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.print(sortColors(nums));
    }
}