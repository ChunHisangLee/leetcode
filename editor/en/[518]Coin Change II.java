518
        Coin Change II
        2023-01-11 20:19:04

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-down - 13ms
class Solution {
    Integer[][] dp;

    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        return dyP(amount, coins, 0);
    }

    private int dyP(int amount, int[] coins, int i) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }
        if (dp[i][amount] != null) {
            return dp[i][amount];
        }
        if (coins[i] > amount) {
            return dp[i][amount] = dyP(amount, coins, i + 1);
        }
        return dp[i][amount] = dyP(amount - coins[i], coins, i) + dyP(amount, coins, i + 1);
    }
}

Bottom-Up - 2ms
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
 */