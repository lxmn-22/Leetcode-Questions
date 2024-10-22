public class SortArrayByParity 
{
    public int[] sortArrayByParity(int[] nums) 
    {
        int evenIdx = 0;
        int oddIdx = nums.length - 1;

        while(evenIdx < oddIdx)
        {
            if(nums[evenIdx] % 2 == 0)
            {
                evenIdx++;
            }
            else
            {
                int temp = nums[evenIdx];
                nums[evenIdx] = nums[oddIdx];
                nums[oddIdx--] = temp;
            }
        }
        return nums;
    }
    public static void main(String[] args)
    {
      int[] nums = {1,2,3,4,5,6};
      sortArrayByParity();
    }
} 
