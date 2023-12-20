//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[][]} rectangles
 * @return {number}
 */
var interchangeableRectangles = function (rectangles) {
    let map = new Map();
    let count = 0;

    for (const [x, y] of rectangles) {
        const ratio = x / y;
        if (!map.has(ratio)) {
            map.set(ratio, 1);
        } else {
            map.set(ratio, map.get(ratio) + 1);
        }
    }

    for (const num of map.values()) {
        if (num > 1) {
            count += num * (num - 1) / 2;
        }
    }

    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
