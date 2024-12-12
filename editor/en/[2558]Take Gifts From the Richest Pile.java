
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        for (int gift : gifts) {
            maxHeap.offer((long) gift);
        }

        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) {
                break;
            }

            long currentMax = maxHeap.poll();
            long giftsLeft = (long) Math.sqrt(currentMax);
            maxHeap.offer(giftsLeft);
        }

        long totalGifts = 0;

        for (long gift : maxHeap) {
            totalGifts += gift;
        }

        return totalGifts;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
