
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSquareStreak(int[] nums) {
        final int MAX = 100_001;
        int[] dp = new int[MAX];
        int result = 0;
        Arrays.sort(nums);

        for (int num : nums) {
            int root = (int) Math.sqrt(num);

            if (root * root == num && root < MAX) {
                dp[num] = dp[root] + 1;
            } else {
                dp[num] = 1;
            }

            result = Math.max(result, dp[num]);
        }

        return result >= 2 ? result : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
