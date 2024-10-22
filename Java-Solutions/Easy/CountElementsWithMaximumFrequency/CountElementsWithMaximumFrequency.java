/*
 * You are given an array nums consisting of positive integers.
 * 
 * Return the total frequencies of elements in nums such that those elements all
 * have the maximum frequency.
 * 
 * The frequency of an element is the number of occurrences of that element in
 * the array.
 *
 * Example 1:
 * 
 * Input: nums = [1,2,2,3,1,4]
 * Output: 4
 * Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum
 * frequency in the array.
 * So the number of elements in the array with maximum frequency is 4.
 * 
 * Example 2:
 * Input: nums = [1,2,3,4,5]
 * Output: 5
 * Explanation: All elements of the array have a frequency of 1 which is the
 * maximum.
 * So the number of elements in the array with maximum frequency is 5.
 */
class CountElementsWithMaximumFrequency {
    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        int maxFreq = Integer.MIN_VALUE;

        for (int freq : mp.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        for (int freq : mp.values()) {
            if (freq == maxFreq)
                count += maxFreq;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 1, 4 };
        System.out.println("Count Elements with Maximum Frequency: " + maxFrequencyElements(nums));
    }
}