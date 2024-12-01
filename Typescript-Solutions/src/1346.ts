/*
PROBLEM: 1346: Check If N and Its Double Exist

Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 
Example 1:
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

Example 2:
Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
*/
function checkIfExist(arr: number[]): boolean {
    const n = arr.length;
    const hashSet = new Set();

    for(let i = 0; i < n; i++) {
        const double = arr[i] * 2;
        const half = arr[i] / 2;

        if(hashSet.has(double) || (arr[i] % 2 === 0 && hashSet.has(half))) {
            return true;
        } else {
            hashSet.add(arr[i]);
        }
    }
    return false;
};