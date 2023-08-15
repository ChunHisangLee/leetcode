//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
    let dp = [1, 1];
    for (let i = 2; i < n + 1; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
};
//leetcode submit region end(Prohibit modification and deletion)
