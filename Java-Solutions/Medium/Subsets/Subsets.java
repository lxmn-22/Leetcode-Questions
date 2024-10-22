/* Given an integer array nums of unique elements, return all possible subsets(the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] 
*/
import java.util.*;
class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void helper(int[] nums, int currIdx, List<Integer> currSubset, List<List<Integer>> result) {
        result.add(new ArrayList<>(currSubset));
        if (currIdx >= nums.length) {
            return;
        }
        for (int i = currIdx; i < nums.length; i++) {
            currSubset.add(nums[i]);
            helper(nums, i + 1, currSubset, result);
            currSubset.remove(currSubset.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}