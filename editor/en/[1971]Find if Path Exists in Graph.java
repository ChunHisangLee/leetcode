//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.isConnected(source, destination);
    }
}

public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(arr, edge[0]);
            int y = find(arr, edge[1]);
            if (x != y) {
                arr[x] = y;
            }
        }
        return find(arr, source) == find(arr, destination);
    }

    public int find(int[] arr, int x) {
        return arr[x] == x ? x : (arr[x] = find(arr, arr[x]));
    }
}
 */