
//leetcode submit region begin(Prohibit modification and deletion)
class MaxStack {
    Deque<int[]> stack;
    PriorityQueue<int[]> pq;
    Set<Integer> removed;
    int count = 0;

    public MaxStack() {
        stack = new ArrayDeque<>();
        pq = new PriorityQueue<>((a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
        removed = new HashSet<>();
    }

    public void push(int x) {
        int[] curr = new int[]{x, count};
        stack.push(curr);
        pq.add(curr);
        count++;
    }

    public int pop() {
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }

        int[] curr = stack.pop();
        removed.add(curr[1]);
        return curr[0];
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

        int[] curr = pq.poll();
        removed.add(curr[1]);
        return curr[0];
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
