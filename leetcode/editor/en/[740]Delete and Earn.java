740
        Delete and Earn
        2023-02-20 10:46:32

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num] += num;
        }
        dp[1] = count[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i]);
        }
        return dp[max];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
