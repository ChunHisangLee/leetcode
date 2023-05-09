//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Deque<Integer> dq;
    Deque<Integer> min;

    public MinStack() {
        dq = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int val) {
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
        dq.push(val);
    }

    public void pop() {
        if (dq.peek().equals(min.peek())) {
            min.pop();
        }
        dq.pop();
    }

    public int top() {
        return dq.peek();
    }

    public int getMin() {
        return min.peek();
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
