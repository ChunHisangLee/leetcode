//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                break;
            }

            sum += nums[i];
        }

        while (isContained(nums, sum)) {
            sum++;
        }

        return sum;
    }

    private boolean isContained(int[] nums, int sum) {
        for (int num : nums) {
            if (num == sum) {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
