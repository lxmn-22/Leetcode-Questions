// You are given a non-negative integer array nums. In one operation, you must:

// Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
// Subtract x from every positive element in nums.
// Return the minimum number of operations to make every element in nums equal to 0.

 

class Solution {
    public int minimumOperations(int[] nums) {
        int maxI = 0;
        int max = 0;
        for(int i = 0;i< nums.length;i++){
            if(max < nums[i]){
                max = nums[i];
                maxI = i;
            }
        }
        int count = 0;
        while(nums[maxI] != 0){
            int min = max;
            for(int i =0;i<nums.length;i++){
                if(min > nums[i] && nums[i] != 0 && nums[i] > 0){
                    min = nums[i];
                }
            }
            for(int i =0;i< nums.length;i++){
                nums[i] -= min;
            }
            count++;
        }
        return count;

    }
}
