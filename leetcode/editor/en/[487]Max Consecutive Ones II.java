487
        Max Consecutive Ones II
        2022-11-24 14:19:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right;
        int flap = 1;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                flap--;
            }
            if (flap < 0) {
                flap += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
