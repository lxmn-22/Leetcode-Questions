package Hard.NumberOfWaysToDivideAlongCorridor;

/*
 * Along a long library corridor, there is a line of seats and decorative
 * plants.
 * You are given a 0-indexed string corridor of length n consisting of letters
 * 'S' and 'P'
 * where each 'S' represents a seat and each 'P' represents a plant.
 * 
 * One room divider has already been installed to the left of index 0, and
 * another to the right
 * of index n - 1. Additional room dividers can be installed. For each position
 * between indices i - 1
 * and i (1 <= i <= n - 1), at most one divider can be installed.
 * 
 * Divide the corridor into non-overlapping sections, where each section has
 * exactly two seats with
 * any number of plants. There may be multiple ways to perform the division. Two
 * ways are different
 * if there is a position with a room divider installed in the first way but not
 * in the second way.
 * 
 * Return the number of ways to divide the corridor. Since the answer may be
 * very large, return it
 * modulo 109 + 7. If there is no way, return 0.
 * 
 * Example 1:
 * Input: corridor = "SSPPSPS"
 * Output: 3
 * Explanation: There are 3 different ways to divide the corridor.
 * The black bars in the above image indicate the two room dividers already
 * installed.
 * Note that in each of the ways, each section has exactly two seats.
 */
class NumberOfWaysToDivideAlongCorridor {
    public static int numberOfWays(String corridor) {
        final int kMod = 1_000_000_007;
        long ans = 1;
        int prevSeat = -1;
        int numSeats = 0;

        for (int i = 0; i < corridor.length(); ++i) {
            if (corridor.charAt(i) == 'S') {
                if (++numSeats > 2 && numSeats % 2 == 1) {
                    ans = ans * (i - prevSeat) % kMod;
                }
                prevSeat = i;
            }
        }
        return numSeats > 1 && numSeats % 2 == 0 ? (int) ans : 0;
    }

    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        System.out.println("Number of ways: " + numberOfWays(corridor));
    }
}