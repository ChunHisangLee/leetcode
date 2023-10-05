//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var isMajorityElement = function (nums, target) {
    let count = 0;

    for (const num of nums) {
        if (num === target) {
            count++;
        }
    }

    return count > Math.floor(nums.length / 2);
};
//leetcode submit region end(Prohibit modification and deletion)
