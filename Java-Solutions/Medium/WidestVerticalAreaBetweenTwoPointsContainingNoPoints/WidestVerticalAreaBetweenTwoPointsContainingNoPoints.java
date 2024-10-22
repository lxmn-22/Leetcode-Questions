/*
 * Given n points on a 2D plane where points[i] = [xi, yi], Return the widest
 * vertical area between
 * two points such that no points are inside the area.
 * 
 * A vertical area is an area of fixed-width extending infinitely along the
 * y-axis (i.e., infinite
 * height). The widest vertical area is the one with the maximum width.
 * 
 * Note that points on the edge of a vertical area are not considered included
 * in the area.
 * 
 * Example 1:
 * 
 * Input: points = [[8,7],[9,9],[7,4],[9,7]]
 * Output: 1
 * Explanation: Both the red and the blue area are optimal.
 */
class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static int maxWidthOfVerticalArea(int[][] points) {
        int ans = 0;
        int[] xs = new int[points.length];

        for (int i = 0; i < points.length; ++i) {
            xs[i] = points[i][0];
        }

        Arrays.sort(xs);

        for (int i = 1; i < xs.length; ++i) {
            ans = Math.max(ans, xs[i] - xs[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = { { 8, 7 }, { 9, 9 }, { 7, 4 }, { 9, 7 } };
        System.out.println("Maximum width of vertical area: " + maxWidthOfVerticalArea(points));
    }
}