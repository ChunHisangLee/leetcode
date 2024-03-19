//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int result = 0;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0, isVisited);
        return result;
    }

    public int dfs(int curr, boolean[] isVisited) {
        int first = 0;
        int second = 0;
        isVisited[curr] = true;

        for (Integer item : graph.get(curr)) {
            if (isVisited[item]) {
                continue;
            }

            int len = dfs(item, isVisited);

            if (len > first) {
                second = first;
                first = len;
            } else if (len > second) {
                second = len;
            }

            result = Math.max(result, first + second);
        }

        return first + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
