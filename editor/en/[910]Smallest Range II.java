
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n - 1];
        int min = nums[0];
        int res = max - min;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(nums[n - 1] - k, nums[i] + k);
            min = Math.min(nums[0] + k, nums[i + 1] - k);
            res = Math.min(res, max - min);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
