/*
Given two strings word1 and word2, return the minimum number of operations required to convert 
word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */
package Medium.EditDistance;

class EditDistance {
    public static int minDistance(String word1, String word2) {
        return minDistanceHelper(word1, word2, word1.length(), word2.length(),
                new Integer[word1.length() + 1][word2.length() + 1]);
    }

    private static int minDistanceHelper(String word1, String word2, int word1Index, int word2Index, Integer[][] memo) {
        if (word1Index == 0) {
            return word2Index;
        }
        if (word2Index == 0) {
            return word1Index;
        }
        if (memo[word1Index][word2Index] != null) {
            return memo[word1Index][word2Index];
        }
        int minEditDistance = 0;
        if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
            minEditDistance = minDistanceHelper(word1, word2, word1Index - 1, word2Index - 1, memo);
        } else {
            int distanceWithInsertion = minDistanceHelper(word1, word2, word1Index, word2Index - 1, memo);
            int distanceWithDeletion = minDistanceHelper(word1, word2, word1Index - 1, word2Index, memo);
            int distanceWithReplace = minDistanceHelper(word1, word2, word1Index - 1, word2Index - 1, memo);
            minEditDistance = Math.min(distanceWithInsertion,
                    Math.min(distanceWithDeletion, distanceWithReplace)) + 1;
        }
        memo[word1Index][word2Index] = minEditDistance;
        return minEditDistance;
    }
}