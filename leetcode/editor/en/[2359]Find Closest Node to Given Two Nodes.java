2359
        Find Closest Node to Given Two Nodes
        2023-01-25 09:45:23

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        Arrays.fill(arr1, Integer.MAX_VALUE);
        Arrays.fill(arr2, Integer.MAX_VALUE);
        bfs(node1, arr1, edges, n);
        bfs(node2, arr2, edges, n);
        int res = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (arr1[i] == Integer.MAX_VALUE || arr2[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (res > Math.max(arr1[i], arr2[i])) {
                node = i;
                res = Math.max(arr1[i], arr2[i]);
            }
        }
        return node;
    }

    void bfs(int src, int[] dist, int[] edge, int n) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(src);
        dist[src] = 0;
        while (!dq.isEmpty()) {
            int p = dq.remove();
            if (edge[p] != -1 && dist[edge[p]] == Integer.MAX_VALUE) {
                dq.add(edge[p]);
                dist[edge[p]] = dist[p] + 1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
