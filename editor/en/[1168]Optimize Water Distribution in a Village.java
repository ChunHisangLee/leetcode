
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < wells.length; i++) {
            pq.add(new int[]{0, i + 1, wells[i]});
        }
        for (int[] pipe : pipes) {
            pq.add(pipe);
        }
        UnionFind uf = new UnionFind(n + 1);
        int count = 1;
        int res = 0;
        while (count < n + 1) {
            int[] curr = pq.poll();
            if (uf.union(curr[0], curr[1])) {
                count++;
                res += curr[2];
            }
        }
        return res;
    }
}

class UnionFind {
    private int[] group;

    public UnionFind(int n) {
        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    private int find(int x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    public boolean union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x == y) {
            return false;
        }
        group[x] = y;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
