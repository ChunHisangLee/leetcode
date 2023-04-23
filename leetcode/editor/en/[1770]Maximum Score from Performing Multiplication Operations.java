1770
        Maximum Score from Performing Multiplication Operations
        2023-02-20 15:33:22

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        int[][] dp = new int[m + 1][m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int right = n - 1 - (i - left);
                dp[i][left] = Math.max(multipliers[i] * nums[left] + dp[i + 1][left + 1], multipliers[i] * nums[right] + dp[i + 1][left]);
            }
        }
        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
