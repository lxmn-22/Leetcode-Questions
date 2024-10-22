/*
 * An image smoother is a filter of the size 3 x 3 that can be applied to each
 * cell of an image by rounding down the average of
 * the cell and the eight surrounding cells (i.e., the average of the nine cells
 * in the blue smoother). If one or more of the
 * surrounding cells of a cell is not present, we do not consider it in the
 * average (i.e., the average of the four cells in the red smoother).
 * 
 * Given an m x n integer matrix img representing the grayscale of an image,
 * return the image after applying the smoother on each cell of it.
 * 
 * Example 1:
 * Input: img = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[0,0,0],[0,0,0],[0,0,0]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 */
class ImageSmoother {
    public static int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int count = 1;
                int sum = M[i][j];

                if (j - 1 >= 0) {
                    count++;
                    sum += M[i][j - 1];
                }
                if (j + 1 < M[0].length) {
                    count++;
                    sum += M[i][j + 1];
                }
                if (i - 1 >= 0) {
                    count++;
                    sum += M[i - 1][j];
                }
                if (i + 1 < M.length) {
                    count++;
                    sum += M[i + 1][j];
                }
                if (i + 1 < M.length && j + 1 < M[0].length) {
                    count++;
                    sum += M[i + 1][j + 1];
                }
                if (i + 1 < M.length && j - 1 >= 0) {
                    count++;
                    sum += M[i + 1][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    count++;
                    sum += M[i - 1][j - 1];
                }
                if (i - 1 >= 0 && j + 1 < M[0].length) {
                    count++;
                    sum += M[i - 1][j + 1];
                }
                res[i][j] = (int) Math.floor(sum / count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] M = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        System.out.println("Image Smoother: " + imageSmoother(M));
    }
}