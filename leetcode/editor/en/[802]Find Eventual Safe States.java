
//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 "white-gray-black" DFS algorithm
 */
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, arr, graph)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean dfs(int i, int[] arr, int[][] graph) {
        if (arr[i] > 0) {
            return arr[i] == 2;
        }
        arr[i] = 1;
        for (int num : graph[i]) {
            if (arr[num] == 2) {
                continue;
            }
            if (arr[num] == 1 || !dfs(num, arr, graph)) {
                return false;
            }
        }
        arr[i] = 2;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
