//leetcode submit region begin(Prohibit modification and deletion)
class RecentCounter {
    Deque<Integer> queue;
    final int CONSTANT = 3000;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - CONSTANT) {
            queue.poll();
        }

        queue.offer(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)
