//leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
