/* Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, 
otherwise, return false.
Swapping letters is defined as taking two indices i and j 
(0-indexed) such that i != j and swapping the characters at s[i] and s[j].
For example, swapping at indices 0 and 2 in "abcd" results in "cbad". 
*/
import java.util.*;

class BuddyStrings {
      private static final int SWAP_DONE_IDX = Integer.MIN_VALUE;
    
      public static boolean buddyStrings(String s, String goal) {
            if (s.length() != goal.length()) {
                  return false;
            }   
            int swapIdx = -1;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                  if (s.charAt(i) == goal.charAt(i)) {
                        set.add(s.charAt(i));
                        continue;
                  }
                  if (s.charAt(i) != goal.charAt(i)) {
                        if (swapIdx == SWAP_DONE_IDX) {
                              return false;
                        }
                        if (swapIdx == -1) {
                              swapIdx = i;
                              continue;
                        } 
                        if (!(s.charAt(swapIdx) == goal.charAt(i) && s.charAt(i) == goal.charAt(swapIdx))) {
                              return false;
                        }
                  swapIdx = SWAP_DONE_IDX;
                  }
            }
            return (swapIdx != -1 && swapIdx == SWAP_DONE_IDX) || (swapIdx == -1 && set.size() < s.length());
      }
      public static void main(String[] args) {
      String s = "ab";
      String goal = "ba";
      System.out.println("Is the given strings are buddy strings: "+buddyStrings(s,goal));
      }
}