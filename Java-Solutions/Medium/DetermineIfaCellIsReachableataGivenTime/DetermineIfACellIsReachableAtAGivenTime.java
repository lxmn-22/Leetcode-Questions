/*
You are given four integers sx, sy, fx, fy, and a non-negative integer t.
In an infinite 2D grid, you start at the cell (sx, sy). 
Each second, you must move to any of its adjacent cells.
Return true if you can reach cell (fx, fy) after exactly t seconds, or false otherwise.
A cell's adjacent cells are the 8 cells around it that share at least one corner with it. 
You can visit the same cell several times.

Example 01:
Input: sx = 2, sy = 4, fx = 7, fy = 7, t = 6
Output: true
Explanation: Starting at cell (2, 4), we can reach cell (7, 7) in exactly 6 seconds by going through 
the cells depicted in the picture above. 
*/
class DetermineIfACellIsReachableAtAGivenTime {
    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xDiff = Math.abs(sx - fx);
        int yDiff = Math.abs(sy - fy);
        if (xDiff == 0 && yDiff == 0 && t == 1) {
            return false;
        }
        return (Math.min(xDiff, yDiff) + Math.abs(xDiff - yDiff)) <= t; 
    }
    public static void main(String[] args) {
        int sx = 2;
        int sy = 4;
        int fx = 7;
        int fy = 7;
        int t = 6;
        System.out.println("Determine if a cell is reachable at a given time: "+isReachableAtTime(sx, sy, fx, fy, t));
    }
}