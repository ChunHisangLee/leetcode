/**
 * An integer array is called arithmetic if it consists of at least three elements
 * and if the difference between any two consecutive elements is the same.
 * <p>
 * <p>
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * <p>
 * <p>
 * <p>
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 * <p>
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,
 * 3,4] itself.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * <p>
 * <p>
 * Related Topics Array Dynamic Programming 👍 5084 👎 286
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int sum = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count++;
            } else {
                sum += countSlices(count);
                count = 0;
            }
        }

        return sum += countSlices(count);
    }

    private int countSlices(int n) {
        return n * (n + 1) / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
