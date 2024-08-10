//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n * 4);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int root = (i * n + j) * 4;

                if (grid[i].charAt(j) != '/') {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                }
                if (grid[i].charAt(j) != '\\') {
                    uf.union(root + 0, root + 3);
                    uf.union(root + 2, root + 1);
                }

                if (i > 0) {
                    uf.union(root + 0, root - 4 * n + 2);
                }
                if (j > 0) {
                    uf.union(root + 3, root - 4 + 1);
                }
            }
        }

        return uf.getCount();
    }
}

class UnionFind {
    private int[] parent;
    private int count;

    public UnionFind(int size) {
        parent = new int[size];
        count = size;

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
