/*
PROBLEM: 118: Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
*/
function generate(numRows: number): number[][] {
    const triangle: number[][] = [];

    for(let i = 0; i < numRows; i++) {
        const newRow: number[] = Array(i + 1).fill(1);

        for(let j = 1; j < i; j++) {
            newRow[j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
        }
        triangle.push(newRow);
    }
    return triangle;
}