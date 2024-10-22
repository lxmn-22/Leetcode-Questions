/*
Write a function argumentsLength that returns the count of arguments passed to it.

Example 1:
Input: args = [5]
Output: 1
Explanation:
argumentsLength(5); // 1
One value was passed to the function so it should return 1.

Example 2:
Input: args = [{}, null, "3"]
Output: 3
*/
/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
	return args.length;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */