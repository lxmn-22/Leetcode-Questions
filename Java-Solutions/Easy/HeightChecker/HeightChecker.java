/* 
A school is trying to take an annual photo of all the students. 
The students are asked to stand in a single file line in non-decreasing order by height. 
Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. 
Each heights[i] is the height of the ith student in line (0-indexed).
Return the number of indices where heights[i] != expected[i].
*/

class HeightChecker {
    public static int heightChecker(int[] heights) {
        int[] frequencies = new int[101];
        for (int height : heights) {
            frequencies[height]++;
        }
        int currHeight = 1;
        int mismatchCount = 0;
        for (int height : heights) {
            while (frequencies[currHeight] == 0) {
                currHeight++;
            }
            if (currHeight != height) {
                mismatchCount++;
            }
            frequencies[currHeight]--;
        }
        return mismatchCount;
    }
    public static void main(String[] args) {
    int[] heights = {1,1,4,2,1,3};
    System.out.println(heightChecker(heights));
    }
}