/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]
*/
import java.util.*;
public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> copy = new ArrayList<>(lastRow);
            lastRow.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    lastRow.add(1);
                } 
                else {
                    lastRow.add(copy.get(j - 1) + copy.get(j));
                }
            }
        }
        return lastRow;
    }   
    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println("Pascal's Triangle: "+getRow(rowIndex));
    }
}