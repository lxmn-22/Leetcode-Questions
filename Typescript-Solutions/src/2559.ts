/*
PROBLEM: 2559: Count Vowel Strings in Ranges

You are given a 0-indexed array of strings words and a 2D array of integers queries.

Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.

Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].

Example 2:
Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
Explanation: Every string satisfies the conditions, so we return [3,2,1].
*/
function vowelStrings(words: string[], queries: number[][]): number[] {
    const vowels = ["a", "e", "i", "o", "u"];
    const prefixs = [];
    let sum = 0;

    for(const word of words) {
        const isVowel = vowels.includes(word[0]) && vowels.includes(word[word.length - 1])
        if(isVowel) {
            sum += 1;
        }
        prefixs.push(sum);
    }

    const result = [];

    for(const query of queries) {
        result.push(prefixs[query[1]] - (query[0] > 0 ? prefixs[query[0] - 1] : 0))
    }
    return result;
};