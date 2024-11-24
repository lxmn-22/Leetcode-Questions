/*
PROBLEM: 1975: Maximum Matrix Sum

You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.

Example 1:
Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.

Example 2:
Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.
*/
function maxMatrixSum(matrix: number[][]): number {
    const n = matrix.length;
    let totalSum = 0;
    let negativeCount = 0;
    let minAbsoluteValue = Infinity;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            const value = matrix[i][j];
            totalSum += Math.abs(value);
            if (value < 0) negativeCount++;
            minAbsoluteValue = Math.min(minAbsoluteValue, Math.abs(value));
        }
    }
    // If the number of negatives is odd, one value remains negative
    if (negativeCount % 2 === 1) {
        totalSum -= 2 * minAbsoluteValue;
    }
    return totalSum;
};