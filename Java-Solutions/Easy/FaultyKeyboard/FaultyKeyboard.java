/*
Your laptop keyboard is faulty and whenever you type a character 'i' on it, 
it reverses the string that you have written. Typing other characters works as expected.
You are given a 0-indexed string s, and you type each character of s using your faulty keyboard.
Return the final string that will be present on your laptop screen. 
*/
import java.util.*;

class FaultyKeyboard {
      public static String finalString(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            boolean flip = false;
            for (char c : s.toCharArray()) {
                  if (c == 'i') {
                        flip = !flip;
                  } 
                  else {
                        if (flip) {
                              deque.addFirst(c);
                        } 
                        else {
                              deque.addLast(c);
                        }
                  }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : deque){
                  sb.append(c);
            }
            return flip ? sb.reverse().toString() : sb.toString();
      }
      public static void main(String[] args) {
            String s = "string";
            System.out.println("Final String: "+finalString(s));;
      }
}