/*Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, 
return the number of negative numbers in grid.*/

class CountNegNumInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            int index = findFirstNonNegativeIndex(row);
            count += index == -1 ? 0 : (row.length - index);
        }
        return count;
    }
    
    static int findFirstNonNegativeIndex(int[] row) {
        int start = 0;
        int end = row.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (row[mid] < 0) {
                index = mid;
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }
        return index;
    }
}
