
fn plus_one(mut digits: Vec<i32>) -> Vec<i32> {
        for i in (0..digits.len()).rev() {
        if digits[i] < 9 {
            digits[i] += 1;
            return digits;
        }
        digits[i] = 0;
    }

    let mut result = vec![1];
    result.extend(digits);
    result
}



fn main() {
    let test = vec![1,2,3];
    let result = plus_one(test);
    println!("{:?}", result);
}
