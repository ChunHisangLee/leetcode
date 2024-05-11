//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSumLeft = new int[n];
        int[] prefixSumRight = new int[n];

        for (int i = 1; i < n; i++) {
            prefixSumLeft[i] = prefixSumLeft[i - 1] + nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            prefixSumRight[i] = prefixSumRight[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSumLeft[i] == prefixSumRight[i]) {
                return i;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
