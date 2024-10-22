/*
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements 
may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:
NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
Your code will be tested with the following pseudocode:
initialize iterator with nestedList
res = []
while iterator.hasNext() append iterator.next() to the end of res return res
If res matches the expected flattened list, then your code will be judged as correct.

Example 1:
Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Input: nestedList = [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1,4,6].
 */
public class FlatternNestedListIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;
  
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            this.stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        int value = this.stack.pop().getInteger();
        return value;
    }

    @Override
    public boolean hasNext() {
        while (!this.stack.isEmpty() && !this.stack.peek().isInteger()) {
            List<NestedInteger> ni = this.stack.pop().getList();
            for (int i = ni.size() - 1; i >= 0; i--) {
                this.stack.push(ni.get(i));
            }
        }
        return !this.stack.isEmpty();
    }
}