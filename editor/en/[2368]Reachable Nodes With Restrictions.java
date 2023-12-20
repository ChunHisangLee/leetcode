2368
        Reachable Nodes With Restrictions
        2022-12-07 09:32:54

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        queue.offer(0);
        isVisited[0] = true;
        for (int node : restricted) {
            isVisited[node] = true;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            res++;
            for (int neighbour : graph[vertex]) {
                if (!isVisited[neighbour]) {
                    queue.offer(neighbour);
                    isVisited[neighbour] = true;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
