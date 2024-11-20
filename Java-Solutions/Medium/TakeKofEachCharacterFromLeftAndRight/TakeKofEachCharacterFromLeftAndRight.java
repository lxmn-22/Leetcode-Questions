package Medium.TakeKofEachCharacterFromLeftAndRight;

/*
PROBLEM: 2516: Take K of Each Character From Left and Right

You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.

Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.

Example 1:
Input: s = "aabaaaacaabc", k = 2
Output: 8
Explanation: 
Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
A total of 3 + 5 = 8 minutes is needed.
It can be proven that 8 is the minimum number of minutes needed.

Example 2:
Input: s = "a", k = 1
Output: -1
Explanation: It is not possible to take one 'b' or 'c' so return -1.
*/
class TakeKofEachCharacterFromLeftAndRight {
    public int takeCharacters(String s, int k) {
        int[] d = new int[3];
        int[] h = new int[3];

        for (char c : s.toCharArray()) {
            d[c - 'a']++;
        }
        for (int i = 0; i < 3; i++)
            if ((d[i] -= k) < 0) {
                return -1;
            }

        int m = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            h[s.charAt(r) - 'a']++;
            while (l <= r && h[s.charAt(r) - 'a'] > d[s.charAt(r) - 'a'])
                h[s.charAt(l++) - 'a']--;
            m = Math.max(m, r - l + 1);
        }
        return s.length() - m;
    }
}