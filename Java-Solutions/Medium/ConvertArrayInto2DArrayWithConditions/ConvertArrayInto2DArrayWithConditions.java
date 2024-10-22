/*
 * You are given an integer array nums. You need to create a 2D array from nums
 * satisfying the
 * following conditions:
 * 
 * The 2D array should contain only the elements of the array nums.
 * Each row in the 2D array contains distinct integers.
 * The number of rows in the 2D array should be minimal.
 * Return the resulting array. If there are multiple answers, return any of
 * them.
 * 
 * Note that the 2D array can have a different number of elements on each row.
 * 
 * Example 1:
 * Input: nums = [1,3,4,1,2,3,1]
 * Output: [[1,3,4,2],[1,3],[1]]
 * Explanation: We can create a 2D array that contains the following rows:
 * - 1,3,4,2
 * - 1,3
 * - 1
 * All elements of nums were used, and each row of the 2D array contains
 * distinct integers, so it is a valid answer.
 * It can be shown that we cannot have less than 3 rows in a valid array.
 */
class ConvertArrayInto2DArrayWithConditions {
    public static List<List<Integer>> findMatrix(int[] v) {
        Map<Integer, Integer> um = new HashMap<>();
        for (int i : v) {
            um.put(i, um.getOrDefault(i, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!um.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> toErase = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : um.entrySet()) {
                int f = entry.getKey();
                int s = entry.getValue();
                temp.add(f);
                s--;
                if (s == 0) {
                    toErase.add(f);
                }
                um.put(f, s);
            }
            ans.add(temp);
            for (int i : toErase) {
                um.remove(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] v = { 1, 3, 4, 1, 2, 3, 1 };
        System.out.println("Converting an Array into a 2D Array with conditions: " + findMatrix(v));
    }
}
