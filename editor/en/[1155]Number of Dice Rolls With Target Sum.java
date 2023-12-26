1155
Number of
Dice Rolls
With Target
Sum
        2023-02-27 13:43:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] memo = new Integer[n + 1][target + 1];
        return getCount(n, k, target, memo);
    }

    private int getCount(int n, int k, int target, Integer[][] memo) {
        if (n == 0 && target == 0) {
            return 1;
        }

        if (n == 0 || target == 0) {
            return 0;
        }

        if (memo[n][target] != null) {
            return memo[n][target];
        }

        int count = 0;

        for (int i = 1; i <= k; i++) {
            if (target >= i) {
                count = (count + getCount(n - 1, k, target - i, memo)) % MOD;
            }
        }
        memo[n][target] = count;
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int sum=0;
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j - l >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                    }
                }
            }
        }

        return dp[n][target];
    }
}
 */