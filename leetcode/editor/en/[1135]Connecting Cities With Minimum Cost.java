
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumCost(int n, int[][] connections) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] conn : connections) {
            pq.add(conn);
        }
        UnionFind uf = new UnionFind(n);
        int count = 1;
        int res = 0;
        while (!pq.isEmpty() && count < n) {
            int[] curr = pq.poll();
            if (uf.union(curr[0], curr[1])) {
                res += curr[2];
                count++;
            }
        }
        return count == n ? res : -1;
    }
}

class UnionFind {
    private int[] group;

    public UnionFind(int n) {
        group = new int[n + 1];
        for (int i = 1; i <= n; i++) {
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