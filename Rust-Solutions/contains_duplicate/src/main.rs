pub fn contains_duplicate(nums: Vec<i32>) -> bool {
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            if nums[i] == nums[j] {
                return true;
            }
        }
    }
    false
}

fn main() {
    let nums = vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    println!("{}", contains_duplicate(nums));
}