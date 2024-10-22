/*
 * Given an array of integers arr, find the sum of min(b), where b ranges over
 * every (contiguous) subarray of arr. Since the answer may be large, return the
 * answer modulo 109 + 7.
 *
 * Example 1:
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation:
 * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4],
 * [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Sum is 17.
 * 
 * Example 2:
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 */
class SumOfSubarrayMinimums {
    int n;
    int mod = 1000000007;

    public static int sumSubarrayMins(int[] arr) {
        n = arr.length;
        int[] prefixLeft = new int[n];
        int[] prefixRight = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int ind = stack.pop();
                prefixRight[ind] = i - ind;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int ind = stack.pop();
            prefixRight[ind] = n - ind;
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int ind = stack.pop();
                prefixLeft[ind] = ind - i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int ind = stack.pop();
            prefixLeft[ind] = ind + 1;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long add = (prefixLeft[i] * prefixRight[i]) % mod;
            add *= arr[i];
            add %= mod;
            sum += add;
            sum %= mod;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println("Sum of subarray minimums: " + sumSubarrayMins(arr));
    }
}