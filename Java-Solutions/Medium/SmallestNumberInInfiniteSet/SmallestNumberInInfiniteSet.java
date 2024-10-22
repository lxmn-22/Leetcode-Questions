/*
You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive 
integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not 
already in the infinite set.

Example 1:
Input:
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]
 */
package Medium.SmallestNumberInInfiniteSet;

class SmallestNumberInInfiniteSet {

    private final PriorityQueue<Integer> pq;
    private int current;

    public SmallestInfiniteSet() {
        this.pq = new PriorityQueue<>();
        this.current = 1;
    }

    public int popSmallest() {
        int result = current;
        if (!pq.isEmpty() && pq.peek() < current) {
            result = pq.poll();
        } else {
            current++;
        }
        while (!pq.isEmpty() && pq.peek() == result) {
            pq.poll();
        }
        return result;
    }

    public void addBack(int num) {
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */