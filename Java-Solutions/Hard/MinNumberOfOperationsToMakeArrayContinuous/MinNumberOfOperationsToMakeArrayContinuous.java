/*
You are given an integer array nums. In one operation, you can replace any element in nums with any 
integer.
nums is considered continuous if both of the following conditions are fulfilled:
All elements in nums are unique.
The difference between the maximum element and the minimum element in nums equals nums.length - 1.
For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.
Return the minimum number of operations to make nums continuous.

Example 1:
Input: nums = [4,2,5,3]
Output: 0
Explanation: nums is already continuous.

Example 2:
Input: nums = [1,2,3,5,6]
Output: 1
Explanation: One possible solution is to change the last element to 4.
The resulting array is [1,2,3,5,4], which is continuous.

Example 3:
Input: nums = [1,10,100,1000]
Output: 3
Explanation: One possible solution is to:
- Change the second element to 2.
- Change the third element to 3.
- Change the fourth element to 4.
The resulting array is [1,2,3,4], which is continuous.

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 109
 */
import java.util.*;
public class MinNumberOfOperationsToMakeArrayContinuous {
    public static int minOperations(int[] nums) {
        final int n = nums.length;
        int ans = n;

        Arrays.sort(nums);
        nums = Arrays.stream(nums).distinct().toArray();

        for (int i = 0; i < nums.length; ++i) {
            final int start = nums[i];
            final int end = start + n - 1;
            final int index = firstGreater(nums, end);
            final int uniqueLength = index - i;
            ans = Math.min(ans, n - uniqueLength);
        }
        return ans;
    }

    private static int firstGreater(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            final int m = (l + r) / 2;
            if (nums[m] > target) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        int[] nums = {4,2,5,3};
        System.out.println("Minimum operations: "+minOperations(nums));
    }
}
