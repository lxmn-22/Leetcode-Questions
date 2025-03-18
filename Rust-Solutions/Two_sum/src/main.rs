fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    for i in 0..nums.len() - 1 {
        for j in i + 1..nums.len() {
            if (target - nums[j]) == nums[i] {
                return vec![i as i32, j as i32];
            }
        }
    }
    vec![]
}

fn main() {
    let array = vec![2,7,11,15];
    let target = 9;
    let result = two_sum(array, target);

    println!("The index of target is {:?}", result)
}