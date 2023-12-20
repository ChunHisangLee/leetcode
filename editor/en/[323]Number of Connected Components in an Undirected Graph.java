323
        Number of Connected Components in an Undirected Graph
        2022-12-08 09:30:50

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }
}

class UnionFind {
    int[] arr;
    int count;

    public UnionFind(int n) {
        arr = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    public int find(int x) {
        return arr[x] == x ? x : (arr[x] = find(arr[x]));
    }

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            arr[x] = y;
            count--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
