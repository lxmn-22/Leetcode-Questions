/*
PROBLEM: 3306: Count of Substrings Containing Every Vowel and K Constants II

You are given a string word and a non-negative integer k.

Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.

Example 1:
Input: word = "aeioqq", k = 1
Output: 0

Explanation:
There is no substring with every vowel.

Example 2:
Input: word = "aeiou", k = 0
Output: 1

Explanation:
The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".

Example 3:
Input: word = "ieaouqqieaouqq", k = 1
Output: 3

Explanation:
The substrings with every vowel and one consonant are:
word[0..5], which is "ieaouq".
word[6..11], which is "qieaou".
word[7..12], which is "ieaouq".
*/
function countOfSubstrings(word: string, k: number): number {
	let frequencies: number[][] = [
		new Array(128).fill(0),
		new Array(128).fill(0),
	];
	"aeiou".split("").forEach((v) => (frequencies[0][v.charCodeAt(0)] = 1));

	let response = 0;
	let currentK = 0;
	let vowels = 0;
	let extraLeft = 0;
	let left = 0;

	for (let right = 0; right < word.length; right++) {
		let rightChar = word.charCodeAt(right);

		if (frequencies[0][rightChar] === 1) {
			if (++frequencies[1][rightChar] === 1) {
				vowels++;
			}
		} else {
			currentK++;
		}

		while (currentK > k) {
			let leftChar = word.charCodeAt(left);

			if (frequencies[0][leftChar] === 1) {
				if (--frequencies[1][leftChar] === 0) {
					vowels--;
				}
			} else {
				currentK--;
			}
			left++;
			extraLeft = 0;
		}

		while (
			vowels === 5 &&
			currentK === k &&
			left < right &&
			frequencies[0][word.charCodeAt(left)] === 1 &&
			frequencies[1][word.charCodeAt(left)] > 1
		) {
			extraLeft++;
			frequencies[1][word.charCodeAt(left)]--;
			left++;
		}

		if (currentK === k && vowels === 5) {
			response += 1 + extraLeft;
		}
	}

	return response;
}
