/*
 * Given the array of integers nums, you will choose two different indices i and
 * j of that array.
 * Return the maximum value of (nums[i]-1)*(nums[j]-1).
 * 
 * Example 1:
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will
 * get the maximum
 * value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 */
class MaximumProductOfTwoElementsOfTheArray {
    int maxOne = Integer.MIN_VALUE;
    int maxTwo = Integer.MIN_VALUE;

    public static int maxProduct(int[] nums) {
        for (int num : nums) {
            if (maxOne < num) {
                maxTwo = maxOne;
                maxOne = num;
            } else if (maxTwo < num) {
                maxTwo = num;
            }
        }
        return (maxOne - 1) * (maxTwo - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 2 };
        System.out.println("Max product: " + maxProduct(nums));
    }
}