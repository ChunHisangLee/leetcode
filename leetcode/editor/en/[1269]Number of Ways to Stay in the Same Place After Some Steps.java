
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] memo;
    final int MOD = (int) 1e9 + 7;
    int arrLen;

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps / 2 + 1);
        this.arrLen = arrLen;
        memo = new Integer[arrLen][steps + 1];

        return dp(0, steps);
    }

    private int dp(int curr, int remain) {
        if (remain == 0) {
            return curr == 0 ? 1 : 0;
        }

        if (memo[curr][remain] != null) {
            return memo[curr][remain];
        }

        int result = dp(curr, remain - 1);

        if (curr > 0) {
            result = (result + dp(curr - 1, remain - 1)) % MOD;
        }

        if (curr < arrLen - 1) {
            result = (result + dp(curr + 1, remain - 1)) % MOD;
        }

        memo[curr][remain] = result;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    Integer[][] memo;
    final int MOD = (int) 1e9 + 7;
    int arrLen;

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        this.arrLen = arrLen;
        memo = new Integer[arrLen][steps + 1];

        return dp(0, steps);
    }

    private int dp(int curr, int remain) {
        if (remain == 0) {
            return curr == 0 ? 1 : 0;
        }

        if (memo[curr][remain] != null) {
            return memo[curr][remain];
        }

        int result = dp(curr, remain - 1);

        if (curr > 0) {
            result = (result + dp(curr - 1, remain - 1)) % MOD;
        }

        if (curr < arrLen - 1) {
            result = (result + dp(curr + 1, remain - 1)) % MOD;
        }

        memo[curr][remain] = result;
        return result;
    }
}

class Solution {
    public int numWays(int steps, int arrLen) {
        final int MOD = (int) 1e9 + 7;
        arrLen = Math.min(arrLen, steps / 2 + 1);
        int[][] dp = new int[arrLen][steps + 1];

        dp[0][0] = 1;

        for (int remain = 1; remain <= steps; remain++) {
            for (int curr = arrLen - 1; curr >= 0; curr--) {
                int result = dp[curr][remain - 1];

                if (curr > 0) {
                    result = (result + dp[curr - 1][remain - 1]) % MOD;
                }

                if (curr < arrLen - 1) {
                    result = (result + dp[curr + 1][remain - 1]) % MOD;
                }

                dp[curr][remain] = result;
            }
        }

        return dp[0][steps];
    }
}
 */