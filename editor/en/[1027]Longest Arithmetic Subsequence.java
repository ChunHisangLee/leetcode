
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
- 52ms
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int diff = max - min;
        int n = nums.length;
        int[][] dp = new int[n][diff * 2 + 1];
        int res = 2;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = nums[i] - nums[j] + diff;
                dp[i][temp] = dp[j][temp] == 0 ? 2 : dp[j][temp] + 1;
                res = Math.max(res, dp[i][temp]);
            }
        }
        return res;
    }
}

- 621ms
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }
}
 */