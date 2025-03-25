/*
PROBLEM: 3394: Check if Grid can be Cut into Sections

You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-left corner of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] is in the form [startx, starty, endx, endy], representing a rectangle on the grid. Each rectangle is defined as follows:

(startx, starty): The bottom-left corner of the rectangle.
(endx, endy): The top-right corner of the rectangle.
Note that the rectangles do not overlap. Your task is to determine if it is possible to make either two horizontal or two vertical cuts on the grid such that:

Each of the three resulting sections formed by the cuts contains at least one rectangle.
Every rectangle belongs to exactly one section.
Return true if such cuts can be made; otherwise, return false.

Example 1:
Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]
Output: true

Explanation:
The grid is shown in the diagram. We can make horizontal cuts at y = 2 and y = 4. Hence, output is true.

Example 2:
Input: n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]
Output: true

Explanation:
We can make vertical cuts at x = 2 and x = 3. Hence, output is true.

Example 3:
Input: n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]
Output: false

Explanation:
We cannot make two horizontal or two vertical cuts that satisfy the conditions. Hence, output is false.
*/
function checkValidCuts(n: number, rectangles: number[][]): boolean {
	const X = 0;
	const Y = 1;

	function check(dimension: number): boolean {
		rectangles.sort((a, b) => a[dimension] - b[dimension]);

		let max = 0;
		let line = 0;

		for (let i = 0; i < rectangles.length; i++) {
			const [x, y] = [
				rectangles[i][dimension],
				rectangles[i][dimension + 2],
			];

			if (x >= max && max > 0) {
				line++;
			}
			max = Math.max(max, y);
		}
		return line >= 2;
	}
	return check(X) || check(Y);
}
