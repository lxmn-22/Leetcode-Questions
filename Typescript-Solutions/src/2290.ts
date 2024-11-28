/*
PROBLEM: 2290: Minimum Obstacle Removal to Reach Corner

You are given a 0-indexed 2D integer array grid of size m x n. Each cell has one of two values:

0 represents an empty cell,
1 represents an obstacle that may be removed.
You can move up, down, left, or right from and to an empty cell.

Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1).

Example 1:
Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
Output: 2
Explanation: We can remove the obstacles at (0, 1) and (0, 2) to create a path from (0, 0) to (2, 2).
It can be shown that we need to remove at least 2 obstacles, so we return 2.
Note that there may be other ways to remove 2 obstacles to create a path.

Example 2:
Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
Output: 0
Explanation: We can move from (0, 0) to (2, 4) without removing any obstacles, so we return 0.
*/
const DIRS = [[-1, 0], [0, -1], [0, 1], [1, 0]];

function minimumObstacles(grid: number[][]): number {
    const Y = grid.length;
    const X = grid[0].length;
    const queues = [[[0, 0]], [[Y-1, X-1]]];
    const visited: number[][] = new Array(Y);

    for (let y = 0; y < Y; ++y) {
        visited[y] = new Array(X).fill(0);
    }
    visited[0][0] = 1;
    visited[Y-1][X-1] = 2;

    let i = 1;
    let moves = -1;

    do {
        i ^= 1;
        const bit = 1 << i;
        const nextQ: number[][] = [];
        
        for (const [y, x] of queues[i]) {
            if (visited[y][x] - bit) {
                return Math.max(0, moves);
            }
            for (const [dy, dx] of DIRS) {
                const y2 = y + dy;
                const x2 = x + dx;
                if (y2 < 0 || y2 >= Y || x2 < 0 || x2 >= X) {
                    continue;
                }
                if (visited[y2][x2] & bit) {
                    continue;
                }
                visited[y2][x2] += bit;
                if (grid[y2][x2]) {
                    nextQ.push([y2, x2]);
                } else {
                    queues[i].push([y2, x2]);
                }
            }
        }
        queues[i] = nextQ;
        ++moves;
    } while (queues[i].length > 0);

    return -1;
};