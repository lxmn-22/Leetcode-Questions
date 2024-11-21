/*
PROBLEM: 2257: Count Unguarded Cells in the Grid

You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.

A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

Return the number of unoccupied cells that are not guarded.

Example 1:
Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
Output: 7
Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
There are a total of 7 unguarded cells, so we return 7.

Example 2:
Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
Output: 4
Explanation: The unguarded cells are shown in green in the above diagram.
There are a total of 4 unguarded cells, so we return 4.
*/
function countUnguarded(m: number, n: number, guards: number[][], walls: number[][]): number {
    // Initialize grid with zeros.
    const g: number[][] = Array(m).fill(0).map(() => Array(n).fill(0));
    
    // Mark guards and walls as 2.
    for (const [x, y] of guards) {
        g[x][y] = 2;
    }
    for (const [x, y] of walls) {
        g[x][y] = 2;
    }
    
    // Directions: up, right, down, left.
    const dirs = [-1, 0, 1, 0, -1];
    
    // Process each guard's line of sight.
    for (const [guardX, guardY] of guards) {
        for (let k = 0; k < 4; k++) {
            let x = guardX, y = guardY;
            const dx = dirs[k], dy = dirs[k + 1];
            
            // Check cells in current direction until hitting boundary or obstacle.
            while (x + dx >= 0 && x + dx < m && y + dy >= 0 && y + dy < n && g[x + dx][y + dy] < 2) {
                x += dx;
                y += dy;
                g[x][y] = 1;
            }
        }
    }
    
    // Count unguarded cells (cells with value 0).
    return g.reduce((count, row) => 
        count + row.filter(cell => cell === 0).length, 0);
}