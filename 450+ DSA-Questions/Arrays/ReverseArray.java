/*
PROBLEM: Array Reverse

Given an array arr[], the task is to reverse the array. Reversing an array means rearranging
the elements such that the first element becomes the last, the second element becomes second
last and so on.

Examples1:
Input: arr[] = {1, 4, 3, 2, 6, 5}
Output: {5, 6, 2, 3, 4, 1}
Explanation: The first element 1 moves to last position, the second element 4 moves to
second-last and so on.

Examples2:
Input: arr[] = {4, 5, 1, 2}
Output: {2, 1, 5, 4}
Explanation: The first element 4 moves to last position, the second element 5 moves to
second last and so on.
*/
public class ReverseArray {
    /*
     * // BRUTE-FORCE: function to reverse an array.
     * public static void reverseArray(int[] arr, int n) {
     * int[] temp = new int[n];
     * 
     * // "temp" will store all the reversed elements.
     * for (int i = 0; i < n; i++) {
     * temp[i] = arr[n - i - 1];
     * }
     * // reversed element assigning back to "arr".
     * for (int i = 0; i < n; i++) {
     * arr[i] = temp[i];
     * }
     * }
     */

    // OPTIMAL-SOLUTION: function to reverse an array.
    public static void reverseArray(int[] arr, int n) {

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2, 6, 5 };
        int n = arr.length;

        System.out.print("Array before reversal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        reverseArray(arr, n);

        System.out.print("Array after reversal: ");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
