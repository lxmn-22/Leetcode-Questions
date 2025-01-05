/*
PROBLEM: 2381: Shifting Letters II

You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

Return the final string after all such shifts to s are applied.

Example 1:
Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
Output: "ace"
Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".

Example 2:
Input: s = "dztz", shifts = [[0,0,0],[1,1,1]]
Output: "catz"
Explanation: Firstly, shift the characters from index 0 to index 0 backward. Now s = "cztz".
Finally, shift the characters from index 1 to index 1 forward. Now s = "catz".
*/
function shiftingLetters(s: string, shifts: number[][]): string {
    const prefix = new Array(s.length + 1).fill(0);

    for (const [start, end, d] of shifts) {
        prefix[start] += d * 2 - 1;
        prefix[end + 1] -= d * 2 - 1;
    }

    const result = [];
    let difference = 0;

    for (let i = 0; i < s.length; i++) {
        difference += prefix[i];
        const charCode = (s.charCodeAt(i) - 97); // 'a' = 97
        const newCharCode = 97 + (charCode + (difference % 26) + 26) % 26;
        result.push(String.fromCharCode(newCharCode));
    }
    return result.join("");
};