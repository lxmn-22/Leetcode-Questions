/*
PROBLEM: 119: Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]
*/
function getRow(rowIndex: number): number[] {
    if (rowIndex === 0) {
        return [1];
    }

    let triangle: number[][] = [[1]];

    for (let i = 0; i < rowIndex; i++) {
        let lastRow: number[] = triangle[triangle.length - 1];
        let newRow: number[] = [1];

        for (let j = 1; j < lastRow.length; j++) {
            newRow.push(lastRow[j - 1] + lastRow[j]);
        }
        newRow.push(1);
        triangle.push(newRow);
    }
    return triangle[triangle.length - 1];
};