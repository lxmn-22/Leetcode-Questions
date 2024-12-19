/*
PROBLEM: 769: Max Chunks To Make Sorted

You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.

Example 1:
Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

Example 2:
Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
*/
function maxChunksToSorted(arr: number[]): number {
    const waiting = new Set();
    const provide = new Set();
    let i = 0;
    let chunk = 0;

    while (i < arr.length) {
        waiting.add(i);
        provide.add(arr[i]);

        if (provide.has(i)) {
            provide.delete(i);
            waiting.delete(i);
        }

        if (waiting.has(arr[i]) && provide.has(arr[i])) {
            waiting.delete(arr[i]);
            provide.delete(arr[i]);
        }
        if (waiting.size === 0 && provide.size === 0) {
            chunk++;
        }
        i++;
    }
    return chunk;
}