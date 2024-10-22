/* 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);
 */

class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int row = 0;
        int n = s.length();
        int idx = 0;

        while (idx < n) {
            while (idx < n && row < numRows) {
                rows[row++].append(s.charAt(idx++));
            }
            row -= 2;
            while (idx < n && row >= 0) {
                rows[row--].append(s.charAt(idx++));
            }
            row += 2;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb.toString());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println("ZigZag Conversion: "+convert(s,numRows));
    }
}