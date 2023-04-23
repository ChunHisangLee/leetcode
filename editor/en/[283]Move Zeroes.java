// 283
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int len = nums.length;
        while (left < len && nums[left] != 0) {
            left++;
        }
        int right = left + 1;
        while (right < len && nums[right] == 0) {
            right++;
        }
        while (left < len && right < nums.length) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            while (right < len && nums[right] == 0) {
                right++;
            }
            left++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
