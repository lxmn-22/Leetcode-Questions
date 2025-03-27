pub fn missing_number(mut nums: Vec<i32>) -> i32 {
    // [3,0,1], 2

    let mut count: i32 = 0;
    let len = nums.len();
    nums.sort();

    for i in 0..=nums.len() {
        if nums[i] != count {
            return count
        } else if i == len {
            return count + 1
        }
        count += 1;
    }
    0
}

fn main() {
    let nums = vec![9, 6, 4, 2, 3, 5, 7, 0, 1];
    println!("{}", missing_number(nums));
}
``