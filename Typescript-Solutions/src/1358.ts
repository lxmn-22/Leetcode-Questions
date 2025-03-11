/*
PROBLEM: 1358: Number of Substrings Containing All Three Characters

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

Example 3:
Input: s = "abc"
Output: 1
*/
function numberOfSubstrings(s: string): number {
	let char: string[] = s.split("");
	let abc: number[] = [-1, -1, -1];

	for (let i = 0; i < 3; i++) {
		abc[i] = -1;
	}

	let count = 0;
	let right = 0;

	while (right < char.length) {
		abc[char[right].charCodeAt(0) - "a".charCodeAt(0)] = right;
		let minIndex = Math.min(...abc);
		count += minIndex + 1;
		right++;
	}
	return count;
}
