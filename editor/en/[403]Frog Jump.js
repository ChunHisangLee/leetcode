//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} stones
 * @return {boolean}
 */
var canCross = function (stones) {
    let dp = new Map();
    for (const stone of stones) {
        dp.set(stone, new Set());
    }
    dp.get(stones[0]).add(1);
    for (const stone of stones) {
        for (const jump of dp.get(stone)) {
            if (jump > 0 && dp.has(stone + jump)) {
                dp.get(stone + jump).add(jump - 1);
                dp.get(stone + jump).add(jump);
                dp.get(stone + jump).add(jump + 1);
            }
        }
    }
    return dp.get(stones[stones.length - 1]).size > 0;
};
//leetcode submit region end(Prohibit modification and deletion)
/*
var canCross = function (stones) {
    if (stones[1] !== 1) {
        return false;
    }
    let dp = new Map();
    for (let stone of stones) {
        dp.set(stone, new Set());
    }
    dp.get(stones[0]).add(1);
    for (let stone of stones) {
        for (let jump of dp.get(stone)) {
            if (jump !== 0 && dp.has(stone + jump)) {
                dp.get(stone + jump).add(jump);
                dp.get(stone + jump).add(jump + 1);
                dp.get(stone + jump).add(jump - 1);
            }
        }
    }
    return dp.get(stones[stones.length - 1]).size > 0;
};
 */