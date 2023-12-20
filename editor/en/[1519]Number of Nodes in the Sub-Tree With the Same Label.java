1519
        Number of Nodes in the Sub-Tree With the Same Label
        2023-01-12 09:53:16

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
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
        int[] arr = new int[n];
        char[] label = labels.toCharArray();
        dfs(-1, 0, list, label, arr);
        return arr;
    }

    private int[] dfs(int prev, int node, List<List<Integer>> list, char[] label, int[] arr) {
        int[] nodeCount = new int[26];
        nodeCount[label[node] - 'a'] = 1;
        for (int child : list.get(node)) {
            if (child != prev) {
                int[] childCount = dfs(node, child, list, label, arr);
                for (int i = 0; i < 26; i++) {
                    nodeCount[i] += childCount[i];
                }
            }
        }
        arr[node] = nodeCount[label[node] - 'a'];
        return nodeCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
