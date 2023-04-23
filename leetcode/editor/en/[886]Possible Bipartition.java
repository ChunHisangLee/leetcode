886
        Possible Bipartition
        2022-12-21 09:43:09

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0];
            int b = edge[1];
            map.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            map.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, map, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int nodeColor, Map<Integer, List<Integer>> map, int[] color) {
        color[node] = nodeColor;
        if (!map.containsKey(node)) {
            return true;
        }
        for (int neighbor : map.get(node)) {
            if (color[neighbor] == color[node]) {
                return false;
            }
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - nodeColor, map, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
