/*
 * You are given a binary string s that contains at least one '1'.
 * 
 * You have to rearrange the bits in such a way that the resulting binary number
 * is the maximum odd binary number that can be created from this combination.
 * 
 * Return a string representing the maximum odd binary number that can be
 * created from the given combination.
 * 
 * Note that the resulting string can have leading zeros.
 *
 * Example 1:
 * Input: s = "010"
 * Output: "001"
 * Explanation: Because there is just one '1', it must be in the last position.
 * So the answer is "001".
 * 
 * Example 2:
 * Input: s = "0101"
 * Output: "1001"
 * Explanation: One of the '1's must be in the last position. The maximum number
 * that can be made with the remaining digits is "100". So the answer is "1001".
 */
class MaximumOddBinaryNumber {
    public static String maximumOddBinaryNumber(String s) {
        // count1, count0 are count number of 1's and 0's.
        int count1 = 0, count0 = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count1++;
            } else if (ch == '0') {
                count0++;
            }
        }
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < count1 - 1; i++) {
            answer.append('1');
        }

        for (int i = 0; i < count0; i++) {
            answer.append('0');
        }

        answer.append("1");

        return answer.toString();
    }
}