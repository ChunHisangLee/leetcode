
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] <= nums[i]) {
                    left++;
                } else {
                    count += right - left;
                    right--;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
