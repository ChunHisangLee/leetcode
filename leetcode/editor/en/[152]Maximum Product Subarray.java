152
        Maximum Product Subarray
        2023-02-02 16:53:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(max * curr, min * curr));
            min = Math.min(curr, Math.min(max * curr, min * curr));
            max = temp;
            res = Math.max(res, max);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
