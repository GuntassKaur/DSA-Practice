/*
    LeetCode 155 - Min Stack

    Problem:
    Design a stack that supports push, pop, top, and retrieving the minimum
    element in constant time O(1).

    Approach:
    We use TWO stacks:
    1. mainStack -> stores all values
    2. minStack  -> stores the minimum value at each level

    Key Idea:
    - Whenever we push a value, we also push the minimum value so far into minStack.
    - The top of minStack will always give the current minimum element.

    Operations:
    push(val)  -> Push val into mainStack and min(val, currentMin) into minStack
    pop()      -> Pop from both stacks
    top()      -> Return top of mainStack
    getMin()   -> Return top of minStack

    Time Complexity:
    push   -> O(1)
    pop    -> O(1)
    top    -> O(1)
    getMin -> O(1)

    Space Complexity:
    O(n) due to extra minStack

*/

import java.util.Stack;

class MinStack {

    // Stack to store all values
    private Stack<Integer> mainStack;

    // Stack to store minimum values
    private Stack<Integer> minStack;

    // Constructor
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element onto stack
    public void push(int val) {
        mainStack.push(val);

        // If minStack is empty, push value directly
        if (minStack.isEmpty()) {
            minStack.push(val);
        }
        // Otherwise, push the minimum till now
        else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    // Remove top element
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    // Get top element
    public int top() {
        return mainStack.peek();
    }

    // Retrieve minimum element
    public int getMin() {
        return minStack.peek();
    }
}
