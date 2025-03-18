fn is_palindrome(s: String) -> bool {
    let filtered: String = s
        .chars()
        .filter(|&s| s.is_alphanumeric())
        .map(|s| s.to_ascii_lowercase())
        .collect();

    filtered
        == s.chars()
            .filter(|&s| s.is_alphanumeric())
            .map(|s| s.to_ascii_lowercase())
            .rev()
            .collect::<String>()
}

fn main() {
    let s = "A man, a plan, a canal: Panama"
    let result = is_palindrome(s);
    println("Is s a valid palindrome: {}", result);
}
