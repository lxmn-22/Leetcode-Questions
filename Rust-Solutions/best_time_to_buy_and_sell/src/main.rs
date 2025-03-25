fn highest_profit(prices: Vec<i32>) -> i32 {
    let mut temp_profit = 0;

    for i in 0..prices.len() {
        for j in i + 1..prices.len() {
            if (prices[j] - prices[i]) > temp_profit {
                temp_profit = prices[j] - prices[i]
            }
        }
    }
    temp_profit
}

fn main() {
    println!(
        "The highest profit is: {:?}",
        highest_profit(vec![7, 1, 5, 3, 6, 4])
    )
}
