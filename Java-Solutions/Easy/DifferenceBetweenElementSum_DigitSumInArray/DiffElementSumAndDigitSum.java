/* You are given a positive integer array nums.
The element sum is the sum of all the elements in nums.
The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.
Return the absolute difference between the element sum and digit sum of nums.
Note that the absolute difference between two integers x and y is defined as |x - y|. 
*/

class DiffElementSumAndDigitSum {
      static int differenceOfSum(int[] nums) {
      int elementSum = 0;
      int digitSum = 0;

      for (int num : nums) {
            elementSum += num;
            digitSum += getDigitSum(num);
      }
      return Math.abs(elementSum - digitSum);
}
      static int getDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
      int[] nums = {1, 15, 6, 3};
      System.out.println("The absolute difference: " +differenceOfSum(nums));
    }
}