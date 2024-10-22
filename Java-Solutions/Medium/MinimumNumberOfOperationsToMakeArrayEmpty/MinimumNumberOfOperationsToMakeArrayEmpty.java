/*
 * You are given a 0-indexed array nums consisting of positive integers
 * There are two types of operations that you can apply on the array any number
 * of times:
 * Choose two elements with equal values and delete them from the array.
 * Choose three elements with equal values and delete them from the array.
 * Return the minimum number of operations required to make the array empty, or
 * -1 if it is not possible.
 * 
 * Example 1:
 * Input: nums = [2,3,3,2,2,4,2,3,4]
 * Output: 4
 * Explanation: We can apply the following operations to make the array empty:
 * - Apply the first operation on the elements at indices 0 and 3. The resulting
 * array is
 * nums = [3,3,2,4,2,3,4].
 * - Apply the first operation on the elements at indices 2 and 4. The resulting
 * array is
 * nums = [3,3,4,3,4].
 * - Apply the second operation on the elements at indices 0, 1, and 3. The
 * resulting array is
 * nums = [4,4].
 * - Apply the first operation on the elements at indices 0 and 1. The resulting
 * array is nums = [].
 * It can be shown that we cannot make the array empty in less than 4
 * operations.
 */
class MinimumNumberOfOperationsToMakeArrayEmpty {
    public static int minOperations(int[] nums) {
        // Create a HashMap to store the frequency of each element in 'nums'.
        Map<Integer, Integer> mp = new HashMap<>();

        // Count the frequency of each element in 'nums'.
        for (int num : nums) {
            // Put the element in the map and increment its count by 1.
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // Initialize a variable to count the minimum operations needed.
        int count = 0;

        // Iterate through the entries in the HashMap.
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            // Get the frequency count of the current element.
            int t = entry.getValue();

            // If there is only one occurrence of any element, it's not possible to make it
            // divisible by 3.
            if (t == 1) {
                return -1;
            }
            // Calculate the number of operations needed to make the frequency divisible by
            // 3.
            count += t / 3; // Count the complete sets of 3 elements.

            if (t % 3 != 0) { // If there are remaining elements, increment the count.
                count++;
            }
        }
        // Return the total count of operations needed.
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 3, 2, 2, 4, 2, 3, 4 };
        System.out.println("Minimum Operations: " + minOperations(nums));
    }
}
