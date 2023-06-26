
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int n = costs.length;
        if (2 * candidates > n - k || n == k) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int left = 0;
        int right = n - 1;
        while (k-- > 0) {
            while (pq1.size() < candidates) {
                pq1.add(costs[left++]);
            }
            while (pq2.size() < candidates) {
                pq2.add(costs[right--]);
            }
            if (pq1.peek() <= pq2.peek()) {
                res += pq1.poll();
            } else {
                res += pq2.poll();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
