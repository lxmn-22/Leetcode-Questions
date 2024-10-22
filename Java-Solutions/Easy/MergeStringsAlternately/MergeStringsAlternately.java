/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, 
starting with word1. If a string is longer than the other, 
append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
*/
class MergeStringsAlternately {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int idxOne = 0;
        int idxTwo = 0;
        while (idxOne < word1.length() || idxTwo < word2.length()) {
            if (idxOne < word1.length()) {
                sb.append(word1.charAt(idxOne++));
            }
            if (idxTwo < word2.length()) {
                sb.append(word2.charAt(idxTwo++));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println("Merge Strings Alternately: "+mergeAlternately(word1, word2));
    }
}