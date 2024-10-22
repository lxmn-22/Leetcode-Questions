/*
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 *
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range
 * [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * 
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range
 * [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * 
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range
 * [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */

/*
 * Approach: Sorting
 * After sorting there will be 3 cases:
 * 1. No missing number.
 * 2. missing number is the last number.
 * 3. missing number is any number except first and last.
 */
class MissingNumber {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // Case 1.
        if (nums[0] != 0)
            return 0;

        // Case 2.
        if (nums[n - 1] != n)
            return n;

        // Case 3.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2 };
        System.out.println("Missing number: " + missingNumber(nums));
    }
}

/*
 * Approach: Sum of all elements.
 * 1. sum of all elements in the range[0,n].
 * 2. sum of nums.
 * 3. If we subtract both we'll get the missing number.
 */
class MissingNumber {
    public static int missingNumber(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum = totalSum + num;
        }
        int n = nums.length;
        int expectedSum = (n * (n + 1) / 2);

        return expectedSum - totalSum;
    }
}