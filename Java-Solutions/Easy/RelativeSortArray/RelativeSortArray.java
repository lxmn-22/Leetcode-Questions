/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. 
Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

Example 2:
Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
*/
public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] frequency = new int[1001];
        for (int num : arr1) {
            frequency[num]++;
        }
        int[] result = new int[arr1.length];
        int idx = 0;
        for (int num : arr2) {
            while (frequency[num]-- > 0) {
                result[idx++] = num;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (frequency[i]-- > 0) {
                result[idx++] = i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
    int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
    int[] arr2 = {2,1,4,3,9,6};
    System.out.println("Relative Sorted Array: "+relativeSortArray(arr1, arr2));
    }
}