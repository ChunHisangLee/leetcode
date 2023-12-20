1299
        Replace Elements with Greatest Element on Right Side
        2023-01-18 11:03:19

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] replaceElements(int[] arr) {
        int n = 0;
        for (int num : arr) {
            if (num > 0) {
                n++;
            }
        }
        int[] dp = new int[n];
        dp[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], arr[i + 1]);
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
