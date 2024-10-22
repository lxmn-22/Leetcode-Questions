/*
We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents 
its direction (positive meaning right, negative meaning left). Each asteroid moves 
at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, 
the smaller one will explode. If both are the same size, both will explode. 
Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
*/
package Medium.AsteroidCollision;

import java.util.*;

class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        while (idx < asteroids.length && asteroids[idx] < 0) {
            result.add(asteroids[idx++]);
        }
        while (idx < asteroids.length) {
            if (asteroids[idx] > 0) {
                result.add(asteroids[idx++]);
            } else {
                if (result.isEmpty() || result.get(result.size() - 1) < 0) {
                    result.add(asteroids[idx]);
                } else {
                    while (!result.isEmpty() && 
                           result.get(result.size() - 1) > 0 && 
                           result.get(result.size() - 1) < Math.abs(asteroids[idx])) {
                        result.remove(result.size() - 1);
                    }
                    if (!result.isEmpty() && result.get(result.size() - 1) > 0) {
                        if (result.get(result.size() - 1) == Math.abs(asteroids[idx])) {
                            result.remove(result.size() - 1);
                        } 
                    } else {
                        result.add(asteroids[idx]);
                    }
                }
                idx++;
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {
        int[] asteroid = {5,10,-5};
        System.out.println("Asteroid Collision: "+asteroidCollision(asteroid));
    }
}