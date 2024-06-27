//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);
        int n = profits.length;

        for (int i = 0; i < n; i++) {
            if (capital[i] <= w) {
                maxProfitHeap.offer(profits[i]);
            } else {
                minCapitalHeap.offer(new int[]{capital[i], profits[i]});
            }
        }

        for (int i = 0; i < k; i++) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            w += maxProfitHeap.poll();
        }

        return w;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
