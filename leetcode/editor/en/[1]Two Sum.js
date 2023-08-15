//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        if (!map.has(nums[i])) {
            map.set(target - nums[i], i);
        } else {
            return [map.get(nums[i]), i];
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
