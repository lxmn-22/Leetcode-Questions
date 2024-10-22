/*
You are given two positive integer arrays spells and potions, of length n and m respectively, 
where spells[i] represents the strength of the ith spell and potions[j] represents the strength 
of the jth potion.
You are also given an integer success. A spell and potion pair is considered successful if the 
product of their strengths is at least success.
Return an integer array pairs of length n where pairs[i] is the number of potions that will form a 
successful pair with the ith spell.

Example 1:
Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
Output: [4,0,3]
Explanation:
- 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
Thus, [4,0,3] is returned.

Example 2:
Input: spells = [3,1,2], potions = [8,5,8], success = 16
Output: [2,0,2]
 */
import java.util.*;

class SuccessfulPairsOfSpellsAndPotions {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            result[i] = findCountOfSuccessfulPotion(potions, success, (long) spells[i]);
        }
        return result;
    }
    
    private static int findCountOfSuccessfulPotion(int[] potions, long success, long spell) {
        int left = 0;
        int right = potions.length - 1;
        int minIdx = Integer.MAX_VALUE;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (potions[mid] * spell >= success) {
                minIdx = Math.min(minIdx, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minIdx == Integer.MAX_VALUE ? 0 : (potions.length - minIdx);
    }
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        long success = 7;
        System.out.println("Successful pairs of spells and potions: "+successfulPairs(spells, potions, success));
    }
}