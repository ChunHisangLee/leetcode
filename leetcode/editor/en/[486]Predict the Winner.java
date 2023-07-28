
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] dp;

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];
        return dyP(nums, 0, n - 1, n) >= 0;
    }

    private int dyP(int[] nums, int left, int right, int n) {
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        if (left == right) {
            return nums[left];
        }
        int scoreLeft = nums[left] - dyP(nums, left + 1, right, n);
        int scoreRight = nums[right] - dyP(nums, left, right - 1, n);
        dp[left][right] = Math.max(scoreLeft, scoreRight);
        return dp[left][right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-Down - 0ms
class Solution {
    Integer[][] dp;

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];
        return dyP(nums, 0, n - 1, n) >= 0;
    }

    private int dyP(int[] nums, int left, int right, int n) {
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        if (left == right) {
            return nums[left];
        }
        int scoreLeft = nums[left] - dyP(nums, left + 1, right, n);
        int scoreRight = nums[right] - dyP(nums, left, right - 1, n);
        dp[left][right] = Math.max(scoreLeft, scoreRight);
        return dp[left][right];
    }
}

Bottom-Up - 0ms
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int index = 1; index < n; index++) {
            for (int left = 0; left < n - index; left++) {
                int right = left + index;
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right], nums[right] - dp[left][right - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
 */