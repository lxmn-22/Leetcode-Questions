/*
Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. 
You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. 
Return false otherwise.

Example 1:
Input: path = "NES"
Output: false 
Explanation: Notice that the path doesn't cross any point more than once.
 */
package Easy.PathCrossing;

class PathCrossing {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public static boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int currX = 0;
        int currY = 0;
        String dirSymbol = "NSEW";
        set.add(currX + "|" + currY);
        for (char c : path.toCharArray()) {
            int dirIdx = dirSymbol.indexOf(c);
            currX += dirs[dirIdx][0];
            currY += dirs[dirIdx][1];
            String hash = currX + "|" + currY;
            if (set.contains(hash)) {
                return true;
            }
            set.add(hash);
        }
        return false;
    }

    public static void main(String[] args) {
        String path = "NES";
        System.out.println("Path Crossing: " + isPathCrossing(path));
    }
}