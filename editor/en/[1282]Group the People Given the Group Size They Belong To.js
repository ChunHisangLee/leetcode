//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} groupSizes
 * @return {number[][]}
 */
var groupThePeople = function (groupSizes) {
    const res = [];
    let map = new Map();
    for (let i = 0; i < groupSizes.length; i++) {
        const size = groupSizes[i];
        if (!map.has(size)) {
            map.set(size, []);
        }
        map.get(size).push(i);
        if (map.get(size).length === size) {
            res.push(map.get(size));
            map.set(size, []);
        }
    }
    return res;
};
//leetcode submit region end(Prohibit modification and deletion)
