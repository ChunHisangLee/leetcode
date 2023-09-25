//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function (nums) {
    let map = new Map();

    for (const num of nums) {
        map.set(num, (map.get(num) || 0) + 1);
    }

    for (let key of map.keys()) {
        if (map.get(key) === 1) {
            return key;
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
