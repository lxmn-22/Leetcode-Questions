/*
 * Given an integer array nums of length n where all the integers of nums are in
 * the range [1, n] and each integer appears once or twice, return an array of
 * all the integers that appears twice.
 * 
 * You must write an algorithm that runs in O(n) time and uses only constant
 * extra space.
 * 
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * 
 * Example 2:
 * Input: nums = [1,1,2]
 * Output: [1]
 * 
 * Example 3:
 * Input: nums = [1]
 * Output: []
 */
class FindAllDuplicatesInArray {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                result.add(x);
            }
            nums[x - 1] *= -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println("Find all duplicates in an Array: " + findDuplicates(nums));
    }
}