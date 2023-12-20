
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        int count = queries.length;
        boolean[] res = new boolean[count];
        int[][] arrs = new int[count][4];
        for (int i = 0; i < count; ++i) {
            arrs[i][0] = queries[i][0];
            arrs[i][1] = queries[i][1];
            arrs[i][2] = queries[i][2];
            arrs[i][3] = i;
        }
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Arrays.sort(arrs, (a, b) -> a[2] - b[2]);
        int edgesIndex = 0;
        for (int queryIndex = 0; queryIndex < count; queryIndex += 1) {
            int p = arrs[queryIndex][0];
            int q = arrs[queryIndex][1];
            int limit = arrs[queryIndex][2];
            int queryOriginalIndex = arrs[queryIndex][3];
            while (edgesIndex < edgeList.length && edgeList[edgesIndex][2] < limit) {
                int x = edgeList[edgesIndex][0];
                int y = edgeList[edgesIndex][1];
                uf.join(x, y);
                edgesIndex += 1;
            }
            res[queryOriginalIndex] = uf.areConnected(p, q);
        }
        return res;
    }
}

class UnionFind {
    private int[] group;
    private int[] rank;

    UnionFind(int size) {
        group = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; ++i) {
            group[i] = i;
        }
    }

    public int find(int x) {
        return group[x] == x ? group[x] : (group[x] = find(group[x]));
    }

    public void join(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x == y) {
            return;
        }
        if (rank[x] > rank[y]) {
            group[y] = x;
        } else if (rank[x] < rank[y]) {
            group[x] = y;
        } else {
            group[x] = y;
            rank[y]++;
        }
    }

    public boolean areConnected(int i, int j) {
        int x = find(i);
        int y = find(j);
        return x == y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
