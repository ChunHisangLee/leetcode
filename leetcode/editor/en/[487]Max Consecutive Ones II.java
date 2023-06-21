487
        Max Consecutive Ones II
        2022-11-24 14:19:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int res = 0;
        // initialize the zero position to -1;
        int curr = -1;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                if (curr == -1) {
                    curr = right;
                } else {
                    res = Math.max(res, right - left);
                    left = curr + 1;
                    curr = right;
                }
            }
        }
        return Math.max(res, n - left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
