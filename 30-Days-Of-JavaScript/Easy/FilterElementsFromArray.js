/*
Given an integer array arr and a filtering function fn, return a filtered array filteredArr.
The fn function takes one or two arguments:
arr[i] - number from the arr
i - index of arr[i]
filteredArr should only contain the elements from the arr for which the expression fn(arr[i], i) 
evaluates to a truthy value. A truthy value is a value where Boolean(value) returns true.

Please solve it without the built-in Array.filter method.

Example 1:
Input: arr = [0,10,20,30], fn = function greaterThan10(n) { return n > 10; }
Output: [20,30]
*/

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    var result = [];
    for(var i = 0; i < arr.length; i++) {
        if(fn(arr[i], i)) {
            result.push(arr[i]);
        }
    }
    return result;
};