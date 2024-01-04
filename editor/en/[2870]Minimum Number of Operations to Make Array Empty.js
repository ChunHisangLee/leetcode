//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function (nums) {
    let map = new Map();
    let count = 0;

    for (let num of nums) {
        map.set(num, (map.get(num) || 0) + 1);
    }

    for (let num of map.values()) {
        if (num === 1) {
            return -1;
        }

        if (num % 3 === 0) {
            count += num / 3;
        } else {
            count += Math.floor(num / 3) + 1;
        }
    }

    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
