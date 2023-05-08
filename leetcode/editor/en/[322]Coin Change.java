//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    int[] arr;

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        arr = new int[amount];
        return dp(coins, arr, amount);
    }

    private int dp(int[] coins, int[] arr, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (arr[amount - 1] != 0) {
            return arr[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount >= coin) {
                int res = dp(coins, arr, amount - coin);
                if (res >= 0 && res < min) {
                    min = 1 + res;
                }
            }
        }
        arr[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return arr[amount - 1];
    }
}
 */