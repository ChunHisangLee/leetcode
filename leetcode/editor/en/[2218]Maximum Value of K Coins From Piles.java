2218
        Maximum Value of K Coins From Piles
        2022-12-14 18:18:05

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] dp = new int[k + 1];
        int[] preSum = new int[k + 1];
        for (List<Integer> pile : piles) {
            int n = Math.min(k, pile.size());
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = sum += pile.get(i - 1);
            }
            for (int i = k; i > 0; i--) {
                int max = 0;
                for (int j = Math.min(i, n); j >= 0; j--) {
                    max = Math.max(max, preSum[j] + dp[i - j]);
                }
                dp[i] = max;
            }
        }
        return dp[k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
