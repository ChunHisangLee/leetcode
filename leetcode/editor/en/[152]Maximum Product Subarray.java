152
        Maximum Product Subarray
        2023-02-02 16:53:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = max;
            int preMin = min;
            int curr = nums[i];
            if (curr < 0) {
                max = Math.max(preMin * curr, curr);
                min = Math.min(preMax * curr, curr);
            } else {
                max = Math.max(preMax * curr, curr);
                min = Math.min(preMin * curr, curr);
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
