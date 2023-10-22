
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k;
        int right = k;
        int min = nums[k];
        int result = nums[k];

        while (left > 0 || right < n - 1) {
            if (left == 0) {
                right++;
            } else if (right == n - 1) {
                left--;
            } else if (nums[left - 1] < nums[right + 1]) {
                right++;
            } else {
                left--;
            }

            min = Math.min(min, Math.min(nums[left], nums[right]));
            result = Math.max(result, min * (right - left + 1));
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
