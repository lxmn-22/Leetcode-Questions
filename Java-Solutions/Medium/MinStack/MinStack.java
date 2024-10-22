/*
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 * Example 1:
 * Input:
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top(); // return 0
 * minStack.getMin(); // return -2
 */
class MinStack {

    Stack<Integer> st;
    Stack<Integer> ms;

    public static MinStack() {
        st = new Stack<Integer>();
        ms = new Stack<Integer>();

    }

    public static void push(int val) {
        st.push(val);
        if (ms.empty() || val <= ms.peek()) {
            ms.push(val);
        }
    }

    public static void pop() {
        int a = st.pop();
        if (a == ms.peek()) {
            ms.pop();
        }
    }

    public static int top() {
        return st.peek();
    }

    public static int getMin() {
        if (ms.empty()) {
            return 0;
        } else {
            return ms.peek();
        }
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */