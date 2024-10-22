package Medium.DividePlayersIntoTeamsOfEqualSkills;

import java.util.*;

/*
 * You are given a positive integer array skill of even length n where skill[i]
 * denotes the skill of the ith player. Divide the players into n / 2 teams of
 * size 2 such that the total skill of each team is equal.
 * 
 * The chemistry of a team is equal to the product of the skills of the players
 * on that team.
 * 
 * Return the sum of the chemistry of all the teams, or return -1 if there is no
 * way to divide the players into teams such that the total skill of each team
 * is equal.
 * 
 * Example 1:
 * Input: skill = [3,2,5,1,3,4]
 * Output: 22
 * Explanation:
 * Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where
 * each team has a total skill of 6.
 * The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 +
 * 9 = 22.
 * 
 * Example 2:
 * Input: skill = [3,4]
 * Output: 12
 * Explanation:
 * The two players form a team with a total skill of 7.
 * The chemistry of the team is 3 * 4 = 12.
 * 
 * Example 3:
 * Input: skill = [1,1,2,3]
 * Output: -1
 * Explanation:
 * There is no way to divide the players into teams such that the total skill of
 * each team is equal.
 */
class DividePlayersIntoTeamsOfEqualSkills {
    public long dividePlayers(int[] skill) {
        // sorting the skilled array.
        Arrays.sort(skill);

        int n = skill.length;
        // Required sum for each pair.
        int totalSkill = skill[0] + skill[n - 1];
        long chemistrySum = 0;

        // Pair players using two pointers.
        for (int i = 0; i < n / 2; i++) {
            // check if the sum of current pair matches the required totalSkill.
            if (skill[i] + skill[n - i - 1] != totalSkill) {
                // invalid configuration, return -1.
                return -1;
            }
            // calculate the chemistry(product of pair) & add it to the sum.
            chemistrySum += (long) skill[i] * skill[n - i - 1];
        }
        // Return total chemistry.
        return chemistrySum;
    }
}