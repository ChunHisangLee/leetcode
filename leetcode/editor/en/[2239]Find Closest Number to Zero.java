
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findClosestNumber(int[] nums) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                return num;
            }
            if (num > 0) {
                high = Math.min(high, num);
            }
            if (num < 0) {
                low = Math.min(low, 0 - num);
            }
        }
        return high > low ? 0 - low : high;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int findClosestNumber(int[] nums) {
        int index = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return nums[i];
            }
            int abs = Math.abs(nums[i]);
            if (abs < diff) {
                index = i;
                diff = abs;
            } else if (abs == diff && (nums[i] > 0 && nums[index] < 0)) {
                index = i;
            }
        }
        return nums[index];
    }
}
 */