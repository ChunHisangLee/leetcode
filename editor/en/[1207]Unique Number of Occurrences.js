//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function (arr) {
    const map = new Map();

    for (const num of arr) {
        map.set(num, (map.get(num) || 0) + 1);
    }

    const set = new Set(map.values());
    return map.size === set.size;
};
//leetcode submit region end(Prohibit modification and deletion)
