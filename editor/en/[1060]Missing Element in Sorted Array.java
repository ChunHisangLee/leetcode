
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] - nums[0] - mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[0] + k + left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
