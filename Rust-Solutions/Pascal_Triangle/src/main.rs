pub fn get_row(row_index: i32) -> Vec<Vec<i32>> {
    let mut prev_cell: Vec<Vec<i32>> = vec![vec![1]];
    let mut count = 1;

    for _ in 1..row_index {
        let next_length = prev_cell[count - 1].len() + 1;
        let mut curr_cell = vec![0; next_length];
        for j in 0..next_length {
            if j == 0 || j == next_length - 1 {
                curr_cell[j] = 1;
            } else {
                curr_cell[j] = prev_cell[count - 1][j] + prev_cell[count - 1][j - 1];
            }
        }
        prev_cell.push(curr_cell);
        count += 1;
    }
    prev_cell
}

fn main() {
    let row_index = 5;
    println!("The elemnts at index {row_index}, is: {:?}", get_row(row_index))
}