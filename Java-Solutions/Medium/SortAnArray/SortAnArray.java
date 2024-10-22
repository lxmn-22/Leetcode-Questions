/*
Given an array of integers nums, sort the array in ascending order and return it.
You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and 
with the smallest space complexity possible.

Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), 
while the positions of other numbers are changed (for example, 1 and 5).

Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
*/
public class SortAnArray {
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
  
    private static void mergeSort(int[] nums, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }
  
    private static void merge(int[] nums, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int[] temp = new int[end - start + 1];
        int idx = 0;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[idx++] = nums[left++];
        }
        while (right <= end) {
            temp[idx++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i - start];
        }
    }
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        System.out.println("Sorted Array: "+sortArray(nums));
    }
}