
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] disc;
    int[] low;
    boolean[] isVisited;
    int time = 1;
    List<List<Integer>> res = new ArrayList<>();
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[n];
        low = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            list.get(conn.get(0)).add(conn.get(1));
            list.get(conn.get(1)).add(conn.get(0));
        }
        for (int i = 0; i < n; i++) {
            if (disc[i] == 0) {
                dfs(i, -1);
            }
        }

        return res;
    }

    public void dfs(int curr, int prev) {
        disc[curr] = low[curr] = time++;
        for (int num : list.get(curr)) {
            if (disc[num] == 0) {
                dfs(num, curr);
                low[curr] = Math.min(low[curr], low[num]);
            } else if (num != prev) {
                low[curr] = Math.min(low[curr], disc[num]);
            }
            if (low[num] > disc[curr]) {
                res.add(Arrays.asList(curr, num));
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
