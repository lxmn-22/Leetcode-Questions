/* We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.
*/
class DetectCapital {
      public static boolean detectCapitalUse(String word) {
            boolean firstUpperCase = Character.isUpperCase(word.charAt(0));
            boolean allUpperCase = false;
            for (int i = 1; i < word.length(); i++) {
                  if (Character.isUpperCase(word.charAt(i))) {
                        if (!firstUpperCase) {
                              return false;
                        }
                        if (i == 1) {
                              allUpperCase = true;
                        } 
                        else {
                              if (!allUpperCase) {
                                    return false;
                              }
                        }
                  } 
                  else {
                        if (allUpperCase) {
                              return false;
                        }
                  }
            }
            return true;
      }
      public static void main(String[] args) {
            String word = "leetcode";
            System.out.println("Is the word in capital letters: "+detectCapitalUse(word));
      }
}