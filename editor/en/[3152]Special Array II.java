//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            prefix[i + 1] = prefix[i] + ((nums[i] % 2) == (nums[i + 1] % 2) ? 1 : 0);
        }

        prefix[n] = prefix[n - 1];

        int q = queries.length;
        boolean[] result = new boolean[q];

        for (int i = 0; i < q; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            if (from == to) {
                result[i] = true;
            } else {
                int badCount = prefix[to] - prefix[from];
                result[i] = badCount == 0;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
