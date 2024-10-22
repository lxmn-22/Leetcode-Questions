/*Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
To flip an image horizontally means that each row of the image is reversed.
For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
For example, inverting [0,1,1] results in [1,0,0]. 
*/

class FlippingTheImage {
      public int[][] flipAndInvertImage(int[][] A) {
      int numRows = A.length;
      int numCols = A[0].length - 1;
      for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            int startIdx = 0;
            int endIdx = numCols;
            while (startIdx <= endIdx) {
                  int temp = A[rowIdx][startIdx];
                  A[rowIdx][startIdx++] = A[rowIdx][endIdx] == 1 ? 0 : 1;
                  A[rowIdx][endIdx--] = temp == 1 ? 0 : 1;
            }
      }
      return A;
  }
}