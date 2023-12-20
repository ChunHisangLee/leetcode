//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isMonotonic = function (nums) {
    let n = nums.length;

    if (nums[0] < nums[n - 1]) {
        for (let i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
    } else {
        for (let i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                return false;
            }
        }
    }

    return true;
};
//leetcode submit region end(Prohibit modification and deletion)
