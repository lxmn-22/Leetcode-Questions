/*
You are playing a video game where you are defending your city from a group of n monsters. 
You are given a 0-indexed integer array dist of size n, 
where dist[i] is the initial distance in kilometers of the ith monster from the city.

The monsters walk toward the city at a constant speed. 
The speed of each monster is given to you in an integer array speed of size n, 
where speed[i] is the speed of the ith monster in kilometers per minute.

You have a weapon that, once fully charged, can eliminate a single monster. 
However, the weapon takes one minute to charge. The weapon is fully charged at the very start.

You lose when any monster reaches your city. 
If a monster reaches the city at the exact moment the weapon is fully charged, it counts as a loss, 
and the game ends before you can use your weapon.

Return the maximum number of monsters that you can eliminate before you lose, 
or n if you can eliminate all the monsters before they reach the city.

Example 1:
Input: dist = [1,3,4], speed = [1,1,1]
Output: 3
*/
import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {
    public static int eliminateMaximum(int[] dist, int[] speed) {
        final int n = dist.length;
        int[] arrivalTime = new int[n];

        for (int i = 0; i < n; ++i) {
            arrivalTime[i] = (dist[i] - 1) / speed[i];
        }
        Arrays.sort(arrivalTime);

        for (int i = 0; i < n; ++i) {
            if (i > arrivalTime[i]) {
                return i;
            }    
        }   
        return n;
    }
    public static void main(String[] args) {
        int[] dist = {1,3,4};
        int[] speed = {1,1,1};
        System.out.println("Eliminate Maximum Number of Monsters: "+eliminateMaximum(dist, speed));
    }
}