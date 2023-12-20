//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
