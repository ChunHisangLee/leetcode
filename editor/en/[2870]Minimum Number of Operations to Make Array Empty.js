//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function (nums) {
    nums.sort((a, b) => a - b);
    let count = 0;
    let left = 0;

    while (left < nums.length) {
        let right = left;

        while (right < nums.length && nums[left] === nums[right]) {
            right++;
        }

        let num = right - left;

        if (num === 1) {
            return -1;
        }

        count += Math.ceil(num / 3);
        left = right;
    }

    return count;
};
//leetcode submit region end(Prohibit modification and deletion)
/*
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

        count += Math.ceil(num / 3);
    }

    return count;
};
 */