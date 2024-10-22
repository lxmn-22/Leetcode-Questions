/*
 * You start with an initial power of power, an initial score of 0, and a bag of
 * tokens given as an integer array tokens, where each tokens[i] donates the
 * value of tokeni.
 * 
 * Your goal is to maximize the total score by strategically playing these
 * tokens. In one move, you can play an unplayed token in one of the two ways
 * (but not both for the same token):
 * 
 * Face-up: If your current power is at least tokens[i], you may play tokeni,
 * losing tokens[i] power and gaining 1 score.
 * Face-down: If your current score is at least 1, you may play tokeni, gaining
 * tokens[i] power and losing 1 score.
 * Return the maximum possible score you can achieve after playing any number of
 * tokens.
 * 
 * Example 1:
 * Input: tokens = [100], power = 50
 * Output: 0
 * Explanation: Since your score is 0 initially, you cannot play the token
 * face-down. You also cannot play it face-up since your power (50) is less than
 * tokens[0] (100).
 * 
 * Example 2:
 * Input: tokens = [200,100], power = 150
 * Output: 1
 * Explanation: Play token1 (100) face-up, reducing your power to 50 and
 * increasing your score to 1.
 * There is no need to play token0, since you cannot play it face-up to add to
 * your score. The maximum score achievable is 1.
 */
class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int s = 0;
        int maxi = 0;
        // two pointers.
        int l = 0;
        int r = tokens.length - 1;

        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l];
                s++;
                l++;
                maxi = Math.max(maxi, s);
            } else if (s > 0) {
                power += tokens[r];
                s--;
                r--;
            } else {
                break;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] tokens = { 100 };
        int power = 150;
        System.out.println("Bag of Tokens: " + bagOfTokensScore(tokens, power));

    }
}