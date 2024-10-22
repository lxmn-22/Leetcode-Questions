/*
 * Given an integer array arr, return true if there are three consecutive odd
 * numbers in the array. Otherwise, return false.
 * 
 * Example 1:
 * Input: arr = [2,6,4,1]
 * Output: false
 * Explanation: There are no three consecutive odds.
 * 
 * Example 2:
 * Input: arr = [1,2,34,3,4,5,7,23,12]
 * Output: true
 * Explanation: [5,7,23] are three consecutive odds.
 * 
 * Constraints:
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 */
class ThreeConsecutiveOdds {
    public static boolean threeConsecutiveOdds(int[] arr) {
        // Initialize count to keep track of consecutive odd numbers.
        int count = 0;

        // Iterate through each element in the array.
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is odd.
            if (arr[i] % 2 != 0) {
                // Increment the count if it's odd.
                count++;
                // If we have found three consecutive odds, return true.
                if (count == 3) {
                    return true;
                }
            } else {
                // If the element is even, reset the count to 0.
                count = 0;
            }
        }
        // If we finish the loop without finding three consecutive odds, return false.
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 4, 1 };
        System.out.println("Three consecutive odds: " + threeConsecutiveOdds(arr));
    }
}