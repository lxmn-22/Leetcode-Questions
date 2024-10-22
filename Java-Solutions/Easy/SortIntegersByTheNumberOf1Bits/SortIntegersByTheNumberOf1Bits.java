/*
You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's 
in their binary representation and in case of two or more integers have the same number of 1's you have to 
sort them in ascending order.

Return the array after sorting it.

Example 1:
Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
*/
import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits {
    public static int[] sortByBits(int[] arr) {
        Integer[] A = Arrays.stream(arr).boxed().toArray(Integer[] ::new);
        Arrays.sort(A, (a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a - b : Integer.bitCount(a) - Integer.bitCount(b));
        return Arrays.stream(A).mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println("Sort Integers By The Number Of 1 Bits: "+sortByBits(arr));
    }
}