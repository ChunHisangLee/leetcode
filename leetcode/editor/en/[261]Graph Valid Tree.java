261
        Graph Valid Tree
        2023-02-03 09:46:06

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false;
            }
        }
        return edges.length == n - 1;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    int count = 0;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
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
        if (x != y) {
            if (rank[x] > rank[y]) {
                parent[y] = x;
            } else if ((rank[x] < rank[y])) {
                parent[x] = y;
            } else {
                parent[y] = x;
                rank[y]++;
            }
        }
        count++;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
