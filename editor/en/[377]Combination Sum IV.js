//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function (nums, target) {
    const map = new Map();
    return dyP(nums, target);

    function dyP(nums, target) {
        if (target === 0) {
            return 1;
        }
        if (map.has(target)) {
            return map.get(target);
        }
        let res = 0;
        for (let num of nums) {
            if (target >= num) {
                res += dyP(nums, target - num);
            }
        }
        map.set(target, res);
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
/*
- 56ms
var combinationSum4 = function (nums, target) {
    const map = new Map();
    return dyP(nums, target);

    function dyP(nums, target) {
        if (target === 0) {
            return 1;
        }
        if (map.has(target)) {
            return map.get(target);
        }
        let res = 0;
        for (let num of nums) {
            if (target >= num) {
                res += dyP(nums, target - num);
            }
        }
        map.set(target, res);
        return res;
    }
};

- 60ms
var combinationSum4 = function (nums, target) {
    let dp = new Array(target + 1).fill(0);
    dp[0] = 1;
    for (let i = 0; i <= target; i++) {
        for (let num of nums) {
            if (i >= num) {
                dp[i] += dp[i - num];
            }
        }
    }
    return dp[target];
};
 */