
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPairSum(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int max = 0;

        Arrays.sort(nums);

        while (left < right) {
            max = Math.max(max, nums[left++] + nums[right--]);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
