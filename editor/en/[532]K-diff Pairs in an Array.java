//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int count = 0;
        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k)
                right++;
            else if (nums[right] - nums[left] > k)
                left++;
            else if (nums[right] - nums[left] == k) {
                count++;
                left++;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
