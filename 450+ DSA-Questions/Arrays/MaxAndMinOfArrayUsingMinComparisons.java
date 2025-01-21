/*
 * PROBLEM: Maximum and minimum of an array using minimum number of comparisons
 * 
 * Given an array of size N. The task is to find the maximum and the minimum element of the array using the minimum number of comparisons.

Examples01:
Input: arr[] = {3, 5, 4, 1, 9}
Output: Minimum element is: 1
        Maximum element is: 9

Examples02:
Input: arr[] = {22, 14, 8, 17, 35, 3}
Output: Minimum element is: 3
        Maximum element is: 35
 */
public class MaxAndMinOfArrayUsingMinComparisons {

    // fetch the min element from the array.
    public static int setMin(int[] arr, int n) {
        // if length of "n" is 0.
        if (n == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // fetch the max element from the array.
    public static int setMax(int[] arr, int n) {
        // if length of an "n" is 0.
        if (n == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {};
        int n = arr.length;

        System.out.println("Minimum element: " + setMin(arr, n));
        System.out.println("Maximum element: " + setMax(arr, n));
    }
}
