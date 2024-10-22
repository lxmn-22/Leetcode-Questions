/*
 * You are given two strings order and s. All the characters of order are unique
 * and were sorted in some custom order previously.
 * 
 * Permute the characters of s so that they match the order that order was
 * sorted. More specifically, if a character x occurs before a character y in
 * order, then x should occur before y in the permuted string.
 * 
 * Return any permutation of s that satisfies this property.
 * 
 * Example 1:
 * Input: order = "cba", s = "abcd"
 * Output: "cbad"
 * Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c"
 * should be "c", "b", and "a".
 * Since "d" does not appear in order, it can be at any position in the returned
 * string. "dcba", "cdba", "cbda" are also valid outputs.
 */
class CustomSortString {
    public static String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> mp = new HashMap<>();

        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        for (char c : order.toCharArray()) {
            if (mp.containsKey(c)) {
                result.append(String.valueOf(c).repeat(Math.max(0, mp.get(c))));
                mp.remove(c);
            }
        }

        for (char c : mp.keySet()) {
            result.append(String.valueOf(c).repeat(Math.max(0, mp.get(c))));
        }
        return result.toString();
    }
}