
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) {
            return 0;
        }
        int target = (1 << n) - 1;
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] dp = new boolean[n][target + 1];
        int res = 0;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int[] list : graph) {
            min = Math.min(min, list.length);
        }
        for (int i = 0; i < n; i++) {
            if (graph[i].length == min) {
                dq.add(new int[]{i, 1 << i});
                dp[i][i << 1] = true;
            }
        }
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                for (int next : graph[curr[0]]) {
                    int newVal = curr[1] | (1 << next);
                    if (newVal == target) {
                        return res + 1;
                    }
                    if (!dp[next][newVal]) {
                        dq.add(new int[]{next, newVal});
                        dp[next][newVal] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
