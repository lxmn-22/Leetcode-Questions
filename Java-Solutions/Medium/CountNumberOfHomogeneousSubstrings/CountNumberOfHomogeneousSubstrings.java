/*
Given a string s, return the number of homogenous substrings of s. 
Since the answer may be too large, return it modulo 109 + 7.
A string is homogenous if all the characters of the string are the same.
A substring is a contiguous sequence of characters within a string.

Example 1:
Input: s = "abbcccaa"
Output: 13
Explanation: The homogenous substrings are listed as below:
"a"   appears 3 times.
"aa"  appears 1 time.
"b"   appears 2 times.
"bb"  appears 1 time.
"c"   appears 3 times.
"cc"  appears 2 times.
"ccc" appears 1 time.
3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
 */
public class CountNumberOfHomogeneousSubstrings {

    private static final int MOD = 1_000_000_007;

    public static int countHomogenous(String s) {
        int result = 0;
        int streak = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                streak++;
            } else {
                streak = 1;
            }
            result = (result + streak) % MOD;
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "abbcccaa";
        System.out.println("Count Number of Homogenous Substrings: "+countHomogenous(s));
    }
}
