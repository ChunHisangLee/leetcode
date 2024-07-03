
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;
        return Arrays.stream(new int[]{
                        nums[n - 4] - nums[0],
                        nums[n - 3] - nums[1],
                        nums[n - 2] - nums[2],
                        nums[n - 1] - nums[3]})
                .min()
                .getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
