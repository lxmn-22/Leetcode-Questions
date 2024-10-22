/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
 */
import java.util.*;
public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        Integer candidateOne = null;
        Integer candidateTwo = null;
        int countOne = 0;
        int countTwo = 0;
        for (int num : nums) {
            if (candidateOne != null && candidateOne == num) {
                countOne++;
            } else if (candidateTwo != null && candidateTwo == num) {
                countTwo++;
            } else if (countOne == 0) {
                candidateOne = num;
                countOne++;
            } else if (countTwo == 0) {
                candidateTwo = num;
                countTwo++;
            } else {
                countOne--;
                countTwo--;
            }
        }
        countOne = 0;
        countTwo = 0;
        for (int num : nums) {
            if (candidateOne != null && candidateOne == num) {
                countOne++;
            }
            if (candidateTwo != null && candidateTwo == num) {
                countTwo++;
            }
        }
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (countOne > n / 3) {
            result.add(candidateOne);
        }
        if (countTwo > n / 3) {
            result.add(candidateTwo);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println("Majority Element: "+majorityElement(nums));
    }
}