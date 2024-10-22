/*
Given an array of integers arr, return true if the number of occurrences of each value in the array is 
unique or false otherwise.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have 
the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false
*/
import java.util.*;

public class UniqueNumberOfOccurences {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println("Unique Number of Occurences: "+uniqueOccurrences(arr));
    }
}