/*
PROBLEM: 125: Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.\\

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/
function palindrome(s: string): boolean {
    s = s.trim().toLowerCase().replace(/[^a-z0-9]/g, '');

    let right = s.length - 1;
    let left = 0;

    while(left < right) {
        if(s[left] == s[right]) {
            left++;
            right--;
        } else {
            return false;
        }
    }
    return true;
};