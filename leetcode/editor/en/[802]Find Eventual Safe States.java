
//leetcode submit region begin(Prohibit modification and deletion)
/*
 "white-gray-black" DFS algorithm
 https://www.youtube.com/watch?v=eWbD1DQfGjo
 */
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(graph, arr, i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean dfs(int[][] graph, int[] arr, int i) {
        if (arr[i] == 2) {
            return true;
        }
        if (arr[i] == 1) {
            return false;
        }
        arr[i] = 1;
        for (int num : graph[i]) {
            if (!dfs(graph, arr, num)) {
                return false;
            }
        }
        arr[i] = 2;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
