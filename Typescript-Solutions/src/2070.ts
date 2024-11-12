/*
 * PROBLEM: 2070: Most Beautiful Item For Each Query
 * 
 * You are given a 2D integer array items where items[i] = [pricei, beautyi]
 * denotes the price and beauty of an item respectively.
 * 
 * You are also given a 0-indexed integer array queries. For each queries[j],
 * you want to determine the maximum beauty of an item whose price is less than
 * or equal to queries[j]. If no such item exists, then the answer to this query
 * is 0.
 * 
 * Return an array answer of the same length as queries where answer[j] is the
 * answer to the jth query.
 *
 * Example 1:
 * Input: items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
 * Output: [2,4,5,5,6,6]
 * Explanation:
 * - For queries[0]=1, [1,2] is the only item which has price <= 1. Hence, the
 * answer for this query is 2.
 * - For queries[1]=2, the items which can be considered are [1,2] and [2,4].
 * The maximum beauty among them is 4.
 * - For queries[2]=3 and queries[3]=4, the items which can be considered are
 * [1,2], [3,2], [2,4], and [3,5].
 * The maximum beauty among them is 5.
 * - For queries[4]=5 and queries[5]=6, all items can be considered.
 * Hence, the answer for them is the maximum beauty of all items, i.e., 6.
 * 
 * Example 2:
 * Input: items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
 * Output: [4]
 * Explanation:
 * The price of every item is equal to 1, so we choose the item with the maximum
 * beauty 4.
 * Note that multiple items can have the same price and/or beauty.
 * 
 * Example 3:
 * Input: items = [[10,1000]], queries = [5]
 * Output: [0]
 * Explanation:
 * No item has a price less than or equal to 5, so no item can be chosen.
 * Hence, the answer to the query is 0.
 */
function maximumBeauty(items: number[][], queries: number[]): number[] {
    // Sort by prices ASC
    items.sort(([p1], [p2]) => p1 - p2);

    // Track max beauty from [0, i] for 0 <= i < N
    for (let i = 1; i < items.length; ++i) {
        items[i][1] = Math.max(items[i-1][1], items[i][1]);
    }

    // Find the max beauty with a price less than 
    // or equal to a query price for each query
    const M = queries.length;
    const answer: number[] = new Array(M);
    for (let i = 0; i < M; ++i) {
        const j = binarySearch(items, 0, queries[i] + 1);
        answer[i] = (j > 0) ? items[j-1][1] : 0;
    }

    return answer;
};

function binarySearch(items: number[][], idx: number, target: number, min = 0, max = items.length): number {
    while (min < max) {
        const mid = min + ((max - min) >> 1);
        if (items[mid][idx] < target) {
            min = mid + 1;
        } else {
            max = mid;
        }
    }
    return min;
}