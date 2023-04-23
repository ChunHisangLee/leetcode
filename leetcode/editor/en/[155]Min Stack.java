//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Deque<Integer> dq;
    Deque<Integer> minDeque;

    public MinStack() {
        dq = new ArrayDeque<>();
        minDeque = new ArrayDeque<>();
    }

    public void push(int val) {
        dq.push(val);
        if (minDeque.isEmpty() || val <= minDeque.peek()) {
            minDeque.push(val);
        }
    }

    public void pop() {
        if (dq.peek().equals(minDeque.peek())) {
            minDeque.pop();
        }
        dq.pop();
    }

    public int top() {
        return dq.peek();
    }

    public int getMin() {
        return minDeque.peek();
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
//leetcode submit region end(Prohibit modification and deletion)
