1129
        Shortest Path with Alternating Colors
        2023-02-11 11:59:21

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : redEdges) {
            list.get(edge[0]).add(new int[]{edge[1], 0});
        }
        for (int[] edge : blueEdges) {
            list.get(edge[0]).add(new int[]{edge[1], 1});
        }
        int[][] dist = new int[n][2];
        for (int[] arr : dist) {
            Arrays.fill(arr, -1);
        }
        dist[0] = new int[]{0, 0};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});
        dq.add(new int[]{0, 1});
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int[] arr : list.get(curr[0])) {
                if (curr[1] == arr[1]) {
                    continue;
                }
                if (dist[arr[0]][arr[1]] == -1) {
                    dist[arr[0]][arr[1]] = dist[curr[0]][curr[1]] + 1;
                    dq.add(new int[]{arr[0], arr[1], dist[arr[0]][arr[1]]});
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1 || dist[i][1] == -1) {
                res[i] = Math.max(dist[i][0], dist[i][1]);
            } else {
                res[i] = Math.min(dist[i][0], dist[i][1]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
