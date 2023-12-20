//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
    const bar = Math.floor(nums.length / 2);
    let map = new Map();

    for (const num of nums) {
        map.set(num, (map.get(num) || 0) + 1);
    }

    for (const [key, value] of map) {
        if (value > bar) {
            return key;
        }
    }

    return -1;
};
//leetcode submit region end(Prohibit modification and deletion)
