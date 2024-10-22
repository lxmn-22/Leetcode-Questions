/* Given two non-negative integers num1 and num2 represented as strings, 
return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088" 
*/
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        int endIdx = m + n - 1;
        for (int i = m - 1; i >= 0; i--) {
            int resultIdx = endIdx;
            int carry = 0;
            for (int j = n - 1; j >= 0; j--) {
                int currValue = result[resultIdx] + carry + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                carry = currValue / 10;
                result[resultIdx--] = currValue % 10;
            }
            while (carry > 0) {
                result[resultIdx--] = carry % 10;
                carry /= 10;
            }
            endIdx--;
        }
        int idx = 0;
        while (idx < result.length && result[idx] == 0) {
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        System.out.println("Strings after multiplication: "+multiply(num1, num2));
    }
}