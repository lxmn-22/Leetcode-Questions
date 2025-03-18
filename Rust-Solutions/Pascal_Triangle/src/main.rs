/*Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1] */



fn get_row(row_index: i32) -> Vec<i32> {
    let mut prev_cell: Vec<i32> = vec![1];

    for _ in 0..row_index {
        let next_length = prev_cell.len() + 1;
        let mut curr_cell = vec![0; next_length];
        for j in 0..next_length {
            if j == 0 || j == next_length - 1 {
                curr_cell[j] = 1;
            } else {
                curr_cell[j] = prev_cell[j] + prev_cell[j - 1];
            }
        }
        prev_cell = curr_cell;
    }
    prev_cell
}

fn main() {
    let row = 5;
    println("{}", get_row(row));
}