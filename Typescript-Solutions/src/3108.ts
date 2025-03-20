/*
PROBLEM: 3108: Minimum Cost Walk in Weighted Graph

There is an undirected weighted graph with n vertices labeled from 0 to n - 1.

You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.

A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it. It's important to note that a walk may visit the same edge or vertex more than once.

The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.

You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk, the answer is -1.

Return the array answer, where answer[i] denotes the minimum cost of a walk for query i.

Example 1:
Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]]
Output: [1,-1]

Explanation:
To achieve the cost of 1 in the first query, we need to move on the following edges: 0->1 (weight 7), 1->2 (weight 1), 2->1 (weight 1), 1->3 (weight 7).
In the second query, there is no walk between nodes 3 and 4, so the answer is -1.

Example 2:
Input: n = 3, edges = [[0,2,7],[0,1,15],[1,2,6],[1,2,1]], query = [[1,2]]
Output: [0]

Explanation:
To achieve the cost of 0 in the first query, we need to move on the following edges: 1->2 (weight 1), 2->1 (weight 6), 1->2 (weight 1).
*/
class DSU {
	parent: number[];
	depth: number[];

	constructor(n: number) {
		this.parent = new Array(n).fill(-1);
		this.depth = new Array(n).fill(0);
	}

	find(node: number): number {
		if (this.parent[node] === -1) return node;
		return (this.parent[node] = this.find(this.parent[node])); // Path compression
	}

	union(node1: number, node2: number): void {
		let root1 = this.find(node1);
		let root2 = this.find(node2);

		if (root1 === root2) return;

		// Union by depth
		if (this.depth[root1] < this.depth[root2])
			[root1, root2] = [root2, root1];

		this.parent[root2] = root1;
		if (this.depth[root1] === this.depth[root2]) this.depth[root1]++;
	}
}

function minimumCost(
	n: number,
	edges: number[][],
	queries: number[][]
): number[] {
	const dsu = new DSU(n);
	const componentCost = new Array<number>(n).fill(~0); // Equivalent to -1 in unsigned representation

	// Build connected components
	for (const [u, v] of edges) {
		dsu.union(u, v);
	}

	// Compute the AND-weight for each component
	for (const [u, v, w] of edges) {
		const root = dsu.find(u);
		componentCost[root] &= w;
	}

	// Answer queries
	return queries.map(([s, t]) =>
		dsu.find(s) === dsu.find(t) ? componentCost[dsu.find(s)] : -1
	);
}
