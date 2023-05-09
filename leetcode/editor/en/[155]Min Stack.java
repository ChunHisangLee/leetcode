//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Deque<Integer> dq;
    Deque<int[]> min;

    public MinStack() {
        dq = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int val) {
        dq.push(val);
        if (min.isEmpty() || val < min.peek()[0]) {
            min.push(new int[]{val, 1});
        } else if (val == min.peek()[0]) {
            min.peek()[1]++;
        }
    }

    public void pop() {
        if (dq.peek().equals(min.peek()[0])) {
            min.peek()[1]--;
        }
        if (min.peek()[1] == 0) {
            min.pop();
        }
        dq.pop();
    }

    public int top() {
        return dq.peek();
    }

    public int getMin() {
        return min.peek()[0];
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
