
/*
The frequency of an element is the number of times it occurs in an array.
You are given an integer array nums and an integer k. In one operation, you can choose an index 
of nums and increment the element at that index by 1.
Return the maximum possible frequency of an element after performing at most k operations.

Example 1:
Input: nums = [1,2,4], k = 5
Output: 3
*/
import java.util.*;

class FrequencyOfTheMostFrequentElement {
    public static int maxFrequency(int[] nums, int k) {
        int ans = 0;
        long sum = 0;

        Arrays.sort(nums);

        for (int l = 0, r = 0; r < nums.length; ++r) {
            sum += nums[r];
            while (sum + k < (long) nums[r] * (r - l + 1)) {
                sum -= nums[l++];
            } 
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 5;
        System.out.println("Maximum Frequency: "+maxFrequency(nums, k));
    }
}