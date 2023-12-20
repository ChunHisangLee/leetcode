//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function (arr) {
    const map = new Map();
    for (const num of arr) {
        if (map.has(num)) {
            map.set(num, map.get(num) + 1);
        } else {
            map.set(num, 1);
        }
    }
    const set = new Set(map.values());
    return map.size === set.size;
};
//leetcode submit region end(Prohibit modification and deletion)
