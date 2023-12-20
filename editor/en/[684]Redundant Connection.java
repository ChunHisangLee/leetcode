684
        Redundant Connection
        2023-02-28 16:49:21

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind();
        uf.unionFind(n + 1);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public void unionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public boolean union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x == y) {
            return false;
        }
        if (rank[x] <= rank[y]) {
            rank[y] += rank[x];
            parent[x] = y;
        } else {
            rank[x] += rank[y];
            parent[y] = x;
        }
        return true;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
