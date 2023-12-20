
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] right = new int[n];
        int left = 0;
        long res = 0;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] | nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, left | (long) nums[i] << k | right[i]);
            left |= nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
