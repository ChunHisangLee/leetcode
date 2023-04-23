//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    boolean[] isVisited;
    int count = 0;

    public int minReorder(int n, int[][] connections) {

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : connections) {
            list.get(edge[0]).add(-edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        isVisited = new boolean[n];
        dfs(0);
        return count;
    }

    private void dfs(int parent) {
        isVisited[parent] = true;
        for (int next : list.get(parent)) {
            if (!isVisited[Math.abs(next)]) {
                if (next < 0) {
                    count++;
                }
                dfs(Math.abs(next));
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
