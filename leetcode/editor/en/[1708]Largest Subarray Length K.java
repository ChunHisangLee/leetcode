1708
        Largest Subarray Length K
        2023-02-27 11:00:29

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int n = nums.length;
        int index = 0;
        for (int i = 1; i <= n - k; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return Arrays.copyOfRange(nums, index, index + k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
