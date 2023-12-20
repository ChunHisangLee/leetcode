//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] group;
    int count;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        group = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
        for (int[] arr : connections) {
            union(arr[0], arr[1]);
        }
        return count - 1;
    }

    public int find(int x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            group[x] = y;
            count--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
