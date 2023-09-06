//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function (nums) {
    let set = new Set(nums);
    return nums.length !== set.size;
};
//leetcode submit region end(Prohibit modification and deletion)
