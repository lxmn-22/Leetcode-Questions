/*
PROBLEM: 67: Add Binary

Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
*/
function addBinary(a: string, b: string): string {
    let largestLength = Math.max(a.length, b.length)
    let carry = 0;
    let output = ''
    let aLength = a.length - 1;
    let bLength = b.length - 1;

    while(aLength >= 0 || bLength >= 0) {
        let aInt = parseInt(a[aLength]) ? parseInt(a[aLength]) : 0
        let bInt = parseInt(b[bLength]) ? parseInt(b[bLength]) : 0

        let sum = aInt + bInt

        if(carry) {
            sum++
        }
        if(sum === 0) {
            output = '0' + output
            carry = 0
        } else if(sum === 1) {
            output = '1' + output
            carry = 0
        } else if(sum === 2) {
            output = '0' + output
            carry = 1
        } else {
            output = '1' + output
            carry = 1
        }
        aLength--;
        bLength--;
    }
    if(carry) {
        return '1' + output
    }
    return output
};