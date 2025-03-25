fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
    let len = nums.len() as i32;
    if !nums.is_empty() {
        for i in 0..nums.len() - 1 {
             if nums[i] >= target {
                return i as i32;
            } else if target > nums[i] && i as i32 == len {
                return len
            }
        }
    }
    0
}

fn main() {
    let values = vec![1, 3, 5, 6];
    let target = 4;

    println!("The output is: {}", search_insert(values, target))
}