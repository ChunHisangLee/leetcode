
//leetcode submit region begin(Prohibit modification and deletion)
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

- 667ms
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
 */