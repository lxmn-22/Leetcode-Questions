/*
PROBLEM: 1400: Construct K Panlindrome Strings

Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

Example 1:
Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"

Example 2:
Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.

Example 3:
Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.
*/
function canConstruct(s: string, k: number): boolean {
    if(s.length < k) {
        return false;
    }

    let oddBitCount = 0;

    for (let i = 0; i < s.length; i++) {
        const alphaIndex = s[i].charCodeAt(0) - 97;
        const alphaBit = 1 << alphaIndex;

        oddBitCount = oddBitCount ^ alphaBit;
    }

    let oddCount = 0;

    for(let i = 0; i < 26; i++) {
        if(oddBitCount % 2 > 0) {
            oddCount++;
        }
        oddBitCount = oddBitCount >> 1;
    }

    if (oddCount > k) {
        return false;
    }

    return true
};