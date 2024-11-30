/*
PROBLEM: 2097: Valid Arrangement of Pairs

You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.

Return any valid arrangement of pairs.

Note: The inputs will be generated such that there exists a valid arrangement of pairs.

Example 1:
Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
Output: [[11,9],[9,4],[4,5],[5,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 9 == 9 = start1 
end1 = 4 == 4 = start2
end2 = 5 == 5 = start3

Example 2:
Input: pairs = [[1,3],[3,2],[2,1]]
Output: [[1,3],[3,2],[2,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 3 == 3 = start1
end1 = 2 == 2 = start2
The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.

Example 3:
Input: pairs = [[1,2],[1,3],[2,1]]
Output: [[1,2],[2,1],[1,3]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 2 == 2 = start1
end1 = 1 == 1 = start2
*/
function validArrangement(pairs: number[][]): number[][] {
    const adjacencyList = new Map<number, number[]>();
    const inOutDegree = new Map<number, number>();
        
    // Build graph and count in/out degrees
    for (const pair of pairs) {
        if (!adjacencyList.has(pair[0])) {
            adjacencyList.set(pair[0], []);
        }
        adjacencyList.get(pair[0])!.push(pair[1]);
        inOutDegree.set(pair[0], (inOutDegree.get(pair[0]) || 0) + 1);
        inOutDegree.set(pair[1], (inOutDegree.get(pair[1]) || 0) - 1);
    }
        
    // Find starting node
    let startNode = pairs[0][0];
    for (const [node, degree] of inOutDegree.entries()) {
        if (degree === 1) {
            startNode = node;
            break;
        }
    }
        
    const path: number[] = [];
    const nodeStack: number[] = [startNode];
        
    while (nodeStack.length > 0) {
        const neighbors = adjacencyList.get(nodeStack[nodeStack.length - 1]) || [];
        if (neighbors.length === 0) {
            path.push(nodeStack.pop()!);
        } else {
            const nextNode = neighbors.pop()!;
            nodeStack.push(nextNode);
        }
    }
        
    const arrangement: number[][] = [];
    const pathSize = path.length;
        
    for (let i = pathSize - 1; i > 0; --i) {
        arrangement.push([path[i], path[i-1]]);
    }
    return arrangement;
}