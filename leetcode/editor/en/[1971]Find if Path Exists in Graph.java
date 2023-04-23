1971
        Find if Path Exists in Graph
        2022-12-19 09:24:56

//leetcode submit region begin(Prohibit modification and deletion)
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