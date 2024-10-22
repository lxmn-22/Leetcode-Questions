/*
 * You are given a string num representing a large integer. An integer is good
 * if it meets the
 * following conditions:
 * 
 * It is a substring of num with length 3.
 * It consists of only one unique digit.
 * Return the maximum good integer as a string or an empty string "" if no such
 * integer exists.
 * 
 * Note:
 * A substring is a contiguous sequence of characters within a string.
 * There may be leading zeroes in num or a good integer.
 * 
 * Example 1:
 * Input: num = "6777133339"
 * Output: "777"
 * Explanation: There are two distinct good integers: "777" and "333".
 * "777" is the largest, so we return "777".
 * 
 * Example 2:
 * Input: num = "2300019"
 * Output: "000"
 * Explanation: "000" is the only good integer.
 */
class LargestThreeSameDigitNumber {
    public static String largestGoodInteger(String num) {
        int largestIdx = -1;
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                if (largestIdx == -1
                        || num.substring(largestIdx, largestIdx + 3).compareTo(num.substring(i, i + 3)) < 0) {
                    largestIdx = i;
                }
            }
        }
        return largestIdx == -1 ? "" : num.substring(largestIdx, largestIdx + 3);
    }

    public static void main(String[] args) {
        String num = "2300019"
        System.out.println("Largest Good Integer: "+largestGoodInteger(num));
    }
}