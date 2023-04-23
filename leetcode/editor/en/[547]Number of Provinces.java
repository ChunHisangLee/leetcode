547
        Numbers of Provinces
        2022-11-26 11:34:33

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    int count;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        count = n;
    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x == y) {
            return;
        }
        if (x != y) {
            if (rank[x] > rank[y]) {
                parent[y] = x;
            } else if (rank[x] < rank[y]) {
                parent[x] = y;
            } else {
                parent[x] = y;
                rank[y]++;
            }
        }
        count--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)