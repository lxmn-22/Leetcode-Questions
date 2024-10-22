/* Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
*/
class CombinationSum2 {
      public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates, target, result, new ArrayList<>(), 0);
            return result;
      }
      private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> currCombination, int idx) {
            if (target <= 0) {
                  if (target == 0) {
                        result.add(new ArrayList<>(currCombination));
                  }
                  return;
            }
            for (int i = idx; i < candidates.length; i++) {
                  if (i > idx && candidates[i] == candidates[i - 1]) {
                        continue;
                  }
            currCombination.add(candidates[i]);
            helper(candidates, target - candidates[i], result, currCombination, i + 1);
            currCombination.remove(currCombination.size() - 1);
            }
      }
}