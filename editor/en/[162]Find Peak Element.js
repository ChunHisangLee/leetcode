//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function (nums) {
    if (nums.length == 1) {
        return 0;
    }

    let left = 0;
    let right = nums.length - 1;

    while (left < right) {
        const mid = (left + right) >> 1;
        if (nums[mid] < nums[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
};
//leetcode submit region end(Prohibit modification and deletion)
