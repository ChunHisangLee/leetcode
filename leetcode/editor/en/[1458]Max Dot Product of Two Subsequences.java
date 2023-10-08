
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int num : nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }

        for (int num : nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }

        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin;
        }

        if (secondMax < 0 && firstMin > 0) {
            return secondMax * firstMin;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = nums1[i] * nums2[j] + dp[i + 1][j + 1];

                dp[i][j] = Math.max(product, Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }

        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    int[][] memo;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        memo = new int[nums1.length][nums2.length];

        for (int num : nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }

        for (int num : nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }

        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin;
        }

        if (secondMax < 0 && firstMin > 0) {
            return secondMax * firstMin;
        }

        return dp(0, 0, nums1, nums2);
    }

    private int dp(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int product = nums1[i] * nums2[j] + dp(i + 1, j + 1, nums1, nums2);
        memo[i][j] = Math.max(product, Math.max(dp(i + 1, j, nums1, nums2), dp(i, j + 1, nums1, nums2)));
        return memo[i][j];
    }
}
 */
