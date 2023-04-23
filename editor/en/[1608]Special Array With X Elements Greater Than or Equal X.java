import java.util.Arrays;

// 1608
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int specialArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] >= len)
            return len;
        for (int i = 1; i < len; i++) {
            if (nums[i] >= len - i) {
                if (nums[i - 1] >= len - i) {
                    return -1;
                }
                return len - i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
