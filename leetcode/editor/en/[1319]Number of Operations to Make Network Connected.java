//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] arr;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        arr = new int[n];
        int count = n;
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int[] curr : connections) {
            int x = find(curr[0]);
            int y = find(curr[1]);
            if (x != y) {
                arr[x] = y;
                count--;
            }
        }
        return count - 1;
    }

    private int find(int x) {
        return arr[x] == x ? x : (arr[x] = find(arr[x]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
