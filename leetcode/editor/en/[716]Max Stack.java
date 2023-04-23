716
        Max Stack
        2022-12-20 14:19:15

//leetcode submit region begin(Prohibit modification and deletion)
class MaxStack {
    private Stack<int[]> stack;
    private Queue<int[]> pq;
    private Set<Integer> removed;
    private int count = 0;

    public MaxStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>((a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
        removed = new HashSet<>();
    }

    public void push(int x) {
        stack.add(new int[]{x, count});
        pq.add(new int[]{x, count});
        count++;
    }

    public int pop() {
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
        removed.add(stack.peek()[1]);
        return stack.pop()[0];
    }

    public int top() {
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
        return stack.peek()[0];
    }

    public int peekMax() {
        while (removed.contains(pq.peek()[1])) {
            pq.poll();
        }
        return pq.peek()[0];
    }

    public int popMax() {
        while (removed.contains(pq.peek()[1])) {
            pq.poll();
        }
        removed.add(pq.peek()[1]);
        return pq.poll()[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
//leetcode submit region end(Prohibit modification and deletion)
