/* Given an array arr of integers, check if there exist two indices i and j such that :
i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
*/
import java.util.*;
class CheckIfNandItsDoubleExists {
      public static boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (Integer num : arr) {
                  if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                  return true;
                  }
            set.add(num);
            }
      return false;
    }
    public static void main(String[] args) {
      int[] arr = {12, 5, 22, 19, 5};
      System.out.println(checkIfExist(arr));
    }
}