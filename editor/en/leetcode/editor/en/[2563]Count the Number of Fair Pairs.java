
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long countUpper = countPairs(nums, upper);
        long countLower = countPairs(nums, lower - 1);
        return countUpper - countLower;
    }

    private long countPairs(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        long count = 0;

        while (left < right) {
            long currentSum = (long) nums[left] + nums[right];

            if (currentSum <= target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
