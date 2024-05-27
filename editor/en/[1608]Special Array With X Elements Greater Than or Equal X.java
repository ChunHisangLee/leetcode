
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        if (nums[0] >= n) {
            return n;
        }
su
        for (int i = 1; i < n; i++) {
            if (nums[i] >= n - i) {
                if (nums[i - 1] >= n - i) {
                    return -1;
                }

                return n - i;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
