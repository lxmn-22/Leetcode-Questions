/* PROBLEM:
There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1. 
The edges of the graph are initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti]
meaning that there is an edge from fromi to toi with the cost edgeCosti.

Implement the Graph class:
Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost]. 
It is guaranteed that there is no edge between the two nodes before adding this one.
int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2. 
If no path exists, return -1. The cost of a path is the sum of the costs of the edges in the path.
 */

class DesignGraphWithShortestPathCalculator {
    private static final Map<Integer, List<Connection>> graph;

    public Graph(int n, int[][] edges) {
        this.graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Connection(edge[1], edge[2]));
        }
    }

    public static void addEdge(int[] edge) {
        graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Connection(edge[1], edge[2]));
    }

    public static int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{node1, 0});
        Set<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            int node = removed[0];
            if (node == node2) {
                return removed[1];
            }
            if (graph.containsKey(node) && seen.add(node)) {
                for (Connection connection : graph.getOrDefault(removed[0], new ArrayList<>())) {
                    queue.add(new int[]{connection.node, removed[1] + connection.cost});
                }
            }
        }
        return -1;
    }

    private static record Connection(int node, int cost) { }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */