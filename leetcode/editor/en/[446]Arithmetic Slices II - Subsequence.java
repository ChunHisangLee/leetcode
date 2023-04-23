446
        Arithmetic Slices II-Subsequence
        2022-11-27 08:31:48

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> numToIndices = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            numToIndices.putIfAbsent((long) nums[i], new ArrayList<>());
            numToIndices.get((long) nums[i]).add(i);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long target = nums[j] * 2L - nums[i];
                if (numToIndices.containsKey(target)) {
                    for (final int k : numToIndices.get(target))
                        if (k < j)
                            dp[i][j] += (dp[j][k] + 1);
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
