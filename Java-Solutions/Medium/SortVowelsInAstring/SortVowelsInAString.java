/*
Given a 0-indexed string s, permute s to get a new string t such that:

All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.
length such that s[i] is a consonant, then t[i] = s[i].
The vowels must be sorted in the nondecreasing order of their ASCII values. 
More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels,
then t[i] must not have a higher ASCII value than t[j].
Return the resulting string.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. 
Consonants comprise all letters that are not vowels.

Example 1:
Input: s = "lEetcOde"
Output: "lEOtcede"
*/
import java.util.*;

class SortVowelsInAString {
    public static String sortVowels(String inputString) {
        int length = inputString.length();
        ArrayList<Character> vowelsList = new ArrayList<>();
        ArrayList<Integer> vowelPositions = new ArrayList<>();
        
        for (int i = 0; i < length; i++) {
            char currentChar = inputString.charAt(i);
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || 
                currentChar == 'o' || currentChar == 'u' || currentChar == 'A' || 
                currentChar == 'E' || currentChar == 'I' || currentChar == 'O' || 
                currentChar == 'U') {
                vowelsList.add(currentChar);
                vowelPositions.add(i);
            }
        }
        Collections.sort(vowelsList);
        
        char[] resultArray = inputString.toCharArray();
        for (int i = 0; i < vowelPositions.size(); i++) {
            resultArray[vowelPositions.get(i)] = vowelsList.get(i);
        }
        return new String(resultArray);
    }
    public static void main(String[] args) {
        String inputString = "lEetcOde"; 
        System.out.println("Sort Vowels: "+sortVowels(inputString));
    }
}