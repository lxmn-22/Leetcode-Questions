/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of 
bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of 
them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30
 */
class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for (int pile : piles) {
            end = Math.max(end, pile);
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(piles, mid, h)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
  
    private static boolean isPossible(int[] piles, int k, int h) {
        int numOfHours = 0;
        for (int pile : piles) {
            numOfHours += Math.ceil((double) pile / k);
        }
        return numOfHours <= h;
    }
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println("Koko Eating Bananas: "+minEatingSpeed(piles, h));
    }
}