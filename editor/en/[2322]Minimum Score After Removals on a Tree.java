
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<Integer>[] graph;
    private int[] nums;
    private int[] subXor;
    private int[] tin;
    private int[] tout;
    private int timer;
    private int[] parent;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        subXor = new int[n];
        tin = new int[n];
        tout = new int[n];
        parent = new int[n];
        parent[0] = -1;
        timer = 0;

        dfs(0, -1);

        int totalXor = subXor[0];

        List<Integer> cutChild = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (parent[u] == v) {
                cutChild.add(u);
            } else {
                cutChild.add(v);
            }
        }

        int ans = Integer.MAX_VALUE;
        int m = cutChild.size();

        for (int i = 0; i < m; i++) {
            int x = cutChild.get(i);
            for (int j = i + 1; j < m; j++) {
                int y = cutChild.get(j);

                int a, b, c;
                if (isAncestor(x, y)) {
                    a = subXor[y];
                    b = subXor[x] ^ subXor[y];
                    c = totalXor ^ subXor[x];
                } else if (isAncestor(y, x)) {
                    a = subXor[x];
                    b = subXor[y] ^ subXor[x];
                    c = totalXor ^ subXor[y];
                } else {
                    a = subXor[x];
                    b = subXor[y];
                    c = totalXor ^ subXor[x] ^ subXor[y];
                }

                int max = Math.max(a, Math.max(b, c));
                int min = Math.min(a, Math.min(b, c));
                ans = Math.min(ans, max - min);
            }
        }

        return ans;
    }

    private void dfs(int u, int parent) {
        this.parent[u] = parent;
        tin[u] = ++timer;
        int xor = nums[u];
        for (int v : graph[u]) {
            if (v == parent) {
                continue;
            }
            dfs(v, u);
            xor ^= subXor[v];
        }
        subXor[u] = xor;
        tout[u] = ++timer;
    }

    private boolean isAncestor(int x, int y) {
        return tin[x] <= tin[y] && tout[y] <= tout[x];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
