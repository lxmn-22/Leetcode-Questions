use std::collections::HashSet;

pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
    let mut set = HashSet::new();
    let k = k as usize;

    for i in 0..nums.len() {
        if set.contains(&nums[i]) {
            return true;
        }

        set.insert(nums[i]);

        if i >= k {
            set.remove(&nums[i - k]);
        }
    }
    false
}

fn main() {
    let k = 3;
    let nums = vec![1,2,3,1];
    println!("{}", contains_nearby_duplicate(nums, k))
}