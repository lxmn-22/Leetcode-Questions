/*
PROBLEM: 2516: Take K of Each Character From Left and Right

You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.

Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.

Example 1:
Input: s = "aabaaaacaabc", k = 2
Output: 8
Explanation: 
Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
A total of 3 + 5 = 8 minutes is needed.
It can be proven that 8 is the minimum number of minutes needed.

Example 2:
Input: s = "a", k = 1
Output: -1
Explanation: It is not possible to take one 'b' or 'c' so return -1.
*/
function takeCharacters(s: string, k: number): number {
    // total counts.
    const count: number[] = [0, 0, 0];

    for(const c of s) {
        count[c.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

    if(Math.min(...count) < k) {
        return -1;
    }

    // sliding window.
    let result = Infinity;
    let l = 0;

    for(let r = 0; r < s.length; r++) {
        count[s.charCodeAt(r) - 'a'.charCodeAt(0)]--;

        while(Math.min(...count) < k) {
            count[s.charCodeAt(l) - 'a'.charCodeAt(0)]++;
            l++;
        }
        result = Math.min(result, s.length - (r - l + 1));
    }
    return result;
};