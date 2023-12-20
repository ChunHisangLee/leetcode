//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var numIdenticalPairs = function (nums) {
    let map = new Map();
    let count = 0;

    for (const num of nums) {
        if (!map.has(num)) {
            map.set(num, 0);
        }

        map.set(num, map.get(num) + 1);
    }

    for (const num of map.values()) {
        if (num > 1) {
            count += num * (num - 1) / 2;
        }
    }

    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
/*
var numIdenticalPairs = function (nums) {
    let arr = new Array(101).fill(0);
    let count = 0;

    for (const num of nums) {
        arr[num]++;
    }

    for (const num of arr) {
        if (num > 1) {
            count += num * (num - 1) / 2;
        }
    }

    return count;
};
 */