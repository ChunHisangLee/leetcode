//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
    nums.sort((a, b) => a - b);
    return nums[nums.length - k];
};
//leetcode submit region end(Prohibit modification and deletion)
