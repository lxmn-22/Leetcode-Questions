pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {
    let mut result: Vec<i32> = vec![];

    for i in 0..nums.len() - 1 {
        if nums[i] != val {
            result.push(nums[i]);
        }
    }
    result.sort();
    result.len() as i32
}

fn main() {
    let result = remove_element(&mut vec![0, 1, 2, 2, 3, 0, 4, 2], 2);
    println!("{}", result);
}
