/*
PROBLEM: 205: Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true

Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.

Example 2:
Input: s = "foo", t = "bar"
Output: false

Explanation:
The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:
Input: s = "paper", t = "title"
Output: true
*/
function isIsomorphic(s: string, t: string): boolean {
    const sMap: number[] = new Array(256).fill(-1);
    const tMap: number[] = new Array(256).fill(-1);
    const length = s.length;

    for (let i = 0; i < length; i++) {
        const sChar = s.charCodeAt(i);
        const tChar = t.charCodeAt(i);

        if (sMap[sChar] !== tMap[tChar]) {
            return false;
        }
        sMap[sChar] = tMap[tChar] = i;
    }
    return true;
}