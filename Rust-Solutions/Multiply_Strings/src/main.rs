/*Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088" */

fn multiply_strings(num1: String, num2: String) -> String {
        if num1 == "0" || num2 == "0" {
        return "0".to_string();
    }

    let mut result = vec![0; num1.len() + num2.len()];
    let num1_bytes = num1.as_bytes();
    let num2_bytes = num2.as_bytes();

    for i in (0..num1.len()).rev() {
        for j in (0..num2.len()).rev() {
            let mul = (num1_bytes[i] - b'0') as usize * (num2_bytes[j] - b'0') as usize;
            let sum = mul + result[i + j + 1];

            result[i + j + 1] = sum % 10;
            result[i + j] += sum / 10;
        }
    }

    let mut result_str = String::new();
    let mut leading_zero = true;

    for &digit in &result {
        if digit != 0 || !leading_zero {
            leading_zero = false;
            result_str.push((digit as u8 + b'0') as char);
        }
    }

    result_str
}

fn main() {
    let s1 = "25".to_string();
    let s2 = "2".to_string();
    println!("The result is: {}", multiply_strings(s1, s2))
}