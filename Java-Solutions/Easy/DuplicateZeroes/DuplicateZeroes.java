/* 
Given a fixed-length integer array arr, duplicate each occurrence of zero, 
shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written. 
Do the above modifications to the input array in place and do not return anything.
Eg:
Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
*/
class DuplicateZeroes {
      public static void duplicateZeros(int[] arr) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                  count += arr[i] == 0 ? 1 : 0;
            }
            int idxOne = arr.length - 1;
            int idxTwo = arr.length + count - 1;
            while (idxOne != idxTwo) {
                  insertAtEnd(arr, idxOne, idxTwo--);
                  if (arr[idxOne] == 0) {
                        insertAtEnd(arr, idxOne, idxTwo--);
                  }
                  idxOne--;
            }
      }
      private static void insertAtEnd(int[] arr, int idxOne, int idxTwo) {
            if (idxTwo < arr.length) {
                  arr[idxTwo] = arr[idxOne];
            }
      }
      public static void main(String[] args) {
            int[] arr = {1,0,2,3,0,4,5,0};
            System.out.println(duplicateZeros(arr));
      }
}