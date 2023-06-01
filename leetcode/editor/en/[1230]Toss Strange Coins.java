
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] dp = new double[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
            for (int j = Math.min(i + 1, target); j > 0; j--) {
                dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i - 1]);
            }
        }
        return dp[n][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DP - Top-Down - 63ms
class Solution {
    double[][] dp;

    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        dp = new double[n][target + 1];
        for (double[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dyP(prob, target, 0, n);
    }

    public double dyP(double[] prob, int target, int index, int n) {
        if (target < 0) {
            return 0;
        }
        if (index == n) {
            return target == 0 ? 1 : 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        dp[index][target] = dyP(prob, target - 1, index + 1, n) * prob[index] + dyP(prob, target, index + 1, n) * (1 - prob[index]);
        return dp[index][target];
    }
}

DP - Bottom-up  -12ms
class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] dp = new double[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
             for (int j = Math.min(i + 1, target); j > 0; j--) {
                dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i - 1]);
            }
        }
        return dp[n][target];
    }
}

DP - Bottom-up  -8ms
class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        double[] dp = new double[target + 1];
        dp[0] = 1.0;
        for (int i = 0; i < prob.length; i++) {
            for (int j = Math.min(i + 1, target); j > 0; j--) {
                dp[j] = prob[i] * dp[j - 1] + (1 - prob[i]) * dp[j];
            }
            dp[0] = (1 - prob[i]) * dp[0];
        }
        return dp[target];
    }
}
 */