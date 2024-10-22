/* 
Given a string s, reverse the string according to the following rules:
All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.
 */
class ReverseOnlyLetters {
      public static String reverseOnlyLetters(String s) {
            int start = 0;
            int end = s.length() - 1;
            char[] letters = s.toCharArray();
            while (start <= end) {
                  while (start <= end && !Character.isLetter(s.charAt(start))) {
                        start++;
                  }
                  while (end >= start && !Character.isLetter(s.charAt(end))) {
                        end--;
                  }
                  if (start <= end) {
                        char temp = letters[start];
                        letters[start++] = letters[end];
                        letters[end--] = temp;
                  }
            }
            return String.valueOf(letters);
      }
      public static void main(String[] args) {
            String s = "ab-cd";
            System.out.println("Reversed String: "+reverseOnlyLetters(s));
      }
}