/* Alice and Bob take turns playing a game, with Alice starting first.
Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
Choosing any x with 0 < x < n and n % x == 0.
Replacing the number n on the chalkboard with n - x.
Also, if a player cannot make a move, they lose the game.
Return true if and only if Alice wins the game, assuming both players play optimally.
 */
import java.util.*;

class DivisorGame {
      public static boolean divisorGame(int N) {
            boolean[] dp = new boolean[N + 1];
            dp[0] = false;
            dp[1] = false;
            for (int i = 2; i <= N; i++) {
                  for (int j = 1; j < i; j++) {
                        if (i % j == 0) {
                              if (dp[i - j] == false) {
                                    dp[i] = true;
                                    break;
                              }
                        }
                  }
            }
            return dp[N];
      }
      public static void main(String[] args) {
            int N = 3;
            System.out.println(divisorGame(N));
      }
}