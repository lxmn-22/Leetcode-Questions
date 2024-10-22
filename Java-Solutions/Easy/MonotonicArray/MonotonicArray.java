/* An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. 
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise. 
*/
class MonotonicArray {
    public static boolean isMonotonic(int[] nums) {
        int idx = 0;
        int sign = 0;
        while (idx < nums.length - 1 && sign == 0) {
            if (nums[idx] < nums[idx + 1]) {
                sign = 1;
            } 
            else if (nums[idx] > nums[idx + 1]) {
                sign = -1;
            }
            idx++;
        }
        while (idx < nums.length - 1) {
            if ((sign == 1 && nums[idx] > nums[idx + 1]) || (sign == -1 && nums[idx] < nums[idx + 1])) {
                return false;
            }
            idx++;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        System.out.println("Is the given array Monotonic: "+isMonotonic(nums));
    }
}