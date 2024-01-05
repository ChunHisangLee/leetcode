//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
    let dp = [];

    for (const num of nums) {
        if (dp.length === 0 || num > dp[dp.length - 1]) {
            dp.push(num);
        } else {
            let index = dp.findIndex(n => n >= num);

            if (index < 0) {
                index = -(index + 1);
            }

            dp[index] = num;

        }
    }

    return dp.length;
};
//leetcode submit region end(Prohibit modification and deletion)
/*
var lengthOfLIS = function (nums) {
    let n = nums.length;
    let dp = new Array(n).fill(1);
    let max = 1;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        max = Math.max(max, dp[i]);
    }

    return max;
};
 */