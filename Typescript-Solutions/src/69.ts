/*
PROBLEM: 69: Sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
*/
function mySqrt(x: number): number {
    // Initialize the lower and upper bounds for potential square roots.
    let low = 0;
    let high = x;

    // Binary search loop to find the square root.
    while(low <= high) {
        // Calculate the midpoint of the current search range.
        const mid = Math.floor((low + high) / 2);

        // Calculate the square of the midpoint.
        const value = mid * mid;
  
        // Compare the squared midpoint with the target value.
        if(value <= x) {
            // If the squared midpoint is less than or equal to the target,
            // update the lower bound to search on the right side.
            low = mid + 1;
        } else {
            // If the squared midpoint is greater than the target,
            // update the upper bound to search on the left side.
            high = mid - 1;
        }
    }
    // Return the largest integer whose square is less than or equal to x.
    return high;
};