/*
PROBLEM: 14: Longest Comman Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/
function longestCommonPrefix(strs: string[]): string {
  let result = strs[0]

  for (let index = 1; index < strs.length; index++) {
    while (strs[index].indexOf(result) !== 0) {
        result = result.slice(0, result.length - 1)

        if (result === '') {
            return result
        }
    }
  }
  return result
}