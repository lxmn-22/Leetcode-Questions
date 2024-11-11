/*
 * PROBLEM: 2601: Prime Subtraction Operation
 * 
 * You are given a 0-indexed integer array nums of length n.
 * 
 * You can perform the following operation as many times as you want:
 * 
 * Pick an index i that you haven’t picked before, and pick a prime p strictly
 * less than nums[i], then subtract p from nums[i].
 * Return true if you can make nums a strictly increasing array using the above
 * operation and false otherwise.
 * 
 * A strictly increasing array is an array whose each element is strictly
 * greater than its preceding element.
 * 
 * Example 1:
 * Input: nums = [4,9,6,10]
 * Output: true
 * Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract
 * 3 from nums[0], so that nums becomes [1,9,6,10].
 * In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums
 * becomes equal to [1,2,6,10].
 * After the second operation, nums is sorted in strictly increasing order, so
 * the answer is true.
 * 
 * Example 2:
 * Input: nums = [6,8,11,12]
 * Output: true
 * Explanation: Initially nums is sorted in strictly increasing order, so we
 * don't need to make any operations.
 * 
 * Example 3:
 * Input: nums = [5,8,3]
 * Output: false
 * Explanation: It can be proven that there is no way to perform operations to
 * make nums sorted in strictly increasing order, so the answer is false.
 */
class PrimeSubtractionOperation {
    public boolean primeSubOperation(int[] nums) {
        int maxElement = getMaxElement(nums);

        // create sieve of eratosthenes array to identify prime no.
        boolean[] sieve = new boolean[maxElement + 1];
        fill(sieve, true);
        sieve[1] = false;

        for (int i = 2; i <= Math.sqrt(maxElement + 1); i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= maxElement; j += i) {
                    sieve[j] = false;
                }
            }
        }

        // check if array can be made strictly increasing by subtracting prime no.
        int currentValue = 1;
        int i = 0;

        while (i < nums.length) {
            int difference = nums[i] - currentValue;

            // return false if current no. is already smaller than required value.
            if (difference < 0) {
                return false;
            }

            // move to next number if difference is prime or zero.
            if (sieve[difference] == true || difference == 0) {
                i++;
                currentValue++;
            } else {
                currentValue++;
            }
        }
        return true;
    }

    // Helper method to find maximum element in array.
    private int getMaxElement(int[] nums) {
        int max = -1;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Helper method to init boolean array.
    private void fill(boolean[] arr, boolean value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
    }
}