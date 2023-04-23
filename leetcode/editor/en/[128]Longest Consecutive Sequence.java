128
        Longest Consecutive Sequence
        2023-02-28 10:48:25

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return max = Math.max(max, count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
