
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (edges.length < n - 1) {
            return -1;
        }

        int[] parentAlice = new int[n + 1];

        for (int i = 0; i < parentAlice.length; i++) {
            parentAlice[i] = i;
        }

        int numType3Edges = 0;

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (union(parentAlice, edge[1], edge[2])) {
                    numType3Edges++;
                }
            }
        }

        int[] parentBob = parentAlice.clone();
        int numType1Edges = 0;

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (union(parentAlice, edge[1], edge[2])) {
                    numType1Edges++;
                }
            }
        }

        if (numType1Edges + numType3Edges + 1 != n) {
            return -1;
        }

        int numType2Edges = 0;

        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (union(parentBob, edge[1], edge[2])) {
                    numType2Edges++;
                }
            }
        }

        if (numType2Edges + numType3Edges + 1 != n) {
            return -1;
        }

        return edges.length - numType1Edges - numType2Edges - numType3Edges;
    }

    int find(int[] parent, int x) {
        return parent[x] == x ? parent[x] : (parent[x] = find(parent, parent[x]));
    }

    boolean union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);

        if (x == y) {
            return false;
        }

        parent[y] = x;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
