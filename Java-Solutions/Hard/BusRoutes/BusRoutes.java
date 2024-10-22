/*
You are given an array routes representing bus routes where routes[i] is a bus 
route that the ith bus repeats forever.
For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence,
1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), 
and you want to go to the bus stop target. You can travel between bus stops by buses only.

Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

Example 1:
Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, 
then take the second bus to the bus stop 6.
*/
import java.util.*;

class BusRoutes {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, Set<Integer>> stopToBusMapping = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBusMapping.computeIfAbsent(stop, k -> new HashSet<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int route : stopToBusMapping.get(source)) {
            queue.add(route);
            visited.add(route);
        }
        int buses = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int removed = queue.remove();
                for (int stop : routes[removed]) {
                    if (stop == target) {
                        return buses;
                    }
                    for (int nextBus : stopToBusMapping.getOrDefault(stop, new HashSet<>())) {
                        if (!visited.contains(nextBus)) {
                            visited.add(nextBus);
                            queue.add(nextBus);
                        }
                    }
                }
            }
            buses++;
        }
        return -1;
    }
}