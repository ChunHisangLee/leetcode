//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = getMaxSum(arr, k, dp, i);
        }

        return dp[n];
    }

    private int getMaxSum(int[] arr, int k, int[] dp, int i) {
        int max = 0;
        int maxSum = 0;

        for (int j = 1; j <= k && i - j >= 0; j++) {
            max = Math.max(max, arr[i - j]);
            maxSum = Math.max(maxSum, dp[i - j] + max * j);
        }

        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
