/*
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }

        Map<Character, Integer> sCount = new HashMap<>(), pCount = new HashMap<>();

        for (char c : p.toCharArray()) {
            pCount.merge(c, 1, Integer::sum);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            sCount.merge(s.charAt(i), 1, Integer::sum);
            if (i >= p.length()) {
                char leftMost = s.charAt(i - p.length());
                int leftMostCount = sCount.get(leftMost);
                if (leftMostCount == 1) {
                    sCount.remove(leftMost);
                } else {
                    sCount.put(leftMost, leftMostCount - 1);
                }
            }
            if (pCount.equals(sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}