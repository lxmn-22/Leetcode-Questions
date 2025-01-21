public class PalindromeString {
    // BRUTE-FORCE: function to check palindrome string.
    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        // converting string to lowercase, removing non-alpha-numeric characters.
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // not a palindrome.
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // String s = "racecar";
        String s = "Racecar";

        System.out.print("Is Palindrome: " + isPalindrome(s));
        System.out.println();
    }
}
