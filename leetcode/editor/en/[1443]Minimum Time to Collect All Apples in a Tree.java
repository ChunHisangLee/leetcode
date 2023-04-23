1443
        Minimum Time to Collect All Apples in a Tree
        2023-01-11 09:27:18

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            list.get(x).add(y);
            list.get(y).add(x);
        }
        boolean[] isVisited = new boolean[n];
        return dfs(0, list, hasApple, isVisited);
    }

    private int dfs(int node, List<List<Integer>> list, List<Boolean> hasApple, boolean[] isVisited) {
        isVisited[node] = true;
        int result = 0;
        for (int child : list.get(node)) {
            if (!isVisited[child]) {
                result += dfs(child, list, hasApple, isVisited);
            }
        }
        if ((result > 0 || hasApple.get(node)) && node != 0) {
            result += 2;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
