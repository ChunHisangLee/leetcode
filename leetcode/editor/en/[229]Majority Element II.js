//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function (nums) {
    const n = nums.length;
    let list = [];
    const bar = Math.floor(n / 3);
    let count = 1;

    nums.sort((a, b) => a - b);

    for (let i = 1; i < n; i++) {
        if (nums[i] === nums[i - 1]) {
            count++;
            continue;
        }

        if (count > bar) {
            list.push(nums[i - 1]);
        }

        count = 1;
    }

    if (count > bar) {
        list.push(nums[n - 1]);
    }

    return list;
};
//leetcode submit region end(Prohibit modification and deletion)
/*
var majorityElement = function (nums) {
    let list = [];
    let map = new Map();
    const bar = Math.floor(nums.length / 3);

    for (const num of nums) {
        map.set(num, (map.get(num) || 0) + 1);
    }

    for (let [key, value] of map) {
        if (value > bar) {
            list.push(key);
        }
    }

    return list;
};
 */