/*
PROBLEM: 684: Redundant Connection

In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

Example 1:
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Example 2:
Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
*/
function findRedundantConnection(edges: number[][]): number[] {
	// Helper function to find the root of a node:
	function find(node: number): number {
		if (parent[node] !== node) {
			parent[node] = find(parent[node]);
		}
		return parent[node];
	}

	function union(node1: number, node2: number): boolean {
		const root1 = find(node1);
		const root2 = find(node2);

		if (root1 === root2) {
			return false;
		}
		parent[root2] = root1;

		return true;
	}

	const parent: number[] = [];

	for (let i = 0; i < edges.length + 1; i++) {
		parent[i] = i;
	}

	for (const [u, v] of edges) {
		if (!union(u, v)) {
			return [u, v];
		}
	}
	return [];
}
