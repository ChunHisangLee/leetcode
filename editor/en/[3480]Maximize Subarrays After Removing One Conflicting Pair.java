
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        final int m = conflictingPairs.length;
        final int INF = n + 1;

        List<int[]>[] byLeft = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            byLeft[i] = new ArrayList<>();
        }

        for (int id = 0; id < m; ++id) {
            int a = conflictingPairs[id][0];
            int b = conflictingPairs[id][1];
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            byLeft[a].add(new int[]{b, id});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        long base = 0L;
        long[] gain = new long[m];

        for (int l = n; l >= 1; --l) {
            for (int[] pair : byLeft[l]) {
                minHeap.offer(pair);
            }

            int minB = minHeap.isEmpty() ? INF : minHeap.peek()[0];
            base += (long) (minB - l);

            if (!minHeap.isEmpty()) {
                int[] top = minHeap.poll();
                int second = minHeap.isEmpty() ? INF : minHeap.peek()[0];
                gain[top[1]] += (long) (second - top[0]);
                minHeap.offer(top);
            }
        }

        long best = 0L;
        for (long g : gain) {
            best = Math.max(best, g);
        }
        return base + best;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
