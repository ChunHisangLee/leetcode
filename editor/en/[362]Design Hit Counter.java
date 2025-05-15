
//leetcode submit region begin(Prohibit modification and deletion)
class HitCounter {
    private Queue<Integer> hits;
    private static final int WINDOW = 300;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!hits.isEmpty() && hits.peek() <= timestamp - WINDOW) {
            hits.poll();
        }

        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)
