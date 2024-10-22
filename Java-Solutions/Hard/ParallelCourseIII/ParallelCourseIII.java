/*
You are given an integer n, which indicates that there are n courses labeled from 1 to n. 
You are also given a 2D integer array relations where relations[j] = [prevCoursej, 
nextCoursej] denotes that course prevCoursej has to be completed before course nextCoursej 
(prerequisite relationship). Furthermore, you are given a 0-indexed integer array time where time[i] 
denotes how many months it takes to complete the (i+1)th course.

You must find the minimum number of months needed to complete all the courses following these rules:

You may start taking a course at any time if the prerequisites are met.
Any number of courses can be taken at the same time.
Return the minimum number of months needed to complete all the courses.

Note: The test cases are generated such that it is possible to complete every course 
(i.e., the graph is a directed acyclic graph).
*/
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class ParallelCourseIII {
    public static int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] graph = new List[n];
        int[] inDegree = new int[n];
        int[] dist = time.clone();

        for (int i = 0; i < n; ++i)
        graph[i] = new ArrayList<>();

        // Build graph.
        for (int[] r : relations) {
            final int u = r[0] - 1;
            final int v = r[1] - 1;
            graph[u].add(v);
            ++inDegree[v];
        }

        // Topology
        Queue<Integer> q = IntStream.range(0, n)
                           .filter(i -> inDegree[i] == 0)
                           .boxed()
                           .collect(Collectors.toCollection(ArrayDeque::new));

        while (!q.isEmpty()) {
            final int u = q.poll();
            for (final int v : graph[u]) {
                dist[v] = Math.max(dist[v], dist[u] + time[v]);
                if (--inDegree[v] == 0)
                    q.offer(v);
            }
        }
        return Arrays.stream(dist).max().getAsInt();
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] relations = {{1,3},{2,3}};
        int[] time = {3,2,5};
        System.out.println("Parallel Course III: "+minimumTime(n, relations, time));
    }
}
