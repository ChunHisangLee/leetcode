1155
        Number of Dice Rolls With Target Sum
        2023-02-27 13:43:03

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n + 1][target + 1];
        return dpFun(n, k, target, dp);
    }

    public int dpFun(int n, int k, int target, Integer[][] dp) {
        if (target < 0) {
            return 0;
        }
        if (target == 0 && n == 0) {
            return 1;
        } else if (n == 0 || target == 0) {
            return 0;
        }
        if (dp[n][target] != null) {
            return dp[n][target];
        }
        int count = 0;
        for (int i = 1; i <= k; i++) {
            count = (count + dpFun(n - 1, k, target - i, dp)) % MOD;
        }
        dp[n][target] = count;
        return dp[n][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][target + 1];
        dp[n][target] = 1;
        for (int index = n - 1; index >= 0; index--) {
            for (int sum = 0; sum <= target; sum++) {
                int count = 0;
                for (int i = 1; i <= Math.min(k, target - sum); i++) {
                    count = (count + dp[index + 1][sum + i]) % MOD;
                }
                dp[index][sum] = count;
            }
        }
        return dp[0][0];
    }
}
 */