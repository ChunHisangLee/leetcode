
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] pre1 = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre1[i + 1] = pre1[i] + grid[1][i];
        }

        long[] suf0 = new long[n + 1];
        suf0[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suf0[i] = suf0[i + 1] + grid[0][i];
        }

        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long maxVal = Math.max(pre1[i], suf0[i + 1]);
            res = Math.min(res, maxVal);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
