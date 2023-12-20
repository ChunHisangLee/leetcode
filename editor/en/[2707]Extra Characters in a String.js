//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @param {string} s
 * @param {string[]} dictionary
 * @return {number}
 */
var minExtraChar = function (s, dictionary) {
    const n = s.length;
    let dp = new Array(n + 1).fill(0);
    for (let i = n - 1; i >= 0; i--) {
        const str = s.substring(i);
        dp[i] = dp[i + 1] + 1;
        for (let j = 0; j < dictionary.length; j++) {
            if (str.startsWith(dictionary[j])) {
                dp[i] = Math.min(dp[i], dp[i + dictionary[j].length]);
            }
        }
        return dp[0];
    }
};
//leetcode submit region end(Prohibit modification and deletion)