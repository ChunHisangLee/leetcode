//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxK = function (nums) {
    const numSet = new Set(nums);
    let max = -1;

    for (const num of nums) {
        if (numSet.has(-num) && num > max) {
            max = num;
        }
    }

    return max;
};
//leetcode submit region end(Prohibit modification and deletion)
