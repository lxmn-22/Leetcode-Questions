/*
PROBLEM: 916: Word Subsets

You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
*/
function wordSubsets(words1: string[], words2: string[]): string[] {
    const freqWord2 = new Array(26).fill(0);

    for (const word of words2) {
        const temp = new Array(26).fill(0);
        
        for (const ch of word) {
            temp[ch.charCodeAt(0) - 'a'.charCodeAt(0)]++;
            freqWord2[ch.charCodeAt(0) - 'a'.charCodeAt(0)] = Math.max(
                freqWord2[ch.charCodeAt(0) - 'a'.charCodeAt(0)],
                temp[ch.charCodeAt(0) - 'a'.charCodeAt(0)]
            );
        }
    }

    const result: string[] = [];
    for (const word of words1) {
        const temp = new Array(26).fill(0);
        for (const ch of word) {
            temp[ch.charCodeAt(0) - 'a'.charCodeAt(0)]++;
        }

        if (freqWord2.every((freq, i) => temp[i] >= freq)) {
            result.push(word);
        }
    }
    return result;
}