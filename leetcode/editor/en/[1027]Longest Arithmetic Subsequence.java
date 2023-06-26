
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int res = 2;
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int right = 0; right < n; right++) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; left++) {
                int diff = nums[right] - nums[left];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[right].get(diff));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
