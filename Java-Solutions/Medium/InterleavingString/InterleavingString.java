/*
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
An interleaving of two strings s and t is a configuration where s and t are divided into n and m 
substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.
 */
public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length()][s2.length()];
        return isInterleaveHelper(s1, 0, s2, 0, s3, 0, dp);
    }
  
    private static boolean isInterleaveHelper(String s1, int i1, String s2, int i2, String s3, int i3, Boolean[][] dp) {
        if (i1 == s1.length()) {
            return s2.substring(i2).equals(s3.substring(i3));
        }
        if (i2 == s2.length()) {
            return s1.substring(i1).equals(s3.substring(i3));
        }
        if (dp[i1][i2] != null) {
            return dp[i1][i2]; 
        }
        dp[i1][i2] = (s3.charAt(i3) == s1.charAt(i1) && isInterleaveHelper(s1, i1 + 1, s2, i2, s3, i3 + 1, dp)) || (s3.charAt(i3) == s2.charAt(i2) && isInterleaveHelper(s1, i1, s2, i2 + 1, s3, i3 + 1, dp));
        return dp[i1][i2];
    }
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println("Interleaving String: "+isInterleave(s1,s2,s3));
    }
}