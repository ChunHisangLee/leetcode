//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return len != Integer.MAX_VALUE ? len : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
