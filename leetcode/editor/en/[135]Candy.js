//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function (ratings) {
    const n = ratings.length;
    let dp = new Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) {
            dp[i] = dp[i - 1] + 1;
        }
    }
    for (let i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            dp[i] = Math.max(dp[i], dp[i + 1] + 1);
        }
    }
    let sum = 0;
    for (const num of dp) {
        sum += num;
    }
    return sum;
};
//leetcode submit region end(Prohibit modification and deletion)
