
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target && i + (n / 2) < n) {
                int num = nums[i + (n / 2)];
                if (num == target) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
