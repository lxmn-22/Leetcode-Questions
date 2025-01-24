/*
PROBLEM: 802: Find Eventual Safe States

There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array
 graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads 
to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

Example 1:
Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.

Example 2:
Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
*/
function eventualSafeNodes(graph: number[][]): number[] {
    const result: number[] = [];
    const safeNodes = new Set<number>();
    const n = graph.length;

    let hasUpdate = true;

    while (hasUpdate) {
        hasUpdate = false;

        for (let i = 0; i < n; i++) {
            if (safeNodes.has(i)) {
                continue;
            }

            const adjacentNodes = graph[i];
            if (adjacentNodes.length === 0) {
                safeNodes.add(i);
                hasUpdate = true;
            } else {
                let allSafeNode = true;

                for (const adjacentNode of adjacentNodes) {
                    if (!safeNodes.has(adjacentNode)) {
                        allSafeNode = false;
                    }
                }

                if (allSafeNode) {
                    safeNodes.add(i);
                    hasUpdate = true;
                }
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (safeNodes.has(i)) {
            result.push(i);
        }
    }
    return result;
}
