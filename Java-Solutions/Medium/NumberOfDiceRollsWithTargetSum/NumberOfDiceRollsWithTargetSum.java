/*
 * You have n dice, and each die has k faces numbered from 1 to k.
 * 
 * Given three integers n, k, and target, return the number of possible ways
 * (out of the kn total ways) to roll the dice, so the sum of the face-up
 * numbers equals target.
 * Since the answer may be too large, return it modulo 109 + 7.
 * 
 * Example 1:
 * Input: n = 1, k = 6, target = 3
 * Output: 1
 * Explanation: You throw one die with 6 faces.
 * There is only one way to get a sum of 3.
 */
class NumberOfDiceRollsWithTargetSum {
    Map<String, Integer> map = new HashMap<>();
    final int MODULO = 1000000007;

    public static int numRollsToTarget(int d, int f, int target) {
        if (d == 0 && target == 0) {
            return 1;
        }
        if (d == 0 || target == 0) {
            return 0;
        }
        String key = d + "|" + target;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = 0;
        for (int i = 1; i <= f; i++) {
            if (target >= i) {
                res = (res + numRollsToTarget(d - 1, f, target - i)) % MODULO;
            } else {
                break;
            }
        }
        map.put(key, res);
        return map.get(key);
    }

    public static void main(String[] args) {
        int d = 1;
        int f = 6;
        int target = 3;
        System.out.println("Number of Dice Rolls With Target Sum: " + numRollsToTarget(d, f, target));
    }
}