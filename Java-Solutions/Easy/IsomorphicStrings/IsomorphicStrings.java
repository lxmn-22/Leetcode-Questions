/* 
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in "s" can be replaced to get "t".
All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character,
but a character may map to itself. 
*/
class IsomorphicStrings {
      public static boolean isIsomorphic(String s, String t) {
            int[] position = new int[512];
            for (int i = 0; i < s.length(); i++) {
                  if (position[s.charAt(i)] != position[t.charAt(i) + 256]) {
                        return false;
                  }
            position[s.charAt(i)] = position[t.charAt(i) + 256] = i + 1;
            }
            return true; 
      }
      public static void main(String[] args) {
            String s = "egg";
            String t = "add";
            System.out.println("Is the given strings are Isomorphic: "+isIsomorphic(s,t));
      }
}