685
        Redundant Connection II
        2023-02-28 17:12:23

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = -1;
            arr[i] = i;
        }
        int first = -1;
        int second = -1;
        int last = -1;
        for (int k = 0; k < n; k++) {
            int i = edges[k][0];
            int j = edges[k][1];
            if (parent[j] != -1) {
                first = parent[j];
                second = k;
                continue;
            }
            parent[j] = k;
            int x = find(arr, i);
            if (x == j) {
                last = k;
            } else {
                arr[j] = x;
            }
        }
        if (last == -1) {
            return edges[second];
        }
        if (second == -1) {
            return edges[last];
        }
        return edges[first];
    }

    private int find(int[] arr, int x) {
        return arr[x] == x ? x : (arr[x] = find(arr, arr[x]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)