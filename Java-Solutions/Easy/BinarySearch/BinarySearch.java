/*Question: Given an array of integers nums which is sorted in ascending order, and an integer key.
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.*/
import java.util.*;

class BinarySearch {
      static int binarySearch(int[] nums, int key) {
            int start = 0;
            int end = nums.length - 1;

            while(start <= end) {
                  // int mid = (start + (end - start)) / 2;
                  int mid = (start + end) / 2;

                  if(nums[mid] == key) {
                        return mid;
                  }
                  else if(nums[mid] < key) {
                        start = mid + 1;
                  }
                  else {
                        end = mid - 1;
                  }
            }
            return -1;
      }
    /*public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Value of number(nums): ");
      int nums = input.nextInt();
      System.out.print("Value of key: ");
      int key = input.nextInt();
      int result = binarySearch(nums, key);
      System.out.print("Key element "+key+" present at index: "+result);*/
}