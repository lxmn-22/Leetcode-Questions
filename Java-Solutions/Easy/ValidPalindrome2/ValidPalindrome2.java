/* 
Given a string s, return true if the s can be palindrome after deleting at most one character from it. 
Input: s = "aba"
Output: true
*/
class ValidPalindrome2 {
      public static boolean validPalindrome(String s) {
            return validPalindromeHelper(s, false);
      }
      private static boolean validPalindromeHelper(String s, boolean deleted) {
            int startIdx = 0;
            int endIdx = s.length() - 1;
            while (startIdx < endIdx) {
                  if (s.charAt(startIdx) != s.charAt(endIdx)) {
                        if (deleted) {
                              return false;
                        }
                        return validPalindromeHelper(s.substring(0, startIdx) + s.substring(startIdx + 1), true) ||
                        validPalindromeHelper(s.substring(0, endIdx) + s.substring(endIdx + 1), true);
                  }
                  startIdx++;
                  endIdx--;
            }
            return true;
      }
      public static void main(String[] args) {
            String s = "aba";
            System.out.println("Is the given string a Palindrome: "+validPalindrome(s));
      }
}