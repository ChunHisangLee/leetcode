
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
        }

        int sum = 0;

        for (int num : dp) {
            sum += num;
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
