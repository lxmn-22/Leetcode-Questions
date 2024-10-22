/*
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, 
more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"
 */
class ReverseVowelOfaString {
    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        while (left < right) {
            int vowelIndexLeft = vowels.indexOf(chars[left]);
            int vowelIndexRight = vowels.indexOf(chars[right]);
            if (vowelIndexLeft != -1 && vowelIndexRight != -1) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
            else if (vowelIndexRight == -1) {
                right--;
            }
            else {
                left++;
            }
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        String s = "hello";
        System.out.println("Given string: "+s);
        System.out.println("Reverse vowel of a string: "+reverseVowels(s));
    }
}