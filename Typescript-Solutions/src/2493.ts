/*
PROBLEM: 2493: Divide Nodes Into the Maximum Number of Groups

You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.

Divide the nodes of the graph into m groups (1-indexed) such that:

Each node in the graph belongs to exactly one group.
For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.

Example 1:
Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
Output: 4
Explanation: As shown in the image we:
- Add node 5 to the first group.
- Add node 1 to the second group.
- Add nodes 2 and 4 to the third group.
- Add nodes 3 and 6 to the fourth group.
We can see that every edge is satisfied.
It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.

Example 2:
Input: n = 3, edges = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: If we add node 1 to the first group, node 2 to the second group, and node 3 to the third group to satisfy the first two edges, we can see that the third edge will not be satisfied.
It can be shown that no grouping is possible.
*/
function magnificentSets(n: number, edges: number[][]): number {
	const adj = Array.from({ length: n }, () => []);

	for (const [u, v] of edges) {
		adj[u - 1].push(v - 1), adj[v - 1].push(u - 1);
	}

	const vis = Array(n).fill(false);

	const bfsMaxDepth = (start: number): number => {
		const dist = Array(n).fill(-1);
		dist[start] = 0;
		const q = [start];
		let maxDepth = 1;

		while (q.length) {
			const node = q.shift()!;

			for (const neighbor of adj[node]) {
				if (dist[neighbor] === -1) {
					dist[neighbor] = dist[node] + 1;
					maxDepth = Math.max(maxDepth, dist[neighbor] + 1);
					q.push(neighbor);
				} else if (Math.abs(dist[neighbor] - dist[node]) !== 1) {
					return -1;
				}
			}
		}
		return maxDepth;
	};

	let totalGroups = 0;

	const processComponent = (start: number): number => {
		const q = [start];
		const dist = Array(n).fill(-1);
		dist[start] = 0;
		vis[start] = true;
		let nodes = [start];

		while (q.length) {
			const node = q.shift()!;
			for (const neighbor of adj[node]) {
				if (dist[neighbor] === -1) {
					dist[neighbor] = dist[node] + 1;
					q.push(neighbor);
					nodes.push(neighbor);
					vis[neighbor] = true;
				} else if (dist[neighbor] === dist[node]) {
					return -1;
				}
			}
		}

		let maxGroups = 1;

		for (const node of nodes) {
			const depth = bfsMaxDepth(node);
			if (depth === -1) return -1;
			maxGroups = Math.max(maxGroups, depth);
		}
		return maxGroups;
	};

	for (let i = 0; i < n; i++) {
		if (!vis[i]) {
			const groups = processComponent(i);
			if (groups === -1) return -1;
			totalGroups += groups;
		}
	}
	return totalGroups;
}
