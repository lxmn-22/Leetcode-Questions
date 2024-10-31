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
