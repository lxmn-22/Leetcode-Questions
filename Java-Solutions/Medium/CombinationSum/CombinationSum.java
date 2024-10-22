/*Question: Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates,
where the chosen numbers sum to target. 
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
*/
class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<Integer> combination, List<List<Integer>> result, int idx) {
        if (target < 0 || idx == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(combination);
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            combination.add(candidates[i]);
            helper(candidates, target - candidates[i], new ArrayList<>(combination), result, i);
            combination.remove(combination.size() - 1);
        }
    }
}