743
        Network Delay Time
        2023-02-10 22:35:11

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] arrs = new int[n + 1][n + 1];
        for (int[] arr : arrs) {
            Arrays.fill(arr, -1);
        }
        for (int[] time : times) {
            arrs[time[0]][time[1]] = time[2];
        }
        int[] dist = new int[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(k);
        while (!pq.isEmpty()) {
            int from = pq.poll();
            for (int i = 1; i <= n; i++) {
                if (arrs[from][i] == -1) {
                    continue;
                }
                if (arrs[from][i] + dist[from] < dist[i]) {
                    dist[i] = arrs[from][i] + dist[from];
                    pq.add(i);
                }
            }
        }
        int res = -1;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
