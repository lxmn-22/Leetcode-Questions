/*
PROBLEM: 773: Sliding Puzzle

On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.

Example 1:
Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.

Example 2:
Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.

Example 3:
Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
*/
function slidingPuzzle(board: number[][]): number {
    const target = '123450';
    const initial = board.flat().join('');

    if(initial === target) {
        return 0;
    }

    const moves = [
        [1,3],      // position 0
        [0,2,4],    // position 1
        [1,5],      // position 2
        [0,4],      // position 3
        [1,3,5],    // position 4
        [2,4]       // position 5
    ];
    const queue: [string, number][] = [[initial, 0]];
    const seen = new Set([initial]);

    while(queue.length > 0) {
        const [current, steps] = queue.shift()!;
        const zeroPosition = current.indexOf('0');

        for(const nextPosition of moves[zeroPosition]) {
            const nextState = swap(current, zeroPosition, nextPosition);

            if(nextState === target) {
                return steps + 1;
            }
            if(!seen.has(nextState)) {
                seen.add(nextState);
                queue.push([nextState, steps + 1]);
            }
        }
    }
    return -1;
};

function swap(str: string, i: number, j: number): string {
    const arr = str.split('');
    [arr[i], arr[j]] = [arr[j], arr[i]];

    return arr.join('');
}