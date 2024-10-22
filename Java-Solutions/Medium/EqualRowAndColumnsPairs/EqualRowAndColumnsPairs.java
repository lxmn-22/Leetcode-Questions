/*
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) 
such that row ri and column cj are equal.
A row and column pair is considered equal if they contain the same elements in the 
same order (i.e., an equal array).
 */
import java.util.*;

public class EqualRowAndColumnsPairs {
    public static int equalPairs(int[][] grid) {
        Map<String, Integer> rowMap = new HashMap<>();
        for (int[] value : grid) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                sb.append(value[j]).append("|");
            }
            String key = sb.toString();
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < grid[0].length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : grid) {
                sb.append(ints[i]).append("|");
            }
            String key = sb.toString();
            count += rowMap.getOrDefault(key, 0);
        }
        return count;
    }
}